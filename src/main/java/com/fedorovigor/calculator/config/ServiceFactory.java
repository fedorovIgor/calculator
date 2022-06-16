package com.fedorovigor.calculator.config;

import com.fedorovigor.calculator.dao.CalculatorCash;
import com.fedorovigor.calculator.dao.CalculatorDao;
import com.fedorovigor.calculator.dao.InMemoryCalculatorDao;
import com.fedorovigor.calculator.dao.InMemoryCash;
import com.fedorovigor.calculator.service.CalculatorService;
import com.fedorovigor.calculator.service.CalculatorServiceWithCash;

public class ServiceFactory {

    private final CalculatorService calculatorService;


    public ServiceFactory() {

        CalculatorDao calculatorDao = new InMemoryCalculatorDao();
        CalculatorCash calculatorCash = new InMemoryCash();

        this.calculatorService = new CalculatorServiceWithCash(calculatorDao, calculatorCash);
    }

    public CalculatorService getCalculatorService() {
        return calculatorService;
    }
}