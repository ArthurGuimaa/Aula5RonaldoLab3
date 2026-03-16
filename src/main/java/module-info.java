module com.example.aula5ronaldolab3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.aula5ronaldolab3 to javafx.fxml;
    exports com.example.aula5ronaldolab3;
}