package br.com.javabank.testes;

import java.util.HashSet;
import java.util.Set;

public class TestePerformanceColecoesSet {
    public static void main(String[] args) {
        int totalItens = 1000000;

        Set<Integer> conjunto = new HashSet<>();

        long inicio = System.currentTimeMillis();

        //Adicionando 1000000 de valores a lista
        for(int i = 0; i < totalItens; i++){
            conjunto.add(i);
        }

        //Buscando valores
        for(int i = 0; i < totalItens;i++) {
            conjunto.contains(i);
        }
        long fim = System.currentTimeMillis();

        System.out.println("Tempo decorrido: " + (fim - inicio));
    }
}
