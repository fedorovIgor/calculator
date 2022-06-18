package com.fedorovigor.calculator;

import com.fedorovigor.calculator.config.MainApp;
import com.fedorovigor.calculator.model.entity.ExpressionEntity;
import com.fedorovigor.calculator.repository.RelativeDatabaseCalculatorDao;
import javafx.application.Application;

import java.time.LocalDateTime;


public class Main {

    public static void main(String[] args) {
        Application.launch(MainApp.class);
    }
}


