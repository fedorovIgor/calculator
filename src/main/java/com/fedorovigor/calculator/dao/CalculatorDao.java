package com.fedorovigor.calculator.dao;

import com.fedorovigor.calculator.model.entity.ExpressionEntity;

import java.util.List;

public interface CalculatorDao {

    ExpressionEntity save(ExpressionEntity entity);
    List<ExpressionEntity> getLast(int count, int skipLast);
    Integer getSize();
}
