package com.fedorovigor.calculator.repository;

import com.fedorovigor.calculator.model.dto.ExpressionDto;

import java.util.List;

public interface CalculatorCash {

    ExpressionDto addToCash(ExpressionDto dto);
    List<ExpressionDto> readCash();
}
