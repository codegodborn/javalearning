package com.intermediate;

import java.util.Arrays;
import java.util.List;

public class Skip {
    public static void main(String[] args) {
        // 跳过前几个
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        list.stream().skip(5).forEach(System.out::println);
    }
}
