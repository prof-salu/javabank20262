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
                System.out.println("Escolha uma opção: ");
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
                    case 3 -> {}
                    case 4 -> {}
                    case 5 -> {

                    }

                    case 6 -> {
                        System.out.print("Informe o numero da conta: ");
                        int numero = Integer.parseInt(entrada.nextLine());

                        if(c2 instanceof Poupanca && c2.getNumero() == numero){
                            double rendimento = ((Poupanca) c2).calcularRendimento();
                            System.out.printf("Valor do rendimento: %.2f", rendimento);
                            c2.depositar(rendimento);
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