package com.terminal;

import java.util.Arrays;
import java.util.List;

public class Reduce {
    public static void main(String[] args) {
        // reduce 利用一个初始值 如0，遍历利用列表中的元素
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Integer sum = list.stream().reduce(0,Integer::sum);
        System.out.println(sum);

        // reduce作为累加器，寻找最大的元素
        Integer max = list.stream().reduce(0,Integer::max);
        System.out.println(max);
    }
}
