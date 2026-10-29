package br.com.javabank.testes;

//Implementando a interface Runnable
public class Relatorio implements Runnable{
    public void montar(){
        for(int i = 0; i <= 100; i++){
            System.out.println("Montando relatório: " + i + "%");
        }
    }

    @Override
    public void run() {
        montar();
    }
}
