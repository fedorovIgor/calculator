package com.fedorovigor.calculator.view.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class CalculatorController {

    private CalculatorViewModel calculatorViewModel;

    @FXML
    private Label value;
    @FXML
    private Label result;
    @FXML
    private VBox manePane;
    private Node historyNode;


    public void init(CalculatorViewModel calculatorViewModel, Node historyNode) {

        this.calculatorViewModel = calculatorViewModel;
        this.historyNode = historyNode;

        value.textProperty().bindBidirectional(calculatorViewModel.valueProperty());
        result.textProperty().bindBidirectional(calculatorViewModel.resultProperty());

    }

    public CalculatorController() {}

    @FXML
    protected void showHistory(ActionEvent event) {
        if (calculatorViewModel.isHistoryActive())
            manePane.getChildren().remove(historyNode);
        else manePane.getChildren().add(historyNode);

        calculatorViewModel.nextHistoryActiveState();
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