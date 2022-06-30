package com.fedorovigor.calculator.service;

import com.fedorovigor.calculator.repository.CalculatorCash;
import com.fedorovigor.calculator.repository.CalculatorDao;
import com.fedorovigor.calculator.model.dto.ExpressionDto;
import com.fedorovigor.calculator.model.entity.ExpressionEntity;
import com.fedorovigor.calculator.util.ExpressionCalculator;
import com.fedorovigor.calculator.util.polish.PolishNotationCalculator;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class CalculatorServiceWithCash implements CalculatorService{

    private final CalculatorDao calculatorDao;
    private final CalculatorCash cash;
    private final ExpressionCalculator expressionCalculator;

    public CalculatorServiceWithCash(CalculatorDao calculatorDao, CalculatorCash cash, ExpressionCalculator expressionCalculator) {
        this.calculatorDao = calculatorDao;
        this.cash = cash;
        this.expressionCalculator = expressionCalculator;
    }

    @Override
    public BigDecimal calculateAndSave(String expr) {

        BigDecimal answer = expressionCalculator.calculate(expr);

        ExpressionEntity entity =  new ExpressionEntity(
                expr,
                answer,
                LocalDateTime.now()
        );

        calculatorDao.save(entity);

        cash.addToCash(new ExpressionDto(entity));

        return answer;
    }

    @Override
    public List<ExpressionDto> getLasTen() {
        var fromCash = cash.readCash();

        if (fromCash.size() == 10)
            return fromCash;

        int cashSize = fromCash.size();
        int daoSize = calculatorDao.getSize();

        if (daoSize == cashSize)
            return fromCash;

        var fromDao = calculatorDao.getLast(10 - cashSize, cashSize)
                .stream()
                .map(ExpressionDto::new)
                .collect(Collectors.toList());

        fromCash.addAll(fromDao);

        return fromCash;
    }

}
