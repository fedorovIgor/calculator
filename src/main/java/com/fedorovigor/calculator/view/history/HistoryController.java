package com.fedorovigor.calculator.view.history;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HistoryController {

    private HistoryViewModel historyViewModel;

    @FXML
    private Label label;

    public HistoryController() {
    }

    public void init(HistoryViewModel historyViewModel) {
        label.setText("Be Happy!");
    }
}
