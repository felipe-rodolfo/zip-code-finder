package br.com.main;

import br.com.main.models.ZipCode;
import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class FetchCEP {

    public static ZipCode fetchAndParseZIPCode(String search, String urlApi) throws IOException, InterruptedException {
        String address = String.format(urlApi, search);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(address))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return new Gson().fromJson(response.body(), (Type) ZipCode.class);

    }
}
