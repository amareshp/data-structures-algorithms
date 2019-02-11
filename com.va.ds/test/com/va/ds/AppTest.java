package com.va.ds;

import com.va.ds.misc.StringPermutations;
import org.junit.Test;

public class AppTest {

    @Test
    public void test1() {
        String str = "abc";
        System.out.println("str = " + str + " substring(0, 0)=" + str.substring(0, 0));
        System.out.println("str = " + str + " substring(3)=" + str.substring(0, 0));

        StringPermutations stringPermutations = new StringPermutations();
        stringPermutations.printPermutations(str);

    }
}