package com.fedorovigor.calculator.model.dto;

import com.fedorovigor.calculator.model.entity.ExpressionEntity;

public class ExpressionDto {

    private final String expression;
    private final Double result;

    public ExpressionDto(String expression, Double result) {
        this.expression = expression;
        this.result = result;
    }

    public ExpressionDto(ExpressionEntity entity) {
        expression = entity.getExpression();
        result = entity.getResult();
    }

    public String getExpression() {
        return expression;
    }

    public Double getResult() {
        return result;
    }
}
