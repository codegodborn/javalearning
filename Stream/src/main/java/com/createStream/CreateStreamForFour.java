package com.createStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CreateStreamForFour {
    public static void main(String[] args) {
        // Stream 方法创建
        List<String> list = Arrays.asList("a", "b", "c", "d", "e");
        Stream<String> stream = list.stream();
        String [] array = {"a", "b", "c", "d", "e"};
        Stream<String> stream2 = Arrays.stream(array);
        Stream<String> stream3 = Stream.of("apple", "banana", "cherry");
        // 使用 Stream.iterate 创建无限流
        Stream<Integer> infiniteStream = Stream.iterate(0, n -> n + 1);

        // 使用 Stream.generate 创建无限流
        Stream<String> generateStream = Stream.generate(() -> "hello");
    }
}
