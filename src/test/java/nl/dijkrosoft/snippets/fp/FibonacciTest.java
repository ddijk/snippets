package nl.dijkrosoft.snippets.fp;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigInteger;

import static nl.dijkrosoft.snippets.fp.Fibonacci.fibo;

class FibonacciTest {


    static Object[][] data() {
        return new Object[][]{
                new Object[]{0, BigInteger.ZERO},
                new Object[]{1, BigInteger.ONE},
                new Object[]{2, BigInteger.ONE},
                new Object[]{3, BigInteger.TWO},
                new Object[]{4, new BigInteger("3")},
                new Object[]{5, new BigInteger("5")},
                new Object[]{6, new BigInteger("8")},
                new Object[]{7, new BigInteger("13")},
                new Object[]{8, new BigInteger("21")},
        };
    }

    @ParameterizedTest
    @MethodSource("data")
    void fiboCheck(int input, BigInteger expectedResult) {
        Assertions.assertEquals(expectedResult, fibo(input));
    }
}