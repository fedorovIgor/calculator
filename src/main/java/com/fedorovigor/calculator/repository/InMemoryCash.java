package com.fedorovigor.calculator.repository;

import com.fedorovigor.calculator.model.dto.ExpressionDto;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class InMemoryCash implements CalculatorCash{

    private final Deque<ExpressionDto> cash = new ArrayDeque<>();

    @Override
    public ExpressionDto addToCash(ExpressionDto dto) {

        if (null == cash)
            throw new IllegalArgumentException("cant save incorrect dto " + dto);

        cash.offerFirst(dto);

        if (cash.size() > 10)
            cash.pollLast();

        return dto;
    }

    @Override
    public List<ExpressionDto> readCash() {
        var result = new ArrayList<>(cash);

        return result;
    }
}
