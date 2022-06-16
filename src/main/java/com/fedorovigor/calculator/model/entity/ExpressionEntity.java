package com.fedorovigor.calculator.model.entity;

import java.time.LocalDateTime;

public class ExpressionEntity {
    private String expression;
    private Double result;
    private LocalDateTime time;

    public ExpressionEntity(String expression, Double result, LocalDateTime time) {
        this.expression = expression;
        this.result = result;
        this.time = time;
    }

    public ExpressionEntity() {
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
