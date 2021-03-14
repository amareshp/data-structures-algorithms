package com.visitamaresh.misc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by apatta2 on 7/25/16.
 */
public class GcdTest {
    private static final Logger logger = LoggerFactory.getLogger( new Exception().getStackTrace()[0].getClassName() );

    @Test
    public void test1() {
        Gcd gcd = new Gcd();
        long result = gcd.gcd(128, 56);
        logger.info("Result: " + result);
        Assertions.assertEquals(8, result);
    }

}
