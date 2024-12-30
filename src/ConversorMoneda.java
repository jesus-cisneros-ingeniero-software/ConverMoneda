import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class ConversorMoneda {
    public double obtenerTasa(String baseCode, String targetCode) {
        String apikey="f11b71fb701ec0b33cc028c4";
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/"+apikey
                +"/latest/" + baseCode);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            Moneda datos = new Gson().fromJson(response.body(), Moneda.class);
            Map<String, Double> tasas = datos.conversion_rates();
            if (tasas.containsKey(targetCode)) {
                return tasas.get(targetCode);
            } else {
                throw new RuntimeException("No se encontró la tasa de cambio para " + targetCode);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener las tasas de cambio: " + e.getMessage());
        }
    }
}