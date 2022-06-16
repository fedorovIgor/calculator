package com.fedorovigor.calculator.service;

import com.fedorovigor.calculator.model.dto.ExpressionDto;

import java.util.List;

public interface CalculatorService {

    Double calculateAndSave(String expr);
    List<ExpressionDto> getLasTen();

}
