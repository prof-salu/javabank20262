package br.com.javabank.testes;


import br.com.javabank.modelo.Conta;
import br.com.javabank.modelo.Corrente;
import br.com.javabank.modelo.Poupanca;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class TesteColecoes02 {
    public static void main(String[] args) {
        //Lista de contas
        List<Conta> listaConta = new ArrayList<>();
        //Adicionando contas a lista
        listaConta.add(new Corrente(1001, "Ana", 500));
        listaConta.add(new Corrente(1002, "Marcia", 600));
        listaConta.add(new Poupanca(1003, "Pedro", 1));
        listaConta.add(new Poupanca(1004, "Bruna", 0.75));
        listaConta.add(new Corrente(1005, "Juca", 900));
        listaConta.add(new Corrente(1006, "Marilha", 1000));
        listaConta.add(new Corrente(1006, "Marilha", 1000));
        listaConta.add(new Corrente(1006, "Marilha", 1000));

        for(Conta c : listaConta){
            c.depositar(100);
            System.out.println(c);
        }
        System.out.println();
        //Adicionando em uma determinada posição.
        //Caso a posição não exita, é lançado uma exceção!
        listaConta.add(1, new Poupanca(1007, "Juvenal", 0.88));
        //Remover elementos
        listaConta.remove(5);

        for(Conta c : listaConta){
            System.out.println(c);
        }

        System.out.println();

        //Acessando um elemento da lista por posição
        System.out.println(listaConta.get(3));

        //Verifica se existe um elemento na lista
        System.out.println("Tem Pedro: " + listaConta.contains("Pedro"));
        System.out.println("Tem Pedro: " + listaConta.contains(new Poupanca(1003, "Pedro", 5)));
        //Verifica se a lista está vazia (tem elementos)
        System.out.println("Ta vazia: " + listaConta.isEmpty());
        //listaConta.clear();//Limpa os dados da lista
        System.out.println("Ta vazia: " + listaConta.isEmpty());

        //Organiza uma lista
        Collections.sort(listaConta);
        System.out.println();
        for(Conta c : listaConta){
            System.out.println(c);
        }
    }
}
