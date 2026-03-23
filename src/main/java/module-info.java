module com.example.aula5ronaldolab3 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.aula5ronaldolab3 to javafx.fxml;
    exports com.example.aula5ronaldolab3;
    exports com.example.aula5ronaldolab3.controller;
    opens com.example.aula5ronaldolab3.controller to javafx.fxml;
    exports com.example.aula5ronaldolab3.model;
    opens com.example.aula5ronaldolab3.model to javafx.fxml;
}