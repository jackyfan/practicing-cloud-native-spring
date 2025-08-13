package com.oms.productservice;


import com.oms.productservice.config.OmsProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    private final OmsProperties properties;

    public HomeController(OmsProperties properties) {
        this.properties = properties;
    }

    @GetMapping(value = "/")
    public String home() {
        return properties.getGreeting();
    }
}
