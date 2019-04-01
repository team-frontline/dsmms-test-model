package com.frontline.integrator;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class IntegratorController {

    IntegratorService integratorService;

    @RequestMapping("/")
    public String home() {
        return "Spring boot is working!";
    }

    @RequestMapping(value = "api/get-values", method = RequestMethod.GET)
    public String getValues() {
        final String uri = "https://api.github.com/users";

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);

        System.out.println(result);
        return result;
    }

    @RequestMapping(value = "api/integrate", method = RequestMethod.POST)
    public int integrate(@RequestBody List<Long> valueList){
        integratorService = new IntegratorService();
        return integratorService.integrateValues(valueList);
    }
}
