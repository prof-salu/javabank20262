package br.com.javabank.testes;

import br.com.javabank.modelo.Conta;
import br.com.javabank.modelo.Corrente;
import br.com.javabank.modelo.Poupanca;

import java.util.ArrayList;
import java.util.HashSet;

public class TestePolimorfismo {

    public static void main(String[] args) {
        Corrente cc1 = new Corrente(1000, "Juca", 500);
        Corrente cc2 = new Corrente(1000, "Juca", 500);
        Poupanca cp1 = new Poupanca(1001, "Ana", 1);
        Poupanca cp2 = new Poupanca(1001, "Ana", 1);

        System.out.println(cc1.toString());
        System.out.println(cp1.toString());

        System.out.println(cc1.hashCode());
        System.out.println(cp1.hashCode());

        System.out.println(cc1.equals(cp1));
        System.out.println(cc1.equals(cc2));

        ArrayList<Conta> lista = new ArrayList<>();
        HashSet<Conta> conjunto = new HashSet<>();

        System.out.println("Conjunto de contas: ");
        conjunto.add(cc1);
        conjunto.add(cc2);
        conjunto.add(cp1);
        conjunto.add(cp2);

        for(Conta conta : conjunto){
            System.out.println(conta);
        }
    }
}
