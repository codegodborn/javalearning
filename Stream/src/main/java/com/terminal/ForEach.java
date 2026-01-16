package com.terminal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ForEach {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "b", "c");
        list.stream().forEach(System.out::println);

    }
}
