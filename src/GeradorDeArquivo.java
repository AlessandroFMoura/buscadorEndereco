import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class GeradorDeArquivo {

//    private BuscaCep endereco = new BuscaCep();


    public void gerar(Endereco cep) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        FileWriter json = new FileWriter(cep.cep()+".json");
        json.write(gson.toJson(cep));
        json.close();
    }

//    public String gerar(String cep) throws IOException {
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//
//        Endereco arq = this.endereco.buscarCep(cep);
//        FileWriter json = new FileWriter("resultadoBusca.json");
//        json.write(gson.toJson(arq));
//        json.close();
//        return arq.toString();
//    }

}
