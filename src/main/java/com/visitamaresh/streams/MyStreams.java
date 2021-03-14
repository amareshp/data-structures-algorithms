package com.visitamaresh.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MyStreams {
    public static class MyEmployee {
        public String name;
        public String dept;
        public Double salary;

        public MyEmployee(String nameVar, String deptVar, Double salaryVar) {
            this.name = nameVar;
            this.dept = deptVar;
            this.salary = salaryVar;
        }
    }
    public static <T> String getStr(List<T> values) {
        return values.stream().map(T::toString).reduce("", (r, e) -> r + e + ", ");
    }

    public static void runGetStr() {
        List<Integer> list1 = IntStream.range(10, 30).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        String valStr = MyStreams.getStr(list1);
        System.out.printf("list is: %s%n", valStr);
    }

    public static void runGetStr2() {
        List<Integer> list1 = IntStream.range(50, 80).boxed().collect(Collectors.toList());
        String valStr = MyStreams.getStr(list1);
        System.out.printf("list is: %s%n", valStr);
        int sum = list1.stream().mapToInt(x -> x.intValue()).sum();
        System.out.printf("sum of numbers: %d%n", sum);
    }


    public static void runGrouping() {
        Collector<MyEmployee, ?, Double> sumSalary = Collectors.summingDouble(e -> e.salary);
        List<MyEmployee> employees = new ArrayList<>();
        employees.add(new MyEmployee("Jack", "AB", 100.5));
        employees.add(new MyEmployee("John", "CD", 200.5));
        employees.add(new MyEmployee("Sam", "AB", 350.5));
        employees.add(new MyEmployee("Dan", "CD", 525.5));
        Map<String, Double> salaryByDept = employees.stream().collect(Collectors.groupingBy((e -> e.dept), sumSalary));
        for(String dept : salaryByDept.keySet()) {
            System.out.printf("dept: %s, salary: %f%n", dept, salaryByDept.get(dept));
        }
        employees.stream().forEach(e -> {
            System.out.printf("name: %s, dept: %s, salary: %.2f%n", e.name, e.dept, e.salary);
        });

    }
}
