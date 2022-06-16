package com.fedorovigor.calculator.util.polish.operator;

import com.fedorovigor.calculator.util.polish.ExpressionToken;

public interface OperatorToken extends ExpressionToken {

    Character getValue();
    Integer getPrecedence();
}
