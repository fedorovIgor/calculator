package com.fedorovigor.calculator.util.polish;

import com.fedorovigor.calculator.util.polish.operator.*;

public class TokensFactory {

    private final String operand = "0123456789.";
    private final String operator = "/*-+=%^()√";

    public String getOperand() {
        return operand;
    }

    public String getOperator() {
        return operator;
    }

    public ExpressionToken createToken(String value) {
        if (value == null || value.isEmpty())
            return null;

        if (isDouble(value))
            return new OperandToken(Double.valueOf(value));

       return switch (value) {
           case "-" -> new MinusOperator();
           case "+" -> new SumOperator();
           case "*" -> new MultiplyOperator();
           case "^" -> new DegreeOperator();
           case "/" -> new DivideOperator();
           case "√" -> new SqrtOperator();
           case ")", "(" -> new BracketOperator(value.charAt(0));
           default ->
                   throw new IllegalArgumentException("cant parse that string " + value);
       };
    }

    public ExpressionToken createToken(Double value) {
        return new OperandToken(value);
    }

    private boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }


}
