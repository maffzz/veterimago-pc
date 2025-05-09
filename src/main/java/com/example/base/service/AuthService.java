package com.example.base.service;

import com.example.base.domain.UserAccount;
import com.example.base.event.WelcomeEmailEvent;
import com.example.base.event.YoureBackEmailEvent;
import com.example.base.dto.JwtAuthenticationResponse;
import com.example.base.dto.SigninRequest;
import com.example.base.repository.UserAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserAccountRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final ApplicationEventPublisher applicationEventPublisher;

    public JwtAuthenticationResponse signup(UserAccount user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        UserAccount savedUser = userRepository.save(user);
        applicationEventPublisher.publishEvent(new WelcomeEmailEvent(this, savedUser.getEmail(), savedUser.getFirstName()));
        var jwt = jwtService.generateToken(user);

        JwtAuthenticationResponse response = new JwtAuthenticationResponse();
        response.setToken(jwt);

        return response;}

    public JwtAuthenticationResponse signin(SigninRequest request) throws IllegalArgumentException {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user = userRepository.findByEmail(request.getEmail());
        applicationEventPublisher.publishEvent(new YoureBackEmailEvent(this, user.getEmail(), user.getFirstName()));

        var jwt = jwtService.generateToken(user);
        JwtAuthenticationResponse response = new JwtAuthenticationResponse();
        response.setToken(jwt);

        return response;}}