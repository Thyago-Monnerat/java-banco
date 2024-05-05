import java.util.Scanner;
import java.util.Random;

/**
 * @author Thyago Monnerat <br>
 * @since 2024 <br><br>
 * Código feito para o desafio da DIO sobre Java Sintaxe.
 * Uma simulação de cadastro em uma conta bancária, onde o programa retorna uma mensagem personalizada de acordo com os dados inseridos.
 * Toda agência e conta gerada neste código é completamente aleatória e não possui o intuito de lesar qualquer pessoa!
 * Código apenas para estudos.
 */
public class ContaTerminal { 
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        
        /**Recebendo o nome do usuário */
        System.out.println("Insira seu nome: ");
        String nome = scanner.next();
        /**Recebendo a agência através do método gerarAgencia() */
        String agencia = gerarAgencia();
        /**Recebendo o número da conta através do método gerarConta() */
        int conta = gerarConta();
        /**Recebendo o saldo do usuário */
        System.out.println("Digite seu saldo: ");
        double saldo = scanner.nextDouble();

        exibirInfos(nome, agencia, conta, saldo);

        /**Recebi um aviso da IDE dizendo que a variável scanner nunca tinha sido fechada.
         * Depois de pesquisar, resolvi implementar o .close para evitar vazamentos de recursos.
         */
        scanner.close();
    }

    /**Método para retornar um número de agência aleatória. */
    public static String gerarAgencia(){
        /**String.format "%03d-%d" fornece uma garantia de termos sempre 4 dígitos, sendo o último separado dos demais por -.
         */
        String agencia = String.format("%03d-%d", new Random().nextInt(1000), new Random().nextInt(10));
        return agencia;
    }
        /**Método para retornar um número de conta aleatória. */
    public static int gerarConta(){
        /**Gerando um número aleatório de 6 dígitos. 
         * O range do nextInt é 0 e 899999. Ao somarmos 100000, garantimos que o número gerado será de 6 dígitos.*/
        int conta = new Random().nextInt(900000) + 100000;
        return conta;
    }

    /**Método para exibir as informações no terminal.<br><br>
     * Fiz para praticar os métodos com parâmetros formais e a passagem de parâmetros reais.
     * @param nome - Representa o nome do usuário.
     * @param agencia - Representa a agência bancária do usuário.
     * @param conta - Representa o número da conta bancária do usuário.
     * @param saldo - Representa o saldo bancário do usuário.
     */
    public static void exibirInfos(String nome, String agencia, int conta, double saldo){
        System.out.println("Olá " + nome + "! Você acaba de criar sua conta em nosso sistema bancário.");
        System.out.println("Sua agência é: " + agencia);
        System.out.println("Sua conta é: " + conta);
        System.out.println("Seu saldo de R$ " + saldo + " já está disponível para saque!");
    }
}
