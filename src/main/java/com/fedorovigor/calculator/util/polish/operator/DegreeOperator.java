package com.fedorovigor.calculator.util.polish.operator;

public class DegreeOperator implements SimpleOperatorToken{

    private final Integer precedence = 300;
    private final Character value = '^';

    @Override
    public Double calculate(Double a, Double b) {
        return Math.pow(a,b);
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
