package com.frontline.adder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/adder")
public class AdderController {

    @Autowired
    private AdderService adderService;

    @GetMapping(value = "health")
    public String checkHealth(){
        return "Adder API is running";
    }

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public long postAdd(@RequestBody List<Long> numList) {
        System.out.println(numList);
        return adderService.addnumbers(numList);
    }

}
