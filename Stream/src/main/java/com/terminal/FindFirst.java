package com.terminal;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FindFirst {
    public static void main(String[] args) {
        // findFirst 查找第一个
        List<String> list = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h");
        Optional<String> first = list.stream().findFirst();
        first.ifPresent(System.out::println); // 安全类型 如果存在才输出

        //findAny 随机返回一个
        // 在并行流中有用，顺序流会返回第一个元素
        Optional<String> second = list.stream().findAny();
        second.ifPresent(System.out::println);

//        List<String> list = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h");

        // 多次运行查看不同结果
        for (int i = 0; i < 5; i++) {
            Optional<String> random = list.parallelStream().findAny();
            random.ifPresent(System.out::println);
        }
    }
}
