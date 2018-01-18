package nom.googleapi;

import jsonprovider.JsonParser;
import jsonprovider.NoRestaurantsFoundException;
import nom.googleapi.domain.Results;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.net.URI;

import static java.nio.charset.Charset.defaultCharset;

public class RestaurantDataProvider {
    private final URI uri;
    private final JsonParser jsonParser;
    private final HttpClient httpClient;

    public RestaurantDataProvider(URI uri, JsonParser jsonParser) {
        this.uri = uri;
        this.jsonParser = jsonParser;
        this.httpClient = HttpClientBuilder.create().build();
    }

    public Results getRestaurantResults() throws NoRestaurantsFoundException {
        String jsonResponse = readJson();

        if (jsonResponse == null || jsonResponse.isEmpty()) {
            throw new NoRestaurantsFoundException("No restaurant matches found from google.");
        }

        return jsonParser.parseString(jsonResponse);
    }

    private String readJson() {
        try {

            HttpResponse response = httpClient.execute(new HttpGet(uri));

            return IOUtils.toString(response.getEntity().getContent(), defaultCharset());
        } catch (IOException e) {
            throw new RuntimeException("Failed to read json from http", e);
        }
    }
}