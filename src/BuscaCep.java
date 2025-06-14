import com.google.gson.Gson;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;

public class BuscaCep {

    private static final TrustManager[] trustAllCerts = new TrustManager[]{
            new X509TrustManager() {
                public void checkClientTrusted(X509Certificate[] chain, String authType) {}
                public void checkServerTrusted(X509Certificate[] chain, String authType) {}
                public X509Certificate[] getAcceptedIssuers() { return new X509Certificate[0]; }
            }
    };

    public Endereco buscarCep(String cep) {

        try  {
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, trustAllCerts, new SecureRandom());

            HttpClient client = HttpClient.newBuilder()
                    .sslContext(sslContext)
                    .build();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://viacep.com.br/ws/" + cep + "/json/"))
                    .build();

            HttpResponse<String> response =  client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Endereco.class);

        } catch (Exception e){
            throw  new RuntimeException("Não consegui obter o endereço: "+e);

        }

    }

}
