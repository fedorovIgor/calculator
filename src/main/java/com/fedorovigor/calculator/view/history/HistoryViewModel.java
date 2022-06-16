package com.fedorovigor.calculator.view.history;

import com.fedorovigor.calculator.service.CalculatorService;

public class HistoryViewModel {

    private final CalculatorService calculatorService;

    public HistoryViewModel(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }
}
