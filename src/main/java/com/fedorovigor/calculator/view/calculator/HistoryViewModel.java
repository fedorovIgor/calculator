package com.fedorovigor.calculator.view.calculator;

import com.fedorovigor.calculator.model.dto.ExpressionDto;
import com.fedorovigor.calculator.service.CalculatorService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class HistoryViewModel {

    private final CalculatorService calculatorService;


    private boolean historyActiveState;
    private ObservableList<String> expressions;

    public HistoryViewModel(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;

        expressions = FXCollections.observableArrayList();
    }

    public void nextHistoryActiveState() {
        if (historyActiveState)
            historyActiveState = false;
        else historyActiveState = true;
    }

    public boolean isHistoryActive() {
        return historyActiveState;
    }

    public void updateHistory() {
        var list = calculatorService.getLasTen().stream()
                .sorted(Comparator.comparingInt(ExpressionDto::getId).reversed())
                .map(i -> i.getExpression() + " = " + i.getResult())
                .collect(Collectors.toList());

        expressions.setAll(list);
    }

    public ObservableList<String> expressionList() {
        return expressions;
    }
}
