package br.com.javabank.testes;

import java.util.ArrayList;
import java.util.List;

public class TestePerfomanceColecoesList {
    public static void main(String[] args) {
        int totalItens = 1000000;

        List<Integer> lista = new ArrayList<>();

        long inicio = System.currentTimeMillis();

        //Adicionando 1000000 de valores a lista
        for(int i = 0; i < totalItens; i++){
            lista.add(i);
        }

        //Buscando valores
        for(int i = 0; i < totalItens;i++) {
            lista.contains(i);
        }
        long fim = System.currentTimeMillis();

        System.out.println("Tempo decorrido: " + ((fim - inicio)/1000) + " segundos");
    }
}
