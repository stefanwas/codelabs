package com.stefan.spring.web.training;

import org.springframework.stereotype.Component;

@Component
public class IdProvider {

    private static Long id = 0L;

    public Long getNextValue() {
        return ++id;
    }
}
