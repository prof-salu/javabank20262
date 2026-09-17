package br.com.javabank.modelo;

public class Corrente extends Conta{
    private double limite;

    public Corrente(int numero,
                    String titular,
                    double limite){
        //É uma chamada a super classe
        //Chamando o contrutor da classe Conta
        super(numero, titular);
        this.limite = limite;
    }

    public double getLimite(){
        return this.limite;
    }

    //Reescrita de funçoes (OVERRIDE)
    @Override //Anotação
    public boolean sacar(double valor) {
        if(valor > 0 && valor <= this.saldo + limite){
            this.saldo -= valor;
            return true;
        }
        else{
            return false;
        }
    }
}
