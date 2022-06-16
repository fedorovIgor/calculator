package com.fedorovigor.calculator.view.calculator;

import com.fedorovigor.calculator.service.CalculatorService;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CalculatorViewModel {

    private final CalculatorService calculatorService;

    private final StringProperty value;
    private final StringProperty result;
    private boolean historyActiveState;

    public CalculatorViewModel(CalculatorService service) {
        calculatorService = service;

        value = new SimpleStringProperty("2+20");
        result = new SimpleStringProperty("0");
    }

    public StringProperty valueProperty() {
        return value;
    }

    public StringProperty resultProperty() {
        return result;
    }



    public void calculateExpression() {
        String expression = value.getValue();
        Double answer = calculatorService.calculateAndSave(expression);

        value.setValue("0");
        result.setValue(answer.toString());
    }

    public void updateValue(String txt) {

        System.out.println(value.getValue() );

        if (value.getValue().equals("0"))
            value.setValue("");

        value.setValue(value.getValue() + txt);
    }

    public void deleteLastSymbol() {

        StringBuilder sb = new StringBuilder(value.getValue());

        if (sb.isEmpty())
            return;

        sb.deleteCharAt(sb.length()-1);
        value.setValue(sb.toString());
    }

    public void clearValue() {

        value.setValue("0");

    }

    public boolean isHistoryActive() {
        return historyActiveState;
    }

    public void nextHistoryActiveState() {
        if (historyActiveState)
            historyActiveState = false;
        else historyActiveState = true;
    }
}
