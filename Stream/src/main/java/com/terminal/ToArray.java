package com.terminal;

import java.util.Arrays;
import java.util.List;

public class ToArray {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "b", "c");
        Object[] array = list.stream().toArray();
        System.out.println(Arrays.toString(array));
    }
}
