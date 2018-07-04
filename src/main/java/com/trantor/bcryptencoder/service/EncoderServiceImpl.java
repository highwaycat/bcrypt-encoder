package com.trantor.bcryptencoder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EncoderServiceImpl implements EncoderService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String encode(String text) {
        return passwordEncoder.encode(text.trim());
    }
}
