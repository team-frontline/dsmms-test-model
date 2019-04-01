package com.frontline.integrator;

import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.GenericDeclaration;
import java.util.List;

@RestController
public class IntegratorController {

    IntegratorService integratorService;

    @RequestMapping("/")
    public String home() {
        return "Spring boot is working!";
    }

    @RequestMapping(value = "api/get-values", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getValues(@RequestBody List<Long> values) {
        final String uri = "http://localhost:8081/api/adder";
//
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<List<Long>> request = new HttpEntity<>(values);
//
        ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);
//
//        System.out.println(result);
        return result;
    }

    @RequestMapping(value = "api/integrate", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public int integrate(@RequestBody List<Long> valueList) {
        integratorService = new IntegratorService();
        int resultValue = integratorService.integrateValues(valueList);
        return resultValue;
    }
}
