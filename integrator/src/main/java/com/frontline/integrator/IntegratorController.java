package com.frontline.integrator;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IntegratorController {
    @RequestMapping("/")
    public String home() {
        return "Spring boot is working!";
    }
}
