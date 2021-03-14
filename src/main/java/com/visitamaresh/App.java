package com.visitamaresh;

import com.visitamaresh.ds.MyBstNode1;
import com.visitamaresh.ds.MyGraph2;
import com.visitamaresh.lc.TaskScheduler;
import com.visitamaresh.misc.IntervalMerge;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.stream.Stream;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        int xMax = Integer.MAX_VALUE + 1;
        IntervalMerge.testIntervals();

        char[] xx = new char[] {'a'};
        byte[] sBytes = "a".getBytes();
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

        byte bb = 42;
        System.out.printf("value: %s, isEmpty: %b%n", "something".substring(9), "something".substring(9).isEmpty());

        PrimitiveIterator.OfInt x = new PrimitiveIterator.OfInt() {
            int val = 0;
            @Override
            public int nextInt() {
                return val++;
            }

            @Override
            public boolean hasNext() {
                if(val < 10) return true;
                return false;
            }
        };

        IntConsumer show = System.out::println;
        Consumer<Integer> show2 = System.out::println;
        x.forEachRemaining(show2);

        System.out.println("Done...");

    }
}
