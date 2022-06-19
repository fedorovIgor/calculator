package com.fedorovigor.calculator.view.calculator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

public class CalculatorController {

    private CalculatorViewModel calculatorViewModel;
    private HistoryViewModel historyViewModel;

    @FXML
    private Label value;
    @FXML
    private Label result;
    @FXML
    private VBox mainPane;
    @FXML
    private ListView<String> listView;

    public void init(CalculatorViewModel calculatorViewModel,
                     HistoryViewModel historyViewModel) {

        this.calculatorViewModel = calculatorViewModel;
        this.historyViewModel = historyViewModel;

        listView.setItems(historyViewModel.expressionList());

        value.textProperty().bindBidirectional(calculatorViewModel.valueProperty());
        result.textProperty().bindBidirectional(calculatorViewModel.resultProperty());
    }

    public CalculatorController() {}

    @FXML
    protected void showHistory(ActionEvent event) {
        if (!historyViewModel.isHistoryActive())
            mainPane.getChildren().remove(listView);
        else mainPane.getChildren().add(listView);

        historyViewModel.nextHistoryActiveState();
    }

    @FXML
    protected void onCalculateButton(ActionEvent event) {
        Button btn = (Button) event.getSource();
        String txt = btn.getText();

        calculatorViewModel.updateValue(txt);
    }

    @FXML
    protected void onEqualButton(ActionEvent event) {
        calculatorViewModel.calculateExpression();

        historyViewModel.updateHistory();
    }

    @FXML
    protected void onBackspace() {
        calculatorViewModel.deleteLastSymbol();
    }

    @FXML
    protected void onDelete() {
        calculatorViewModel.clearValue();
    }
}