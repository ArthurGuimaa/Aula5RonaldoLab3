package com.example.aula5ronaldolab3.model;

public class Pessoa {
    private String nome;
    private double altura;
    private double peso;
    private double imc;

    // Construtor para novas entradas
    public Pessoa(String nome, double altura, double peso) {
        this.nome = nome;
        this.altura = altura;
        this.peso = peso;
        this.imc = peso / (altura * altura); // Cálculo conforme a fórmula [cite: 11, 34]
    }

    // Construtor para carregar do arquivo
    public Pessoa(String nome, double altura, double peso, double imc) {
        this.nome = nome;
        this.altura = altura;
        this.peso = peso;
        this.imc = imc;
    }

    // Getters - O TableView usa esses nomes! [cite: 14, 21]
    public String getNome() { return nome; }
    public double getAltura() { return altura; }
    public double getPeso() { return peso; }
    public double getImc() { return imc; }

    @Override
    public String toString() {
        return nome + "," + altura + "," + peso + "," + String.format("%.2f", imc);
    }
}