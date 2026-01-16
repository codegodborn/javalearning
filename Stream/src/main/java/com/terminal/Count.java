package com.terminal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Count {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h");
        long num = list.stream().count();
        System.out.println(num);
    }
}
