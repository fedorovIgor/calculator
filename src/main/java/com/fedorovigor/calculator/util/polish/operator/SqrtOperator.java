package com.fedorovigor.calculator.util.polish.operator;

public class SqrtOperator  implements FunctionOperatorToken{

    private final Integer precedence = 300;
    private final Character value = '√';

    public SqrtOperator() {}

    @Override
    public Double calculate(Double a) {
        return Math.sqrt(a);
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
