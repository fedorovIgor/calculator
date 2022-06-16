package com.fedorovigor.calculator.util.polish.operator;

public class BracketOperator implements OperatorToken {

    private final Integer precedence = 0;
    private final Character value;

    public BracketOperator(Character value) {
        this.value = value;
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
        return "BracketOperator{" +
                "precedence=" + precedence +
                ", value=" + value +
                '}';
    }
}
