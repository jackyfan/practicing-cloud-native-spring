package com.oms.productservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @Value("${oms.greeting}")
    private String greeting;
    @GetMapping(value = "/")
    public String home(){
        return greeting;
    }
}
