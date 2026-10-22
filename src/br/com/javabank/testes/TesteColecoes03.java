package br.com.javabank.testes;

import br.com.javabank.modelo.Conta;
import br.com.javabank.modelo.Corrente;
import br.com.javabank.modelo.Poupanca;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TesteColecoes03 {
    public static void main(String[] args) {
        //Conjuntos de contas
        Set<Conta> conjuntoContas = new HashSet<>();

        //Adicionando contas ao conjunto
        conjuntoContas.add(new Corrente(1001, "Ana", 500));
        conjuntoContas.add(new Corrente(1002, "Marcia", 600));
        conjuntoContas.add(new Poupanca(1003, "Pedro", 1));
        conjuntoContas.add(new Poupanca(1004, "Bruna", 0.75));
        conjuntoContas.add(new Corrente(1005, "Juca", 900));
        conjuntoContas.add(new Corrente(1006, "Marilha", 1000));

        conjuntoContas.add(new Corrente(1006, "Marilha", 1000));
        conjuntoContas.add(new Corrente(1006, "Marilha", 1000));
        conjuntoContas.add(new Corrente(1006, "Marilha", 1000));

        for(Conta c : conjuntoContas){
            c.depositar(100);
            System.out.println(c);
        }
        System.out.println();
    }
}
