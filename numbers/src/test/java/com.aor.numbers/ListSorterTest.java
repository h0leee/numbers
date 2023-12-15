package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListSorterTest {

    List<Integer> list;



    List<Integer> expected;
    ListAggregator aggregator;
    ListSorter sorter;

    @BeforeEach
    public void addElements() {
        list = Arrays.asList(3, 2, 6, 1, 4, 5, 7);
        expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        aggregator = new ListAggregator();
        sorter = new ListSorter();
    }

    @Test
    public void sort() {
        List<Integer> sorted = sorter.sort(list);
        Assertions.assertEquals(expected, sorted);
    }

    @Test
    public void sort_8276() {
        List<Integer> lista = Arrays.asList(1, 2, 4, 2);
        List<Integer> result = sorter.sort(lista);

        Assertions.assertEquals(result, Arrays.asList(1, 2, 2, 4));
    }
}
