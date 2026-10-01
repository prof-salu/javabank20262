package br.com.javabank.testes;

import br.com.javabank.modelo.Conta;
import br.com.javabank.modelo.Corrente;
import br.com.javabank.modelo.Poupanca;

public class TesteAbstrato {
    public static void main(String[] args) {
        Conta c1 = new Corrente(1000, "Juca", 500);
        Conta c2 = new Poupanca(1001, "Ana", 1);
    }
}
