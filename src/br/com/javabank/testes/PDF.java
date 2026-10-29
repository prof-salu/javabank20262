package br.com.javabank.testes;

//Atraves da herança da classe Thread
public class PDF extends Thread{
    public void criar(){
        for(int i = 0; i <= 100; i++){
            System.out.println("Gerando o PDF: " + i + "%");
        }
    }

    @Override
    public void run() {
        criar();
    }
}
