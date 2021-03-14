package com.visitamaresh.misc;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MyGenericVal<T> {
    T val;
    public MyGenericVal(T t) {
        this.val = t;
    }

    public List<T> fromArrToList(T[] a) {
        return Arrays.stream(a).collect(Collectors.toList());
    }

    public <G> List<G> arrayMapList(T[] a, Function<T, G> func) {
        return Arrays.stream(a).map(func).collect(Collectors.toList());
    }

    public <G extends Number> List<G> getNumList(G[] g) {
        return Arrays.stream(g).collect(Collectors.toList());
    }

    public <G extends Number & Comparable> List<G> getNumListComparable(G[] g) {
        return Arrays.stream(g).collect(Collectors.toList());
    }

    public void print() {
        System.out.printf("value: %s%n", val.toString());
    }

    public void printInts(List<? extends MyGenericVal<Integer>> nList) {
        nList.forEach(MyGenericVal::print);
    }

}
