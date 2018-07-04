package com.trantor.bcryptencoder.controller;

import com.trantor.bcryptencoder.model.Encoder;
import com.trantor.bcryptencoder.service.EncoderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
public class EncoderController {
    @Autowired
    private EncoderService encoderService;

    @GetMapping(value = {"/", "/encoder"})
    public ModelAndView encoder() {
        ModelAndView mav = new ModelAndView("encoder");
        Encoder encoder = new Encoder("", "", 11);
        mav.addObject("encoder", encoder);
        return mav;
    }

    @PostMapping(value = {"/", "/encoder"})
    public ModelAndView encoderEncode(String source, Integer rounds) {
        ModelAndView mav = new ModelAndView("encoder");
        List<String> sourceList = Arrays.asList(source.split("\n"));
        List<String> targetList = encoderService.encode(sourceList);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sourceList.size(); i++) {
            sb
                    .append(sourceList.get(i).trim())
                    .append("\t")
                    .append(targetList.get(i).trim())
                    .append("\n");
        }
        Encoder encoder = new Encoder(source, sb.toString(), rounds);
        mav.addObject("encoder", encoder);
        return mav;
    }
}
