package com.visitamaresh.ctci.ch08;

import java.util.ArrayList;
import java.util.List;

public class MySubSets {

    public static List<List<Integer>> getSubsets(List<Integer> input) {
        List<List<Integer>> lastSets = new ArrayList<>();
        List<List<Integer>> nextSets = null;
        //empty set
        List<Integer> list0 = new ArrayList<>();
        lastSets.add(list0);
        for(int i = 0; i < input.size(); i++) {
            //copy everything from last to next
            nextSets = new ArrayList<>();
            for(List<Integer> list : lastSets) {
                nextSets.add(list);
            }
            for(List<Integer> list : lastSets) {
                List<Integer> nextSet = new ArrayList<>(list);
                nextSet.add(input.get(i));
                nextSets.add(nextSet);
            }
            lastSets = nextSets;
        }
        return nextSets;
    }

    public static void testMySubsets() {
        List<Integer> input = new ArrayList<>();
        for(int i = 1; i <= 4; i++) {
            input.add(i);
        }
        List<List<Integer>> resultSets = getSubsets(input);
        for(List<Integer> list : resultSets) {
            if(list.size() == 0) {
                System.out.format("<Empty Set>");
            }
            list.stream().forEach(num -> System.out.format("%d, ", num));
            System.out.println();
        }
        System.out.format("Total number of sets: %d%n", resultSets.size());
    }
}
