package com.fedorovigor.calculator.model.dto;

import com.fedorovigor.calculator.model.entity.ExpressionEntity;

public class ExpressionDto {

    private final int id;
    private final String expression;
    private final Double result;

    public ExpressionDto(int id, String expression, Double result) {
        this.id = id;
        this.expression = expression;
        this.result = result;
    }

    public ExpressionDto(ExpressionEntity entity) {
        id = entity.getId();
        expression = entity.getExpression();
        result = entity.getResult();
    }

    public String getExpression() {
        return expression;
    }

    public Double getResult() {
        return result;
    }

    public  int getId() {
        return id;
    }
}
