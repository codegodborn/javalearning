package com.terminal;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Collect {
    public static void main(String[] args) {
        // 将Stream流转换成其他形式
        List<String> list = Arrays.asList("a", "b", "c");
        List<String> list1 = list.stream()
                .collect(Collectors.toList());
    }
}
