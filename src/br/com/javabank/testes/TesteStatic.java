package br.com.javabank.testes;

import br.com.javabank.modelo.Corrente;
import br.com.javabank.modelo.Poupanca;

public class TesteStatic {
    public static void main(String[] args) {
        Corrente cc1 = new Corrente(1000, "Juca", 500);
        System.out.println(Corrente.getTotalContas());
        Corrente cc2 = new Corrente(1001, "Ana", 400);
        System.out.println(Corrente.getTotalContas());
        Corrente cc3 = new Corrente(1002, "Pedro", 800);
        System.out.println(Corrente.getTotalContas());
        Poupanca cp1 = new Poupanca(1003, "Clara", 1);
        System.out.println(Poupanca.getTotalContas());
    }
}
