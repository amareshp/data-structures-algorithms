package com.visitamaresh.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MyFunctions1 {
    public static class Person {
        String name;
        String ageStr;
        public Person(String name, String ageStr) {
            this.name = name;
            this.ageStr = ageStr;
        }

        @Override
        public String toString() {
            return String.format("name: %s, age: %s", this.name, this.ageStr);
        }
    }

    public static class Employee {
        private String name;
        private String dept;
        private Double salary;
        public Employee(String name, String dept, Double salary) {
            this.name = name;
            this.dept = dept;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public String getDept() {
            return dept;
        }

        public Double getSalary() {
            return salary;
        }

        @Override
        public String toString() {
            return String.format("%s, %s, %f", this.name, this.dept, this.salary);
        }
    }

    public static Function<Person, String> getAgeStr = x -> x.ageStr;
    public static Function<String, Integer> strToInt = x -> Integer.parseInt(x);
    public static Function<Person, Integer> getAgeInt = strToInt.compose(getAgeStr);
    public static Function<Integer, Integer> addFive = x -> x + 5;
    public static Predicate<Person> olderThanFifty = x -> getAgeInt.apply(x) > 50;

    public static Supplier<Integer> intSupplier = new Supplier<Integer>() {
        @Override
        public Integer get() {
            Random random = new Random();
            return Integer.valueOf(random.nextInt(9999));
        }
    };

    public static void testStreamSum() {
        Random random = new Random();
        int numCount = 100000000;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < numCount; i++) {
            list.add(random.nextInt(101));
        }

        long start = System.currentTimeMillis();
        //String listStr = list.stream().map(String::valueOf).reduce("", (partial, next) -> partial + next + ", ");
        String listStr = list.stream().collect(StringBuilder::new, (sb, x) -> sb.append(x.toString()).append(","), (sb1, sb2) -> sb1.append(sb2.toString())).toString();
        //System.out.printf("list of strings: %s%n", listStr);
        long end = System.currentTimeMillis();
        System.out.printf("time taken to create the concatenated string from integers: %d ms%n", (end - start));
        System.out.printf("adding %d numbers%n", numCount);

        start = System.currentTimeMillis();
        Integer sum1 = list.stream().reduce(0, (partial, next) -> partial + next);
        end = System.currentTimeMillis();
        System.out.printf("time taken for sequential reduction: %d ms.%n", (end - start));
        System.out.printf("sum using sequential stream: %d%n", sum1);

        start = System.currentTimeMillis();
        Integer sum2 = list.parallelStream().reduce(0, (partial, next) -> partial + next);
        end = System.currentTimeMillis();
        System.out.printf("time taken for parallel reduction: %d ms.%n", (end - start));
        System.out.printf("sum using parallel stream: %d%n", sum2);

        int max = list.stream().mapToInt(Integer::intValue).max().orElse(-9999);
        System.out.printf("Max number was: %d%n", max);
    }

    public static void testCollectors() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Jack", "IT", 100.50));
        employees.add(new Employee("Tom", "FINANCE", 250.50));
        employees.add(new Employee("Alex", "IT", 175.50));
        employees.add(new Employee("Jim", "IT", 295.50));
        employees.add(new Employee("Tyson", "LEGAL", 255.30));
        employees.add(new Employee("Shawn", "FINANCE", 315.25));
        employees.add(new Employee("Bob", "LEGAL", 198.20));

        Collector<Employee, ?, Double> sumSalary = Collectors.summingDouble(Employee::getSalary);
        Map<String, Double> salaryByDept = employees.stream().collect(Collectors.groupingBy(Employee::getDept, sumSalary));
        salaryByDept.keySet().stream().forEach(key -> System.out.printf("Dept: %s, Sum of salaries: %f%n", key, salaryByDept.get(key)));
        List<String> names = employees.stream().collect(ArrayList::new, (list, e) -> list.add(e.name), ArrayList::addAll);
        names.stream().forEach(System.out::println);
    }

    public static void testMyFunction1() {
        MyFunctions1.Person person = new MyFunctions1.Person("Bob", "45");
        MyFunctions1.Person person2 = new MyFunctions1.Person("John", "55");
        System.out.printf("Bob's age is: %d%n", MyFunctions1.getAgeInt.apply(person));
        System.out.printf("Bob will be %d after 5 years.%n", MyFunctions1.getAgeInt.andThen(MyFunctions1.addFive).apply(person));
        System.out.printf("The input is: %s%n", Function.identity().apply(person));
        System.out.printf("Some int from the supplier: %d%n", MyFunctions1.intSupplier.get());
        System.out.printf("Check if Bob is older than fifty: %s%n", MyFunctions1.olderThanFifty.test(person));
        System.out.printf("Check if John is older than fifty: %s%n", MyFunctions1.olderThanFifty.test(person2));
        MyFunctions1.testStreamSum();
        MyFunctions1.testCollectors();
    }

}
