package com.intermediate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMap {
    public static void main(String[] args) {
        List<List<String>> list = Arrays.asList(
                Arrays.asList("hello","world"),
                Arrays.asList("lipenglin","perform")
        );
        List<String> list1 = list.stream()
                .flatMap(List::stream)  //把多个流映射到一起，简单来说就是合并到一起
                .collect(Collectors.toList());
        System.out.println(list1);
    }
}
