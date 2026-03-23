package com.example.aula5ronaldolab3.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArquivoUtil {
    private static final String FILE_NAME = "dados_pessoas.txt"; // [cite: 44]

    public static void salvar(List<Pessoa> pessoas) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Pessoa p : pessoas) {
                writer.write(p.toString()); // Salva no formato CSV [cite: 45]
                writer.newLine();
            }
        }
    }

    public static List<Pessoa> carregar() throws IOException {
        List<Pessoa> lista = new ArrayList<>();
        File file = new File(FILE_NAME);

        if (!file.exists()) return lista;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");
                if (dados.length == 4) {
                    lista.add(new Pessoa(
                            dados[0],
                            Double.parseDouble(dados[1]),
                            Double.parseDouble(dados[2]),
                            Double.parseDouble(dados[3].replace(",", "."))
                    ));
                }
            }
        }
        return lista;
    }
}