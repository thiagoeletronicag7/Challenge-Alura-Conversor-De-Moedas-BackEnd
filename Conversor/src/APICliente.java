import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class APICliente {
    private static final String API_KEY = "c759257d9c7136f9936e23bf";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";

    public double getTaxaDeCambio(String moedaOrigem, String moedaDestino) throws Exception {
        //definir a URL
        String urlStr = BASE_URL + moedaOrigem;
        URL url = new URL(urlStr);

        // Fazer a requisição
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

        //converter resposta em JSON
        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader(request.getInputStream()));
        JsonObject jsonobj = root.getAsJsonObject();

        //acessar a taxa de câmbio
        if (!jsonobj.get("result").getAsString().equals("success")) {
            throw new Exception("Falha ao obter taxa de câmbio");
        }
        JsonObject rates = jsonobj.getAsJsonObject("conversion_rates");
        return rates.get(moedaDestino).getAsDouble();
    }
}
