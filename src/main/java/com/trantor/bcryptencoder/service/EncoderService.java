package com.trantor.bcryptencoder.service;

import java.util.List;

public interface EncoderService {
    public List<String> encode(List<String> text);
}
