package nom.googleapi;

import jsonprovider.NoRestaurantsFoundException;
import nom.googleapi.domain.PlaceType;
import nom.googleapi.domain.Restaurant;
import nom.googleapi.domain.UriBuilder;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.net.URI;
import java.util.List;

public class RestaurantDataProvider {

    public List<Restaurant> findRestaurants() throws NoRestaurantsFoundException, IOException {
        URI uri = new UriBuilder("http://localhost:8000").withType(PlaceType.FOOD).asUri();

        HttpClient httpClient = HttpClientBuilder.create().build();

        HttpResponse response = httpClient.execute(new HttpGet(uri));

        String s = IOUtils.toString(response.getEntity().getContent());

        System.out.println("s = " + s);

        //request from google with params some restaurants

        //receive json response with restaurants

        //json parser maps to objects

        throw new NoRestaurantsFoundException("No restaurants found.");
    }
}