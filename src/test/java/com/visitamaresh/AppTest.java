package com.visitamaresh;

import com.visitamaresh.misc.StringPermutations;

public class AppTest {

    public void test1() {
        String str = "abc";
        System.out.println("str = " + str + " substring(0, 0)=" + str.substring(0, 0));
        System.out.println("str = " + str + " substring(3)=" + str.substring(0, 0));

        StringPermutations stringPermutations = new StringPermutations();
        stringPermutations.printPermutations(str);

    }
}