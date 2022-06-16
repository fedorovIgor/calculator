package com.fedorovigor.calculator.util.polish.operator;

public class SumOperator implements SimpleOperatorToken {

    private final Integer precedence = 100;
    private final Character value = '+';

    public SumOperator() {}

    @Override
    public String toString() {
        return "OperatorToken{" +
                "value=" + value +
                '}';
    }

    @Override
    public Double calculate(Double a, Double b) {
        return a + b;
    }

    @Override
    public Character getValue() {
        return value;
    }

    @Override
    public Integer getPrecedence() {
        return precedence;
    }
}
