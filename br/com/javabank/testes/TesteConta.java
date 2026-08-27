package br.com.javabank.testes;

import br.com.javabank.modelo.Conta;

public class TesteConta {
    //ATALHO MAIN ==> PSVM + TAB
    public static void main(String[] args) {
        //INSTANCIAÇÃO
        Conta c1 = new Conta();
        Conta c2 = new Conta();
        Conta c3 = c1;
        Conta c4 = new Conta();

        //objeto c1
        c1.titular = "Juca";
        c1.numero = 1000;
        c1.saldo = 500;

        //objeto c2
        c2.numero = 1001;
        c2.titular = "Ana";
        c2.saldo = 1200;

        c3.titular = "Edgar";

        //Objeto c4
        c4.numero = 1001;
        c4.titular = "Ana";
        c4.saldo = 1200;

        System.out.println("Saldo C1: " + c1.saldo);
        System.out.println("Saldo C2: " + c2.saldo);

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);

        c3.titular = "Edgar";

        System.out.println(c3.titular);
        System.out.println(c1.titular);

        System.out.println(c2.saldo == c4.saldo);
        System.out.println(c2.numero == c4.numero);
        System.out.println(c2.titular == c4.titular);
        System.out.println(c2 == c4);
        System.out.println(c1 == c3);

        System.out.println("Saldo atual [c1]: " + c1.saldo);
        c1.depositar(500);
        System.out.println("Saldo atual [c1]: " + c1.saldo);
        c1.sacar(300);
        System.out.println("Saldo atual [c1]: " + c1.saldo);
        c1.saldo -= 500000;
        System.out.println("Saldo atual [c1]: " + c1.saldo);
    }
}
