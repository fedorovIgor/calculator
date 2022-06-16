package com.fedorovigor.calculator.util.polish.operator;

public interface SimpleOperatorToken extends OperatorToken{
    Double calculate(Double a, Double b);
}
