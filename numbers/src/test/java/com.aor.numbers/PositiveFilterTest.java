package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PositiveFilterTest {

    @Test
    public void positiveElement() {
        int number = 4;
        PositiveFilter filter = new PositiveFilter();
        boolean result = filter.accept(number);
        Assertions.assertEquals(result, true);
    }


    @Test
    public void negativeElement() {
        int number = -10;
        PositiveFilter filter = new PositiveFilter();
        boolean result = filter.accept(number);
        Assertions.assertEquals(result, false);
    }


    @Test
    public void doesZeroReturnsFalse() {
        int number = 0;
        PositiveFilter filter = new PositiveFilter();
        boolean result = filter.accept(number);
        Assertions.assertEquals(result, false);
    }
}
