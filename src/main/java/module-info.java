module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.zaxxer.hikari;
    requires java.sql;
    requires org.slf4j;


    opens com.fedorovigor.calculator to javafx.fxml;
    exports com.fedorovigor.calculator;
    exports com.fedorovigor.calculator.service;
    opens com.fedorovigor.calculator.service to javafx.fxml;
    exports com.fedorovigor.calculator.config;
    opens com.fedorovigor.calculator.config to javafx.fxml;
    exports com.fedorovigor.calculator.view.calculator;
    opens com.fedorovigor.calculator.view.calculator to javafx.fxml;
}