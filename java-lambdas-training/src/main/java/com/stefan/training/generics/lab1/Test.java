package com.stefan.training.generics.lab1;

import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<Double> numbers = Arrays.asList(10., 20., 30.);
        double sum = numbers.stream().reduce(0.0, Double::sum);
        System.out.println("SUM"+sum);

    }
}
