import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scan = new Scanner(System.in);
        System.out.print("Informe seu CEP: ");
        String cep = scan.nextLine().replaceAll("[-. //s]", "");;



        try {
            BuscaCep cep1 = new BuscaCep();
            System.out.println(cep1.buscarCep(cep));
            GeradorDeArquivo novoEndereco = new GeradorDeArquivo();
            novoEndereco.gerar(cep1.buscarCep(cep));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            System.out.println("Finalizando a Aplicação.");
        }


    }
}