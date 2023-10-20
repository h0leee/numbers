package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ListDeduplicatorTest {

    List<Integer> list;
    List<Integer> expected;
    ListAggregator aggregator;
    ListDeduplicator deduplicator;

    class StubListSorter implements GenericListSorter {

        List<Integer> lista;

        public StubListSorter(List<Integer> array) {
            this.lista = array;
        }



        public List<Integer> sort(List<Integer> list) {
            return lista;
        }
    }

    @BeforeEach
    public void addElements() {
        list = Arrays.asList(1, 2, 4, 2, 5);
        expected = Arrays.asList(1, 2, 4, 5);
    }

    @Test
    public void deduplicate() {
        StubListSorter stub = new StubListSorter(Arrays.asList(1, 2, 4, 5));
        ListDeduplicator deduplicator = new ListDeduplicator(stub);
        List<Integer> distinct = deduplicator.deduplicate(list);
        Assertions.assertEquals(expected, distinct);
    }

    @Test
    public void deduplicate_8276() {
        List<Integer> lista = Arrays.asList(1, 2, 4, 2);
        StubListSorter stub = new StubListSorter(Arrays.asList(1, 2, 2, 4));
        ListDeduplicator deduplicator = new ListDeduplicator(stub);
        List<Integer> distinct = deduplicator.deduplicate(lista);

        Assertions.assertEquals(distinct, Arrays.asList(1, 2, 4));
    }
}
