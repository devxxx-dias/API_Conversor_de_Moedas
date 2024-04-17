package module;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class ConsultarMoeda {
    Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();
    public String opcao;
    public String moedaParaConverter;
    public String moedaConvertida;
    public double valor;

    public ConsultarMoeda(Menu menu) {
        this.opcao = menu.opcao;
        this.moedaParaConverter = menu.moedaParaConverter;
        this.moedaConvertida = menu.moedaConvertida;
        this.valor = menu.valor;
    }


    public MoedaConvertida converta() throws IOException, InterruptedException {
        String urlApi = "https://v6.exchangerate-api.com/v6/2ceb93692a4482f2955df499/pair/" + moedaParaConverter + "/" + moedaConvertida + "/" + valor;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlApi))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        MoedaConvertida resultadoDaConversao = gson.fromJson(response.body(), MoedaConvertida.class);
        return resultadoDaConversao;
    }

}








