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

public class RestaurantDataProvider {
    private final URI uri;
    private final JsonParser jsonParser;

    public RestaurantDataProvider(URI uri, JsonParser jsonParser) {
        this.uri = uri;
        this.jsonParser = jsonParser;
    }

    public Results getRestaurantResults() throws NoRestaurantsFoundException, IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();

        HttpResponse response = httpClient.execute(new HttpGet(uri));

        String jsonResponse = IOUtils.toString(response.getEntity().getContent());

        if (jsonResponse == null | jsonResponse.isEmpty()) {
            throw new NoRestaurantsFoundException("No restaurant matches found from google.");
        }

        return jsonParser.parseString(jsonResponse);
    }
}