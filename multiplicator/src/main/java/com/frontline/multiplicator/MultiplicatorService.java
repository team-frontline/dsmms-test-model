package com.frontline.multiplicator;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MultiplicatorService {

    public long multiplyNumbers(List<Long> numbers) {
        long val = 1;
        for (long num : numbers) {
            val *= num;
        }
        return val;
    }
}
