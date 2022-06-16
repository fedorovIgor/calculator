package com.fedorovigor.calculator.util.polish;

import com.fedorovigor.calculator.util.ExpressionCalculator;
import com.fedorovigor.calculator.util.polish.operator.FunctionOperatorToken;
import com.fedorovigor.calculator.util.polish.operator.SimpleOperatorToken;

import java.util.Stack;

public class PolishNotationCalculator implements ExpressionCalculator {

    @Override
    public Double calculate(String expression) {

        PreparePolishNotation notation = new PreparePolishNotation();

        Stack<Double> result = new Stack<>();

        var tokens = notation.parseToTokens(expression);
        var reversPolishNotation = notation.getReversePolishNotation(tokens);

        System.out.println(reversPolishNotation);

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

        return result.pop();
    }
}
