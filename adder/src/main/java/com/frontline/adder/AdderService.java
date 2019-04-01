package com.frontline.adder;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdderService {

    public long addnumbers(List<Long> numbers){
        long sum =0;
        for(long num:numbers){
            sum= sum + num;
        }
        return sum;
    }
}
