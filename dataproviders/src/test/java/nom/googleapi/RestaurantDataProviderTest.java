package nom.googleapi;

import com.sun.net.httpserver.HttpServer;
import jsonprovider.NoRestaurantsFoundException;
import nom.googleapi.domain.Restaurant;
import nom.googleapi.domain.UriBuilder;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

/**
 * Created by dev on 06/12/2017.
 */
public class RestaurantDataProviderTest {

    private RestaurantDataProvider restaurantDataProvider;
    public String response;


    @Before
    public void setUp() throws Exception {
        startHttpServer();
        UriBuilder uriBuilder = new UriBuilder("http://localhost:8000");
        restaurantDataProvider = new RestaurantDataProvider();
    }

    @Test(expected = NoRestaurantsFoundException.class)
    public void throwsExceptionWhenGoogleReturnsNoResults() throws Exception {
        restaurantDataProvider.findRestaurants();
    }

    @Test
    public void name() throws Exception {

    }


    @Test
    public void testJsonFromServer() throws Exception {


        List<Restaurant> restaurantList = restaurantDataProvider.findRestaurants();

        assertThat(restaurantList, hasSize(3));
    }

    private void startHttpServer() throws IOException {
        HttpServer httpServer = HttpServer.create(new InetSocketAddress(8000), 0);

        httpServer.createContext("/", httpExchange -> {
            response = "test";

            httpExchange.sendResponseHeaders(200, response.length());
            OutputStream outputStream = httpExchange.getResponseBody();
            outputStream.write(response.getBytes());
            outputStream.close();
        }
        );

        httpServer.setExecutor(null);
        httpServer.start();
    }
}