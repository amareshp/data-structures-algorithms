package com.va.ds.misc;

/**
 * Created by apatta2 on 7/25/16.
 */
public class Gcd {

    //m > n
    public long gcd(long m, long n) {
        long remainder = m % n;
        if(remainder == 0) {
            return n;
        } else {
            return gcd(n, remainder);
        }
    }
}
