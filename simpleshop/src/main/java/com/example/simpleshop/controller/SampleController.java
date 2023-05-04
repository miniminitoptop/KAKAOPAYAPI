package com.example.simpleshop.controller;

import ch.qos.logback.core.model.Model;
import com.example.simpleshop.service.KaKaoPay;
import jakarta.servlet.http.HttpSession;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import lombok.extern.java.Log;

@Log
@Controller

public class SampleController {


    @Autowired
    private HttpSession session;

    @Setter(onMethod_ = @Autowired)
    private KaKaoPay kakaopay;



    @RequestMapping ("/kakao")
    public String kakaoPayGet() {
        return "index";
    }


    @PostMapping("/kakaoPay")
    public String kakaoPay() {
        log.info("kakaoPay post............................................");

        return "redirect:" + kakaopay.kakaoPayReady();

    }

    @GetMapping("/kakaoPaySuccess")
    public void kakaoPaySuccess(@RequestParam("pg_token") String pg_token, Model model) {
        log.info("kakaoPaySuccess get............................................");
        log.info("kakaoPaySuccess pg_token : " + pg_token);

    }

}
