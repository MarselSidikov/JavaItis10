package ru.itis;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MathUtilTest {

    private MathUtil forTestMathUtil;

    @Before
    public void setUp() {
        this.forTestMathUtil = new MathUtil();
    }

    @Test
    public void isPrimeTestOn2() {
//        boolean expected = true;
        boolean actual = forTestMathUtil.isPrime(2);
//        assertEquals(expected, actual);
        assertTrue(actual);
    }

    @Test
    public void isPrimeTestOn16() {
//        boolean expected = false;
        boolean actual = forTestMathUtil.isPrime(16);
//        assertEquals(expected, actual);
        assertFalse(actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void isPrimeTestOn1() {
        forTestMathUtil.isPrime(1);
    }

    @Test
    public void isPrimeTestOn13() {
        assertTrue(forTestMathUtil.isPrime(13));
    }

    @Test
    public void isPrimeTestOn169() {
        assertFalse(forTestMathUtil.isPrime(169));
    }

}