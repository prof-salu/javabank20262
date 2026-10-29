package br.com.javabank.testes;

public class TesteThreads01 {
    public static void main(String[] args) {
        Relatorio relatorio = new Relatorio();
        PDF pdf = new PDF();

        Thread t1 = new Thread(relatorio);
        Thread t2 = new Thread(pdf);

        t1.start();
        t2.start();
    }
}
