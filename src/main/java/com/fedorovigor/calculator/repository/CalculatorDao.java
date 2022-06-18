package com.fedorovigor.calculator.repository;

import com.fedorovigor.calculator.model.entity.ExpressionEntity;

import java.util.List;

public interface CalculatorDao {

    ExpressionEntity save(ExpressionEntity entity);

//    skipLast - how many need to skip from the tail
//    count - how may need to get in total,
//    it`s OK if after skipLast we have less entities than count
    List<ExpressionEntity> getLast(int count, int skipLast);
    Integer getSize();
}
