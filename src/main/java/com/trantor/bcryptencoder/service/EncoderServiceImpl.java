package com.trantor.bcryptencoder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EncoderServiceImpl implements EncoderService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<String> encode(List<String> text) {
        return text.stream().map(passwordEncoder::encode).collect(Collectors.toList());
    }
}
