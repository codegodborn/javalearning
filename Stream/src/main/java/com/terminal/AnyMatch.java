package com.terminal;

import java.util.Arrays;
import java.util.List;

public class AnyMatch {
    // anymatch 有一个匹配
    // allmatch 全部匹配
    // nonematch 没用匹配
    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h");
        Boolean anyMatch = list.stream().anyMatch(x -> x.startsWith("a"));
        System.out.println(anyMatch);
    }
}
