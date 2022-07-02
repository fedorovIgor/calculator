package com.fedorovigor.calculator.util.polish;

import com.fedorovigor.calculator.util.polish.operator.*;

public class TokensFactory {

    private final String operand = "0123456789.";
    private final String operator = "/*-+=%^()√";

    private MinusOperator minusOperator;
    private SumOperator sumOperator;
    private MultiplyOperator multiplyOperator;
    private DegreeOperator degreeOperator;
    private DivideOperator divideOperator;
    private SqrtOperator sqrtOperator;

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
           case "-" -> getMinusOperator();
           case "+" -> getSumOperator();
           case "*" -> getMultiplyOperator();
           case "^" -> getDegreeOperator();
           case "/" -> getDivideOperator();
           case "√" -> getSqrtOperator();
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

    private MinusOperator getMinusOperator() {
        if (this.minusOperator == null) {
            minusOperator = new MinusOperator();
        }

        return this.minusOperator;
    }
    private SumOperator getSumOperator() {
        if (this.sumOperator == null) {
            sumOperator = new SumOperator();
        }

        return this.sumOperator;
    }

    private MultiplyOperator getMultiplyOperator() {
        if (this.multiplyOperator == null)
            multiplyOperator = new MultiplyOperator();

        return multiplyOperator;
    }

    private DegreeOperator getDegreeOperator() {
        if (this.degreeOperator == null)
            degreeOperator = new DegreeOperator();

        return degreeOperator;
    }

    private DivideOperator getDivideOperator() {
        if (divideOperator == null)
            divideOperator = new DivideOperator();

        return divideOperator;
    }

    private SqrtOperator getSqrtOperator() {
        if (sqrtOperator == null)
            sqrtOperator = new SqrtOperator();

        return sqrtOperator;
    }


}
