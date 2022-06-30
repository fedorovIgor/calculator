package com.fedorovigor.calculator.service;

import com.fedorovigor.calculator.model.dto.ExpressionDto;

import java.math.BigDecimal;
import java.util.List;

public interface CalculatorService {

    BigDecimal calculateAndSave(String expr);
    List<ExpressionDto> getLasTen();

}
