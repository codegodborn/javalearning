package com.createStream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parallel {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        // 创建并行流
        List<Integer> evenNumbers = numbers.parallelStream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

        System.out.println(evenNumbers); // 输出 [2, 4, 6, 8]


        List<Integer> number = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        // 使用 parallel() 方法创建并行流
        List<Integer> evenNumber = number.stream()
                .parallel() // 创建并行流
                .filter(n -> n % 2 == 0) // 过滤偶数
                .collect(Collectors.toList()); // 收集结果

        System.out.println(evenNumber); // 输出 [2, 4, 6, 8]

//        线程1: 1→2→3
//        ↓      过滤 → [2]
//        线程2: 4→5→6
//        ↓      过滤 → [4, 6]
//        线程3: 7→8→9
//        ↓      过滤 → [8]
//        ↓
//        合并结果: [2, 4, 6, 8]
//        多线程并行执行
//
//                数据被分成多个部分并行处理
//
//        最后合并结果
//
//                核心区别对比
//        特性	顺序流 (Stream)	   并行流 (ParallelStream)
//        线程	单线程	           多线程（ForkJoinPool）
//        处理方式	顺序处理	       并行分治处理
//        性能	适合小数据量	       适合大数据量（可能有性能提升）
//        结果顺序	保持原始顺序	   可能不保持顺序（除非用有序操作）
//        开销	开销小	           有线程创建、同步、合并的开销
    }
}
