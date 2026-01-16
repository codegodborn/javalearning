package com.exam;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class exam {

    public static void main(String[] args) {
//        1. 给定一个整数列表，找出所有偶数并返回它们的平方
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
// 期望输出: [4, 16, 36, 64, 100]
        List<Integer> pows = numbers.stream()
                .filter(i->i%2==0)
                .map(i->i*i)
                .collect(Collectors.toList());
        System.out.println(pows);


//        2.// 给定字符串列表，找出所有长度大于3的字符串，并转换为大写
        List<String> words = Arrays.asList("java", "stream", "api", "lambda", "code", "test");
// 期望输出: ["STREAM", "LAMBDA", "TEST"]
        List<String> word = words.stream()
                .filter(i->i.length()>3)
                .map(i->i.toUpperCase())
                .collect(Collectors.toList());
        System.out.println(word);

//        3// 计算列表中所有奇数的和
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
// 期望输出: 25
        Integer sum = nums.stream()
                .filter(i->i%2==1)
                .reduce(0, Integer::sum);
        System.out.println(sum);

//        4.


        class Person {
            private String name;
            private int age;
            private String city;
            // 构造函数、getter/setter省略
            public Person(String name, int age, String city) {
                this.age= age;
                this.city = city;
                this.name = name;
            }
            public String getName() {
                return name;
            }
            public void setName(String name) {
                this.name = name;
            }
            public int getAge() {
                return age;
            }

            public void setAge(int age) {
                this.age = age;
            }
            public String getCity() {
                return city;
            }
            public void setCity(String city) {
                this.city = city;
            }
            // 给定人员列表：
            List<Person> people = Arrays.asList(
                    new Person("Alice", 25, "New York"),
                    new Person("Bob", 30, "London"),
                    new Person("Charlie", 22, "New York"),
                    new Person("David", 35, "London"),
                    new Person("Eve", 28, "Paris")
            );

            // 任务1: 找出所有来自"New York"的人员名字
            List<String> names = people.stream()
                    .filter(p->p.getCity().equals("New York"))
                    .map(Person::getName)
                    .peek(System.out::println)
                    .collect(Collectors.toList());

            // 任务2: 计算来自"London"的人的平均年龄
            double ages = people.stream()
                    .filter(p->p.getCity().equals("London"))
                    .mapToInt(Person::getAge)
                    .average()
                    .orElse(0.0);
            // 任务3: 按城市分组，统计每个城市的人数
            Map<String,Long> counts = people.stream()
                    .collect(Collectors.groupingBy(
                            Person::getCity,Collectors.counting()
                    ));
        }

//        5
// 给定一个包含重复元素的列表，去重后按降序排列
        List<Integer> withDuplicates = Arrays.asList(5, 2, 8, 2, 5, 1, 8, 9, 3);
// 期望输出: [9, 8, 5, 3, 2, 1]
        List<Integer> ss = withDuplicates.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println(ss);

        //    6
        // 将多个列表合并成一个，并找出所有大于10的数字
        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 12),
                Arrays.asList(7, 8, 15)
        );
// 期望输出: [12, 15]
        List<Integer> list = listOfLists.stream()
                .flatMap(List::stream)
                .filter(list1->list1>10)
//        .forEach(System.out::println)
                .collect(Collectors.toList());
        System.out.println(list);

//        7
        class Order {
            private String customer;
            private String product;
            private double amount;
            private LocalDate date;
            // 构造函数、getter/setter省略
            public Order(String customer, String product, double amount, LocalDate date) {
                this.customer = customer;
                this.product = product;
                this.amount = amount;
                this.date = date;
            }
            public String getCustomer() {
                return customer;
            }
            public void setCustomer(String customer) {
                this.customer = customer;
            }
            public String getProduct() {
                return product;
            }
            public void setProduct(String product) {
                this.product = product;
            }
            public double getAmount() {
                return amount;
            }
            public void setAmount(double amount) {
                this.amount = amount;
            }
            public LocalDate getDate() {
                return date;
            }
            public void setDate(LocalDate date) {
                this.date = date;
            }
            public int getMonth(){
                return date.getMonthValue();
            }

        }

        List<Order> orders = Arrays.asList(
                new Order("Alice", "Laptop", 1200.0, LocalDate.of(2024, 1, 15)),
                new Order("Bob", "Phone", 800.0, LocalDate.of(2024, 1, 20)),
                new Order("Alice", "Tablet", 600.0, LocalDate.of(2024, 2, 10)),
                new Order("Charlie", "Laptop", 1200.0, LocalDate.of(2024, 2, 15)),
                new Order("Bob", "Monitor", 400.0, LocalDate.of(2024, 3, 5))
        );

// 任务:
// 1. 计算每个客户的总消费金额
        Map<String,Double> peoples = orders.stream()
                .collect(Collectors.groupingBy(Order::getCustomer,Collectors.summingDouble(Order::getAmount)));
        System.out.println(peoples);
// 2. 找出消费金额最高的客户
        Map.Entry<String, Double> topCustomer = peoples.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .orElse(null);
        System.out.println(topCustomer);
// 3. 按月统计销售额
        Map<Integer,Double> monthlySales = orders.stream()
                .collect(Collectors.groupingBy(
                        Order::getMonth,
                        Collectors.summingDouble(Order::getAmount)
                ));
        System.out.println(monthlySales);
// 4. 找出最受欢迎的产品（购买次数最多）
        Map<String,Long> buys = orders.stream()
                .collect(Collectors.groupingBy(
                        Order::getProduct,
                        Collectors.counting()
                ));
        System.out.println(buys);
    }




}
