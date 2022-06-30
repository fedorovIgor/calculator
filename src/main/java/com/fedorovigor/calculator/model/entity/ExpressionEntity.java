package com.fedorovigor.calculator.model.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ExpressionEntity {

    private int id;
    private String expression;
    private BigDecimal result;
    private LocalDateTime time;

    public ExpressionEntity(String expression, BigDecimal result, LocalDateTime time) {
        this.expression = expression;
        this.result = result;
        this.time = time;
    }

    public ExpressionEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public BigDecimal getResult() {
        return result;
    }

    public void setResult(BigDecimal result) {
        this.result = result;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "ExpressionEntity{" +
                "expression='" + expression + '\'' +
                ", result=" + result +
                ", time=" + time +
                '}';
    }
}
