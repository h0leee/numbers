package com.aor.numbers;

public class DivisibleByFilter implements GenericListFilter{
    private Integer number;
    public DivisibleByFilter(Integer numb) {
        this.number = numb;
    }


    @Override
    public boolean accept(Integer num) {
        return num % number == 0;
    }
}
