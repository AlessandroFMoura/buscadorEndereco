import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class GeradorDeArquivo {
    public void gerar(Endereco cep) throws IOException {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        FileWriter json = new FileWriter(cep.cep()+".json");
        json.write(gson.toJson(cep));
        json.close();
    }
}
