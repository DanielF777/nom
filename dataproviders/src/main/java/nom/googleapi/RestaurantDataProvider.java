package nom.googleapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import jsonprovider.JsonParser;
import jsonprovider.NoRestaurantsFoundException;
import nom.googleapi.domain.Restaurant;
import nom.googleapi.domain.Results;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

public class RestaurantDataProvider {

    private JsonParser jsonParser;

    public RestaurantDataProvider(ObjectMapper objectMapper) {
        this.jsonParser = new JsonParser(objectMapper);
    }

    public List<Restaurant> findAllRestaurants(URI uri) throws NoRestaurantsFoundException, IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();

        HttpResponse response = httpClient.execute(new HttpGet(uri));

        String s = IOUtils.toString(response.getEntity().getContent());

        if (s == null | s.isEmpty()) {
            throw new NoRestaurantsFoundException("No restaurant matches found from google.");
        }

        Results results = jsonParser.parseString(s);

        return Arrays.asList(results.getRestaurants());
    }
}