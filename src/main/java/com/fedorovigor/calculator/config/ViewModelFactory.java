package com.fedorovigor.calculator.config;

import com.fedorovigor.calculator.service.CalculatorService;
import com.fedorovigor.calculator.view.calculator.CalculatorViewModel;
import com.fedorovigor.calculator.view.calculator.HistoryViewModel;

public class ViewModelFactory {

    private final CalculatorViewModel calculatorViewModel;
    private final HistoryViewModel historyViewModel;

    public ViewModelFactory(CalculatorService calculatorService) {
        calculatorViewModel = new CalculatorViewModel(calculatorService);
        historyViewModel = new HistoryViewModel(calculatorService);
    }

    public CalculatorViewModel getCalculatorViewModel() {
        return calculatorViewModel;
    }

    public HistoryViewModel getHistoryViewModel() {
        return historyViewModel;
    }
}
