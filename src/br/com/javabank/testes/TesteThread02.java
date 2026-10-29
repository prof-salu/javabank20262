package br.com.javabank.testes;

import br.com.javabank.modelo.Corrente;

public class TesteThread02 {
    public static void main(String[] args) throws InterruptedException {
        Corrente conta = new Corrente(1000, "Juca", 0);
        System.out.println("Saldo inicial: " + conta.getSaldo());
        Thread threads[] = new Thread[50000];

        for(int i = 0; i < threads.length; i++){
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    conta.depositar(100);
                }
            });
            threads[i].start();
        }

        for(int i = 0; i < threads.length;i++){
            try{
                threads[i].join();
            }catch(Exception e){
                System.out.println(e);
            }
        }
        System.out.println("Saldo final: " + conta.getSaldo());
    }
}
