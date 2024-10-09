import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        APICliente apiCliente = new APICliente();
        ConversorDeMoedas conversor = new ConversorDeMoedas(apiCliente);

        System.out.println("Seja bem-vindo(a) ao Conversor de Moedas ;)");

        int opcao;
        do {
            Menu.exibirMenu();
            opcao = entrada.nextInt();
            if (opcao == 7) break;

            System.out.println("Digite o valor que deseja converter:");
            double valor = entrada.nextDouble();

            switch (opcao) {
                case 1 -> conversor.converter("USD", "ARS", valor);
                case 2 -> conversor.converter("ARS", "USD", valor);
                case 3 -> conversor.converter("USD", "BRL", valor);
                case 4 -> conversor.converter("BRL", "USD", valor);
                case 5 -> conversor.converter("USD", "COP", valor);
                case 6 -> conversor.converter("COP", "USD", valor);
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 7);

        System.out.println("Até a próxima!");
    }
}