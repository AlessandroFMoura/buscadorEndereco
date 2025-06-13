import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {

        try (Scanner scan = new Scanner(System.in)) {
            String cep = "";
            while (!cep.equalsIgnoreCase("sair")) {

                System.out.print("Informe seu CEP: ");
                cep = scan.nextLine().replaceAll("[-.\\s]", "");

                if (cep.equalsIgnoreCase("sair")) {
                    break;
                }

                try {
                    Gson json = new GsonBuilder()
                            .setPrettyPrinting()
                            .create();

                    BuscaCep cep1 = new BuscaCep();
                    System.out.println(json.toJson(cep1.buscarCep(cep)));
                    GeradorDeArquivo novoEndereco = new GeradorDeArquivo();
                    novoEndereco.gerar(cep1.buscarCep(cep));

                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                    System.out.println("Tente novamente!");

                }
            }
        } finally {
            System.out.println("Finalizando a Aplicação.");
        }
    }
}