package br.com.javabank.modelo;

//Classes FINAL não podem ser estendidas
public final class Poupanca extends Conta{
    private double taxaJuros;

    public Poupanca(int numero,
                    String titular,
                    double taxaJuros){
        super(numero, titular);
        this.taxaJuros = taxaJuros;
    }

    public double getTaxaJuros(){
        return taxaJuros;
    }

    public double calcularRendimento(){
        return (getSaldo() * taxaJuros) / 100;
    }

    @Override
    public boolean sacar(double valor) {
        if(valor > 0 && valor <= this.saldo){
            this.saldo -= valor;
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public String toString() {
        return super.toString() + String.format("| Taxa de juros: %.1f%%", taxaJuros);
    }

}