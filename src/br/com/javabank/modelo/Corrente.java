package br.com.javabank.modelo;

//Classes FINAL não podem ser estendidas
public final class Corrente extends Conta{
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
    public boolean sacar(double valor)throws Exception {
        if(valor > this.saldo + limite){
            throw new SaldoInsuficienteException();
        }else if(valor <= 0){
            throw new IllegalArgumentException("O valor do saque deve ser positivo");
        }

        this.saldo -= valor;
            return true;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("| Limite: R$%.2f", limite);
    }
}
