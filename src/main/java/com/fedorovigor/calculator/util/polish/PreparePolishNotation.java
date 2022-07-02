package com.fedorovigor.calculator.util.polish;

import com.fedorovigor.calculator.util.polish.operator.BracketOperator;
import com.fedorovigor.calculator.util.polish.operator.OperatorToken;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class PreparePolishNotation {

    private final TokensFactory tokensFactory = new TokensFactory();

    public List<ExpressionToken> getReversePolishNotation(List<ExpressionToken> tokens) {

        List<ExpressionToken> result = new ArrayList<>();
        Stack<OperatorToken> stack = new Stack<>();
        OperatorToken operator;

        for (var i : tokens) {
            if (i instanceof OperandToken)
                result.add(i);

            else if (i instanceof OperatorToken) {

                operator = (OperatorToken) i;

                if ('(' == operator.getValue())
                    stack.push(operator);

                else if (')' == operator.getValue()) {
                    for (var j = stack.pop(); j.getValue() != '(' ; j = stack.pop())
                        result.add(j);
                }

                else if (stack.isEmpty()
                        || operator.getPrecedence() > stack.peek().getPrecedence())
                    stack.push(operator);


                else {
                    while (!stack.empty()
                            && operator.getPrecedence() <= stack.peek().getPrecedence()) {
                        var top = stack.pop();
                        result.add(top);
                    }

                    stack.push(operator);
                }

            }
        }

        while (!stack.isEmpty()) {
            var top = stack.pop();
            result.add(top);
        }

        result = result.stream()
                .filter(t -> !(t instanceof BracketOperator))
                .collect(Collectors.toList());

        return result;
    }

    public List<ExpressionToken> parseToTokens(String str) {

        String numberPattern = tokensFactory.getOperand();
        String operatorPattern = tokensFactory.getOperator();

        List<ExpressionToken> tokens = new ArrayList<>();

        if (operatorPattern.indexOf(str.charAt(0)) != -1
                && str.charAt(0) != '-'
                && str.charAt(0) != '√'
                && str.charAt(0) != '(')
            throw new IllegalArgumentException("Can`t prepare this expression " + str);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {

            if (i == 0
                    && str.charAt(0) == '-'
                    && str.length() > 1
                    && numberPattern.indexOf(str.charAt(1)) != -1) {
                sb.append('-');
                i++;
            }

            while (i < str.length() && numberPattern.indexOf(str.charAt(i)) != -1) {
                sb.append(str.charAt(i));
                i++;
            }

            if (!sb.isEmpty()) {
                tokens.add(tokensFactory.createToken(sb.toString()));
                sb.setLength(0);
            }


            if (i < str.length() && operatorPattern.indexOf(str.charAt(i)) != -1)
                tokens.add(tokensFactory.createToken(String.valueOf(str.charAt(i))));
        }

        return tokens;
    }
}
