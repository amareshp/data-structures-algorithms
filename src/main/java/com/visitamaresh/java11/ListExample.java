package com.visitamaresh.java11;

import java.util.List;

public class ListExample {
    public static void main(String[] args) {
        String[] array = new String[] {"a", "m", "a", "r", "e", "s", "h"};
        List<String[]> list = List.<String[]>of(array);
        System.out.println(list);
    }

}
