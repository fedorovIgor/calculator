package com.fedorovigor.calculator.config;

import com.fedorovigor.calculator.repository.CalculatorCash;
import com.fedorovigor.calculator.repository.CalculatorDao;
import com.fedorovigor.calculator.repository.InMemoryCalculatorDao;
import com.fedorovigor.calculator.repository.InMemoryCash;
import com.fedorovigor.calculator.service.CalculatorService;
import com.fedorovigor.calculator.service.CalculatorServiceWithCash;
import com.fedorovigor.calculator.util.ExpressionCalculator;
import com.fedorovigor.calculator.util.polish.PolishNotationCalculator;

public class ServiceFactory {

    private final CalculatorService calculatorService;


    public ServiceFactory() {

        CalculatorDao calculatorDao = new InMemoryCalculatorDao();
        CalculatorCash calculatorCash = new InMemoryCash();
        ExpressionCalculator expressionCalculator = new PolishNotationCalculator();

        this.calculatorService = new CalculatorServiceWithCash(calculatorDao, calculatorCash, expressionCalculator);
    }

    public CalculatorService getCalculatorService() {
        return calculatorService;
    }
}
