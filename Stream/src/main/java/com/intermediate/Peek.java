package com.intermediate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Peek {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> list1 = list.stream()
                .sorted(Collections.reverseOrder())
                .peek(System.out::println) //用于调试
                .collect(Collectors.toList());
        System.out.println(list1);
    }
}
