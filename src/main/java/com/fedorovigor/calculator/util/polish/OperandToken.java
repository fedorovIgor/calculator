package com.fedorovigor.calculator.util.polish;

public class OperandToken implements ExpressionToken {
    private Double value;

    public OperandToken(Double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ValueToken{" +
                "value=" + value +
                '}';
    }

    @Override
    public Double getValue() {
        return value;
    }
}
