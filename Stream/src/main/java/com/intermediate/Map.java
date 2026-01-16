package com.intermediate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Map {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Hello", "World");
        List<String> list2 = list.stream()
                .map(String::toUpperCase)  // 把每个元素映射到toUpperCase函数
                .collect(Collectors.toList());
        System.out.println(list2);
    }
}
