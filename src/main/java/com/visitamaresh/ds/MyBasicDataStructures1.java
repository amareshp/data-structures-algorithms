package com.visitamaresh.ds;

import java.util.*;
import java.util.stream.Collectors;

/**
 * List - ArrayList, LinkedList, Stack
 * LinkedList - doubly linked list, implements List, Queue, Dequeue
 * In a LinkedList - offer adds elements to the end, push adds elements to the beginning.
 * When using LinkedList as Queue - use offer, peek, poll. When using as a Stack - use push, peek, pop
 * LinkedHashSet - Guarantees iteration order.
 * TreeSet - Uses compare or compareTo to check for equality
 * TreeSet - add, contains, first, last, floor(E e), ceiling(E e), pollFirst, pollLast
 * HashMap - get, put, remove, entrySet, keySet, compute
 */
public class MyBasicDataStructures1 {
    public static void testList() {
        Enumeration x = null;
        //unmodifiable list
        //List list1 = List.of("A", "B", "Z", "X", "V", "U", "C", "D", "E", "F");
        //modifiable list -https://stackoverflow.com/questions/1005073/initialization-of-an-arraylist-in-one-line
        List<String> list1 = new ArrayList(List.of("A", "B", "Z", "X", "V", "U", "C", "D", "E", "F"));
        //List allows you to add null element. Sorting will cause NullPointerException if the list has null.
        //list1.add(null);
        assert true : "I was expecting true";
        System.out.println("print using stream:");
        list1.stream().forEach(System.out::println);
        Collections.sort(list1, Collections.reverseOrder());
        System.out.println("list reverse sorted. print using List.forEach:");
        list1.forEach(System.out::println);

        String[] arr1 = new String[] {};
        String[] arr2 = list1.toArray(arr1);
        System.out.printf("arr1: %s, arr2: %s%n", arr1, arr2);
        String arr1Str = Arrays.stream(arr1).reduce("", (partial, next) -> partial + next + ", ");
        String arr2Str = Arrays.stream(arr2).reduce("", (partial, next) -> partial + next + ", ");
        String arr2Str2 = Arrays.stream(arr2).collect(StringBuilder::new, (sb, s) -> sb.append(s+", "), (sb1, sb2) -> sb1.append(sb2.toString())).toString();
        System.out.printf("arr1: %s, arr2: %s%n", arr1, arr2);
        System.out.printf("arr1Str: %s, arr2Str: %s, arr2Str2: %s%n", arr1Str, arr2Str, arr2Str2);
    }

    public static void testLinkedList() {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(5);
        ll.add(6);
        ll.addFirst(2);
        ll.addLast(7);
        ll.add(8);
        String llStr = ll.stream().map(Object::toString).collect(Collectors.joining(", "));
        System.out.printf("linked list: %s%n", llStr);
        System.out.printf("head is: %d, head is: %d, tail is: %d%n", ll.element(), ll.getFirst(), ll.getLast());
    }

    public static void testLinkedListAsQueue() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        q.offer(2);
        q.offer(3);
        q.offer(4);
        q.offer(5);
        System.out.printf("peek the first element in queue: %d%n", q.peek());
        System.out.printf("poll the first element in queue: %d%n", q.poll());
        System.out.printf("peek the first element in queue: %d%n", q.peek());
    }

    public static void testLinkedListAsStack() {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.push(1);
        ll.push(2);
        ll.push(3);
        ll.push(4);
        ll.push(5);
        System.out.printf("peek element at top of the stack: %d%n", ll.peek());
        System.out.printf("pop an element: %d%n", ll.pop());
        System.out.printf("peek element at top of the stack: %d%n", ll.peek());
    }

    public static void testSet() {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);
        set1.add(5);
        System.out.print("elements in this set: ");
        set1.stream().forEach(x -> System.out.printf("%d, ", x));
        System.out.println();
        System.out.printf("does the set contain 3: %b%n", set1.contains(3));
        set1.remove(4);
        System.out.print("removed 4. elements in this set: ");
        set1.stream().forEach(x -> System.out.printf("%d, ", x));
        System.out.println();

        TreeSet<Integer> set2 = new TreeSet<>(set1);
        System.out.print("elements in this tree set: ");
        set2.stream().forEach(x -> System.out.printf("%d, ", x));
        System.out.println();
        System.out.printf("does the set contain 3: %b%n", set2.contains(3));
        set2.remove(4);
        System.out.print("removed 4. elements in this set: ");
        set2.stream().forEach(x -> System.out.printf("%d, ", x));
        System.out.println();
        set2.add(10);
        System.out.print("added 10. elements in this set: ");
        set2.stream().forEach(x -> System.out.printf("%d, ", x));
        System.out.println();
        System.out.printf("tree set. first: %d, last: %d%n", set2.first(), set2.last());
        System.out.printf("less than 4: %d, more than 5: %d%n", set2.floor(4), set2.ceiling(5));
    }

    public static void testHashMap() {
        Map<String, Integer> map1 = new HashMap<>(1, .01f);
        int keyCount = 1000000;
        //HashMap with small initialCapacity and low load factor will slow down insertions because of too many rehashing.
        long start = System.currentTimeMillis();
        for(int i = 0; i < keyCount; i++) {
            map1.put(String.valueOf(i), i);
        }
        long end = System.currentTimeMillis();
        System.out.printf("initialCapacity: %d, load factor: %f, key count: %d, time taken for insertions: %d ms.%n", 1, .01, keyCount, (end - start));

        map1 = new HashMap<>(100, .75f);
        start = System.currentTimeMillis();
        for(int i = 0; i < keyCount; i++) {
            map1.put(String.valueOf(i), i);
        }
        end = System.currentTimeMillis();
        System.out.printf("initialCapacity: %d, load factor: %f, key count: %d, time taken for insertions: %d ms.%n", 1, .75, keyCount, (end - start));

        map1 = new HashMap<>(1000000, .75f);
        start = System.currentTimeMillis();
        for(int i = 0; i < keyCount; i++) {
            map1.put(String.valueOf(i), i);
        }
        end = System.currentTimeMillis();
        System.out.printf("initialCapacity: %d, load factor: %f, key count: %d, time taken for insertions: %d ms.%n", 1000000, .75, keyCount, (end - start));

        Integer numSquared = map1.compute("255", (k, v) -> v * v);
        System.out.printf("square of value of key 255 is: %d%n", numSquared);

    }

}
