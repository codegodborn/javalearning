package com.intermediate;

import java.util.Arrays;
import java.util.List;

public class Limit {
    public static void main(String[] args) {
        // LIMIT 限制数量
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        list.stream().limit(5).forEach(System.out::println);

    }
}
