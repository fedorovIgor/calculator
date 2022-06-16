package com.fedorovigor.calculator.util.polish.operator;

public class MinusOperator implements SimpleOperatorToken {

    private final Integer precedence = 100;
    private final Character value = '-';

    public MinusOperator() {}

    @Override
    public Double calculate(Double a, Double b) {
        return a - b;
    }

    @Override
    public Character getValue() {
        return value;
    }

    @Override
    public Integer getPrecedence() {
        return precedence;
    }

    @Override
    public String toString() {
        return "MinusOperator{" +
                "precedence=" + precedence +
                ", value=" + value +
                '}';
    }
}
