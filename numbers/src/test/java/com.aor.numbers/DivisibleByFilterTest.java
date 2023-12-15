package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DivisibleByFilterTest {
    DivisibleByFilter divisor;


    @Test
    public void shouldEqualTrue() {
        int number1 = 4;
        int number2 = 8;
        divisor = new DivisibleByFilter(number1);
        boolean result = divisor.accept(number2);
        Assertions.assertEquals(result, true);
    }

    @Test
    public void shouldEqualFalse() {
        int number1 = 4;
        int number2 = 3;
        divisor = new DivisibleByFilter(number1);
        boolean result = divisor.accept(number2);
        Assertions.assertEquals(result, false);
    }

    @Test
    public void negativeDivisorTrue() {
        int number1 = -4;
        int number2 = 8;
        divisor = new DivisibleByFilter(number1);
        boolean result = divisor.accept(number2);
        Assertions.assertEquals(result, true);
    }

    @Test
    public void negativeDivisorFalse() {
        int number1 = -4;
        int number2 = 5;
        divisor = new DivisibleByFilter(number1);
        boolean result = divisor.accept(number2);
        Assertions.assertEquals(result, false);
    }

    @Test
    public void negativeNumeratorTrue() {
        int number1 = 2;
        int number2 = -8;
        divisor = new DivisibleByFilter(number1);
        boolean result = divisor.accept(number2);
        Assertions.assertEquals(result, true);
    }

    @Test
    public void negativeNumeratorFalse() {
        int number1 = 2;
        int number2 = -7;
        divisor = new DivisibleByFilter(number1);
        boolean result = divisor.accept(number2);
        Assertions.assertEquals(result, false);
    }
}
