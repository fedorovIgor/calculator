package com.fedorovigor.calculator.util.polish.operator;

public class DivideOperator implements SimpleOperatorToken{

    private final Integer precedence = 200;
    private final Character value = '/';

    @Override
    public Double calculate(Double a, Double b) {
        return a/b;
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
        return value.toString();
    }
}
