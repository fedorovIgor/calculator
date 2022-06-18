package com.fedorovigor.calculator.config;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        ServiceFactory serviceFactory = new ServiceFactory();
        ViewModelFactory viewModelFactory = new ViewModelFactory(serviceFactory.getCalculatorService());

        FxmlFilesLoader loader = new FxmlFilesLoader(viewModelFactory);

        Scene scene = new Scene((Parent)loader.load(FxmlFilesLoader.FileToLoad.CALCULATOR));

        stage.setTitle("I`m your calculator!");
        stage.setScene(scene);
        stage.show();
    }

}