public class ConversorDeMoedas {

    private final APICliente apiCliente;

    public ConversorDeMoedas(APICliente apiCliente) {
        this.apiCliente = apiCliente;
    }

    public void converter(String moedaOrigem, String moedaDestino, double valor) {
        try {
            double taxa = apiCliente.getTaxaDeCambio(moedaOrigem, moedaDestino);
            double valorConvertido = valor * taxa;
            System.out.printf("O valor convertido de %f %s para %s é: %f%n", valor, moedaOrigem, moedaDestino, valorConvertido);
        } catch (Exception e) {
            System.out.println("Erro ao realizar a conversão: " + e.getMessage());
        }
    }

}
