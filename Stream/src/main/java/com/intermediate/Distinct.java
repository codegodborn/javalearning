package com.intermediate;

import java.util.Arrays;
import java.util.List;

public class Distinct {
    public static void main(String[] args) {
        // distinct 去重
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 9);
        list.stream().distinct().forEach(System.out::println);
    }
}
