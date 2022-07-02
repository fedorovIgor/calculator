package com.fedorovigor.calculator.util.polish;

import com.fedorovigor.calculator.util.ExpressionCalculator;
import com.fedorovigor.calculator.util.polish.operator.FunctionOperatorToken;
import com.fedorovigor.calculator.util.polish.operator.SimpleOperatorToken;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Stack;

public class PolishNotationCalculator implements ExpressionCalculator {

    private final PreparePolishNotation notation = new PreparePolishNotation();

    @Override
    public BigDecimal calculate(String expression) {

        Stack<Double> result = new Stack<>();

        var tokens = notation.parseToTokens(expression);
        var reversPolishNotation = notation.getReversePolishNotation(tokens);


        for (var i = reversPolishNotation.listIterator(); i.hasNext();) {

            var token = i.next();

            if (token instanceof OperandToken)
                result.push((Double)token.getValue());

            if (token instanceof SimpleOperatorToken) {
                var b = result.pop();

                if (!i.hasNext() && result.isEmpty() && (Character)token.getValue() == '-') {
                    result.push(b * -1);
                    continue;
                }

                var a = result.pop();
                var middle = ((SimpleOperatorToken) token).calculate(a, b);
                result.push(middle);
            }

            if (token instanceof FunctionOperatorToken) {
                var a = result.pop();
                var middle = ((FunctionOperatorToken) token).calculate(a);
                result.push(middle);
            }
        }



        return new BigDecimal(result.pop()).setScale(4, RoundingMode.HALF_UP);
    }
}