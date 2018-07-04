package com.trantor.bcryptencoder.controller;

import com.trantor.bcryptencoder.model.Encoder;
import com.trantor.bcryptencoder.service.EncoderService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

@Controller
public class EncoderController {
    @Autowired
    private EncoderService encoderService;

    private Logger logger = LogManager.getLogger(EncoderController.class);

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
        StringJoiner sj = new StringJoiner("\n");
        for (int i = 0; i< sourceList.size(); i++) {
            logger.debug("encoding " + (i+1) + ": " + sourceList.get(i));
            String result = encoderService.encode(sourceList.get(i));
            logger.debug("result: " + result);
            sj.add(result);
        }
        Encoder encoder = new Encoder(source, sj.toString(), rounds);
        mav.addObject("encoder", encoder);
        return mav;
    }
}
