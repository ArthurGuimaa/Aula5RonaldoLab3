package com.example.aula5ronaldolab3.controller;

import com.example.aula5ronaldolab3.model.ArquivoUtil;
import com.example.aula5ronaldolab3.model.Pessoa;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.io.IOException;

public class HelloController {
    @FXML private TextField txtNome;
    @FXML private TextField txtAltura;
    @FXML private TextField txtPeso;
    @FXML private Label lblResultadoIMC;
    @FXML private TableView<Pessoa> tablePessoas;
    @FXML private TableColumn<Pessoa, String> colNome;
    @FXML private TableColumn<Pessoa, Double> colAltura;
    @FXML private TableColumn<Pessoa, Double> colIMC;

    private ObservableList<Pessoa> listaPessoas = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colAltura.setCellValueFactory(new PropertyValueFactory<>("altura"));
        colIMC.setCellValueFactory(new PropertyValueFactory<>("imc"));
        tablePessoas.setItems(listaPessoas);
    }

    @FXML
    protected void onCalcularClick() {
        try {
            String nome = txtNome.getText();
            double altura = Double.parseDouble(txtAltura.getText().replace(",", "."));
            double peso = Double.parseDouble(txtPeso.getText().replace(",", "."));

            Pessoa p = new Pessoa(nome, altura, peso);
            double imcValue = p.getImc();

            // Classificação baseada no PDF [cite: 36-41]
            String status;
            if (imcValue < 18.5) status = "Abaixo do Peso";
            else if (imcValue < 24.9) status = "Peso Normal";
            else if (imcValue < 29.9) status = "Sobrepeso";
            else if (imcValue < 34.9) status = "Obesidade Grau 1";
            else if (imcValue < 39.9) status = "Obesidade Grau 2";
            else status = "Obesidade Grau 3";

            lblResultadoIMC.setText(String.format("%.2f\n%s", imcValue, status));
            listaPessoas.add(p);
        } catch (NumberFormatException e) {
            lblResultadoIMC.setText("Erro de Formato");
        }
    }

    @FXML
    protected void onSalvarClick() {
        try {
            ArquivoUtil.salvar(listaPessoas);
        } catch (IOException e) {
            System.err.println("Erro ao salvar: " + e.getMessage());
        }
    }

    @FXML
    protected void onCarregarClick() {
        try {
            listaPessoas.setAll(ArquivoUtil.carregar());
        } catch (IOException e) {
            System.err.println("Erro ao carregar: " + e.getMessage());
        }
    }
}