package com.visitamaresh.misc;

import java.util.ArrayList;
import java.util.List;

public class IntervalMerge {
    public static class Interval {
        public int start;
        public int end;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
        @Override
        public String toString() {
            return String.format("(%d, %d)", start, end);
        }
    }

    public static void print(List<Interval> list) {
        for(Interval i : list) {
            System.out.printf("%s, ", i);
        }
        System.out.println();
    }

    public static List<Interval> merge(List<Interval> list1, List<Interval> list2) {
        Interval current = null;
        Interval next = null;
        List<Interval> result = new ArrayList<>();
        int i = 0, j = 0;
        for(int k = 0; k < (list1.size() + list2.size()); k++) {
            current = next;
            if(i < list1.size() && list1.get(i).start < list2.get(j).start) {
                next = list1.get(i);
                i++;
            } else {
                next = list2.get(j);
                j++;
            }

            if (current != null && next != null & overlap(current, next)) {
                next = merge(current, next);
                continue;
            }
            if(current != null) result.add(current);
        }
        result.add(next);
        return result;
    }

    static Interval merge(Interval i1, Interval i2) {
        int start = (i1.start < i2.start) ? i1.start : i2.start;
        int end = (i1.end > i2.end)? i1.end : i2.end;
        Interval merged = new Interval(start, end);
        return merged;
    }

    static boolean overlap(Interval i1, Interval i2) {
        return (i2.start <= i1.end);
    }

    public static void testIntervals() {
        List<Interval> list1 = new ArrayList<>();
        List<Interval> list2 = new ArrayList<>();
        list1.add(new Interval(1, 2));
        list1.add(new Interval(3, 9));
        list2.add(new Interval(4, 6));
        list2.add(new Interval(8, 10));
        list2.add(new Interval(11, 12));
        System.out.printf("list1: ");
        print(list1);
        System.out.printf("list2: ");
        print(list2);
        List<Interval> result = merge(list1, list2);
        System.out.printf("result: ");
        print(result);
    }
}
