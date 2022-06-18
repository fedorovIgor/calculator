package com.fedorovigor.calculator.repository;

import com.fedorovigor.calculator.model.entity.ExpressionEntity;

import java.util.ArrayList;
import java.util.List;

public class InMemoryCalculatorDao implements CalculatorDao {

    private final List<ExpressionEntity> database = new ArrayList<>();

    @Override
    public ExpressionEntity save(ExpressionEntity entity) {

        database.add(entity);

        return entity;
    }

    @Override
    public List<ExpressionEntity> getLast(int count, int skipLast) {

        int startIndex = database.size() - count - skipLast;
        int lastIndex = database.size() - skipLast;

        return database.subList(startIndex, lastIndex);
    }

    @Override
    public Integer getSize() {
        return database.size();
    }
}
