package com.frontline.integrator;

import com.sun.xml.internal.bind.v2.TODO;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class IntegratorService {


    public int integrateValues(List<Long> values) {
        int sum = getAdderResult(values);
        int mul = getMultiplicatorResult(values);
        return sum*mul;
    }

    public int getAdderResult(List<Long> values) {

        final String uri = "http://localhost:8081/api/adder";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<List<Long>> request = new HttpEntity<>(values);

        ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);

        System.out.println(result);
        return Integer.parseInt(result.getBody());
    }

    public int getMultiplicatorResult(List<Long> values) {
        final String uri = "http://localhost:8080/api/multiplicater";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<List<Long>> request = new HttpEntity<>(values);

        ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);

        System.out.println(result);
        return Integer.parseInt(result.getBody());
    }
}
