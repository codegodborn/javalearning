package com.Collectors;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Collectors {
    public static void main(String[] args) {
//        1.toList
        List<String> words = Arrays.asList("apple", "banana", "cherry");
        List<String> collect = words.stream().collect(java.util.stream.Collectors.toList());
        System.out.println(collect);

//        2.toSet
        Set<String> wordSet = words.stream().collect(java.util.stream.Collectors.toSet());
        System.out.println(wordSet);

//        3.toMap
        Map<String, Integer> wordCount = words.stream().collect(java.util.stream.Collectors.toMap( word -> word, word -> word.length()));
        System.out.println(wordCount); // 输出 {apple=5, banana=6, cherry=6}

//        4.joining
        String s = words.stream().collect(java.util.stream.Collectors.joining());
        System.out.println(s);

//        5.counting
        long count = words.stream().collect(java.util.stream.Collectors.counting());
        System.out.println(count);
    }
}
