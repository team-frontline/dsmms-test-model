package com.frontline.multiplicator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/multiplicater")
public class MultiplicatorController {
    @Autowired
    private MultiplicatorService multiplicatorService;

    @GetMapping(value = "health")
    public String checkHealth() {
        return "Multiplicator API is running";
    }

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public long postAdd(@RequestBody List<Long> numList) {
        System.out.println(numList);
        return multiplicatorService.multiplyNumbers(numList);
    }

}
