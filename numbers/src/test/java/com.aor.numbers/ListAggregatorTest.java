package com.aor.numbers;

import com.sun.tools.javac.jvm.Gen;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.font.FontRenderContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListAggregatorTest {

    List<Integer> list;
    ListAggregator aggregator;

    class Stub implements GenericListDeduplicator {

        List<Integer> lista;

        public Stub(List<Integer> array) {
            this.lista = array;
        }


        public List<Integer> deduplicate(List<Integer> list) {
            return lista;
        }
    }

    @BeforeEach
    public void createList() {
        list = Arrays.asList(1, 2, 4, 2, 5);
        aggregator = new ListAggregator();
    }

    @Test
    public void sum() {
        int sum = aggregator.sum(list);

        Assertions.assertEquals(14, sum);
    }

    @Test
    public void max() {
        int max = aggregator.max(list);

        Assertions.assertEquals(5, max);
    }

    @Test
    public void min() {
        int min = aggregator.min(list);

        Assertions.assertEquals(1, min);
    }

    @Test
    public void distinct() {
        Stub inter = new Stub(Arrays.asList(1, 2, 4, 5));
        int distinct = aggregator.distinct(list, inter);

        Assertions.assertEquals(4, distinct);
    }

    @Test
    public void max_bug_7263() {
        List<Integer> lista = Arrays.asList(-1, -4, -5);
        int max = aggregator.max(lista);

        Assertions.assertEquals(-1, max);
    }

    @Test
    public void aggregator_8276() {
        List<Integer> lista = Arrays.asList(1, 2, 4, 2);
        Stub stub = new Stub(Arrays.asList(1, 2, 4));
        int distintos = aggregator.distinct(lista, stub);

        Assertions.assertEquals(distintos, 3);
    }
}
