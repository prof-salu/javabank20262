import br.com.javabank.modelo.Conta;
import br.com.javabank.modelo.Corrente;
import br.com.javabank.modelo.Poupanca;

import java.util.Scanner;

public class App {
    //ATALHO ==> PSVM + TAB --> main()
    public static void main(String[] args) {
        //ATALHO ==> SOUT + TAB --> println
        System.out.println("JAVABANK - TERMINAL DO CAIXA");
        //Variaveis
        Scanner entrada = new Scanner(System.in);
        boolean operadorAutenticado = false;

        //CONSTANTE (final)
        final int SENHA_OPERADOR = 8888;

        for(int tentativa = 1; tentativa <= 3; tentativa+=1){
            System.out.print("Informe a sua SENHA: ");
            int senha = Integer.parseInt(entrada.nextLine());

            if(senha == SENHA_OPERADOR){
                System.out.println("[SESSÃO INICIADA] Bem-vindo.");
                operadorAutenticado = true;
                break;
            }else{
                System.out.println("[ALERTA] Senha incorreta");
            }
        }

        if(operadorAutenticado == false){
            System.out.println("[BLOQUEIO] Limite de tentativas excedidas!");
        }else{
            Corrente c1 = new Corrente(1000, "Juca", 1000);
            Conta c2 = null;
            int opcao = 0;

            do{
                System.out.println("\nEscolha uma opção: ");
                System.out.println("1- Criar/Abrir conta");
                System.out.println("2- Consultar Dados");
                System.out.println("3- Realizar Deposito");
                System.out.println("4- Realizar Saque");
                System.out.println("5- Realizar Transferencia");
                System.out.println("6- Aplicar Rendimento (Conta Poupança)");
                System.out.println("7- Encerrar Caixa");
                System.out.print("Selecione uma opção: ");
                opcao = Integer.parseInt(entrada.nextLine());

                switch(opcao){
                    case 1 -> {
                        if(c2 == null){
                            System.out.println("Informe o tipo de Conta: ");
                            System.out.println("1- Conta Corrente");
                            System.out.println("2- Conta Poupança");
                            System.out.print("Tipo de conta: ");
                            int tipo = Integer.parseInt(entrada.nextLine());

                            System.out.print("Informe o numero da conta: ");
                            int numeroConta = Integer.parseInt(entrada.nextLine());
                            System.out.print("Informe o titular da conta: ");
                            String titular = entrada.nextLine();

                            if(tipo == 1){
                                //Corrente
                                System.out.print("Informe o limite da conta: ");
                                double limite = Double.parseDouble(entrada.nextLine());

                                c2 = new Corrente(numeroConta, titular, limite);
                            }else{
                                //Poupança
                                System.out.print("Informe a taxa de rendimento: ");
                                double rendimento = Double.parseDouble(entrada.nextLine());
                                c2 = new Poupanca(numeroConta, titular, rendimento);
                            }

                            System.out.println("Conta criada com sucesso!");
                        }else{
                            System.out.println("Todas as contas estão criadas!");
                        }
                    }
                    case 2 -> {
                        System.out.print("Informe o numero da conta: ");
                        int numero = Integer.parseInt(entrada.nextLine());

                        if(c1.getNumero() == numero){
                            System.out.printf("Conta: %d | Titular: %s | Saldo: R$ %.2f | Limite: R$ %.2f\n",
                                    c1.getNumero(), c1.getTitular(), c1.getSaldo(), c1.getLimite());
                        }else if(c2 != null && c2.getNumero() == numero){
                            if(c2 instanceof Corrente){
                                System.out.printf("Conta: %d | Titular: %s | Saldo: R$ %.2f | Limite: R$ %.2f\n",
                                        c2.getNumero(), c2.getTitular(), c2.getSaldo(), ((Corrente) c2).getLimite());
                            }

                            if(c2 instanceof Poupanca){
                                System.out.printf("Conta: %d | Titular: %s | Saldo: R$ %.2f | Taxa de Rendimento:  %.2f %%\n",
                                        c2.getNumero(), c2.getTitular(), c2.getSaldo(), ((Poupanca) c2).getTaxaJuros());
                            }
                        }else{
                            System.out.println("Número de conta não encontrado.");
                        }
                    }
                    case 3 -> {
                        System.out.print("Informe o numero da conta para depósito: ");
                        int numero = Integer.parseInt(entrada.nextLine());
                        System.out.print("Informe o valor a ser depositado: R$ ");
                        double valor = Double.parseDouble(entrada.nextLine());

                        if(c1.getNumero() == numero){
                            c1.depositar(valor);
                            System.out.println("Depósito realizado com sucesso na conta de " + c1.getTitular());
                        }else if(c2 != null && c2.getNumero() == numero){
                            c2.depositar(valor);
                            System.out.println("Depósito realizado com sucesso na conta de " + c2.getTitular());
                        }else{
                            System.out.println("Número de conta não encontrado.");
                        }
                    }
                    case 4 -> {
                        System.out.print("Informe o numero da conta para saque: ");
                        int numero = Integer.parseInt(entrada.nextLine());
                        System.out.print("Informe o valor a ser sacado: R$ ");
                        double valor = Double.parseDouble(entrada.nextLine());

                        if(c1.getNumero() == numero){
                            c1.sacar(valor);
                            System.out.println("Operação de saque processada na conta de " + c1.getTitular());
                        }else if(c2 != null && c2.getNumero() == numero){
                            c2.sacar(valor);
                            System.out.println("Operação de saque processada na conta de " + c2.getTitular());
                        }else{
                            System.out.println("Número de conta não encontrado.");
                        }
                    }
                    case 5 -> {
                        System.out.print("Informe o numero da conta de ORIGEM: ");
                        int numeroOrigem = Integer.parseInt(entrada.nextLine());
                        System.out.print("Informe o numero da conta de DESTINO: ");
                        int numeroDestino = Integer.parseInt(entrada.nextLine());

                        System.out.print("Informe o valor da transferência: R$ ");
                        double valor = Double.parseDouble(entrada.nextLine());

                        Conta origem = null;
                        Conta destino = null;

                        // Buscar conta de origem
                        if(c1.getNumero() == numeroOrigem){
                            origem = c1;
                        }
                        else if(c2 != null && c2.getNumero() == numeroOrigem){
                            origem = c2;
                        }

                        // Buscar conta de destino
                        if(c1.getNumero() == numeroDestino) {
                            destino = c1;
                        }
                        else if(c2 != null && c2.getNumero() == numeroDestino) {
                            destino = c2;
                        }

                        // Se ambas as contas existirem, faz a transferência
                        if(origem != null && destino != null){
                            // Obs: Dependendo de como você programou a classe Conta, a assinatura do método pode mudar
                            // Se for transferir(double valor, Conta destino) use: origem.transferir(valor, destino);
                            // Se for transferir(Conta destino, double valor) use: origem.transferir(destino, valor);
                            origem.transferir(valor, destino);
                            System.out.println("Transferência realizada com sucesso!");
                        } else {
                            System.out.println("Erro: Conta de origem ou destino não encontrada.");
                        }
                    }
                    case 6 -> {
                        System.out.print("Informe o numero da conta: ");
                        int numero = Integer.parseInt(entrada.nextLine());

                        if(c2 instanceof Poupanca && c2.getNumero() == numero){
                            double rendimento = ((Poupanca) c2).calcularRendimento();
                            System.out.printf("Valor do rendimento: %.2f\n", rendimento);
                            c2.depositar(rendimento);
                        }else if(c1.getNumero() == numero || (c2 instanceof Corrente && c2.getNumero() == numero)){
                            System.out.println("Operação inválida: Esta não é uma conta poupança.");
                        }else{
                            System.out.println("Número de conta não encontrado.");
                        }
                    }
                    case 7 -> {
                        System.out.println("[FECHAMENTO] Encerrando o sistema.");
                    }
                    default -> {
                        System.out.println("Opção Invalida. Tente Novamente.");
                    }
                }
            }while(opcao != 7);
        }

        entrada.close();
    }
}