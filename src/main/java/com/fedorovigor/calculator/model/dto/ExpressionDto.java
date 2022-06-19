package com.fedorovigor.calculator.model.dto;

import com.fedorovigor.calculator.model.entity.ExpressionEntity;

import java.time.LocalDateTime;

public class ExpressionDto {


    private final String expression;
    private final Double result;
    private final LocalDateTime saveTime;

    public ExpressionDto(String expression, Double result, LocalDateTime saveTime) {
        this.saveTime = saveTime;
        this.expression = expression;
        this.result = result;
    }

    public ExpressionDto(ExpressionEntity entity) {
        saveTime = entity.getTime();
        expression = entity.getExpression();
        result = entity.getResult();
    }

    public String getExpression() {
        return expression;
    }

    public Double getResult() {
        return result;
    }

    public LocalDateTime getSaveTime() {
        return saveTime;
    }
}
