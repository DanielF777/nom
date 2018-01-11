package nom.googleapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpServer;
import jsonprovider.JsonParser;
import jsonprovider.NoRestaurantsFoundException;
import nom.googleapi.domain.Restaurant;
import nom.googleapi.domain.Results;
import nom.googleapi.domain.UriBuilder;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.hamcrest.core.IsNull;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;

/**
 * Created by dev on 06/12/2017.
 */
public class RestaurantDataProviderTest {

    private RestaurantDataProvider restaurantDataProvider;
    private HttpServer httpServer;

    @Before
    public void setUp() throws Exception {
        startHttpServer();
        restaurantDataProvider = new RestaurantDataProvider(new ObjectMapper());
    }

    @Test(expected = NoRestaurantsFoundException.class)
    public void throwsExceptionWhenGoogleReturnsNoResults() throws Exception {
        startHttpServer();
        restaurantDataProvider.findAllRestaurants(new UriBuilder("http://localhost:8123/").asUri());
        stopHttpServer();
    }


    @Test
    public void testJsonFromServer() throws Exception {
        startHttpServer();

        URI uri = new UriBuilder("http://localhost:8123/").asUri();

        HttpClient httpClient = HttpClientBuilder.create().build();

        HttpResponse response = httpClient.execute(new HttpGet(uri));

        String s = IOUtils.toString(response.getEntity().getContent());

//        List<Restaurant> restaurantList = restaurantDataProvider.findAllRestaurants();

        assertThat(s, is(IsNull.nullValue()));

        JsonParser jsonParser = new JsonParser(new ObjectMapper());

        Results results = jsonParser.parseString(s);

        List<Restaurant> restaurants = Arrays.asList(results.getRestaurants());

        assertThat(restaurants.size(), is(not(0)));

        stopHttpServer();

    }

    private void startHttpServer() throws IOException {
        httpServer = HttpServer.create(new InetSocketAddress(8123), 0);

        httpServer.createContext("/", httpExchange -> {

                    httpExchange.sendResponseHeaders(200, getResponse().length());
                    OutputStream outputStream = httpExchange.getResponseBody();
                    outputStream.write(getResponse().getBytes());
                    outputStream.close();
                }
        );

        httpServer.setExecutor(null);
        httpServer.start();

    }

    private void stopHttpServer() {
        httpServer.stop(0);
    }

    private String getResponse() {
        return "{\n" +
                "    \"html_attributions\": [],\n" +
                "    \"results\": [\n" +
                "        {\n" +
                "            \"geometry\": {\n" +
                "                \"location\": {\n" +
                "                    \"lat\": 51.508228,\n" +
                "                    \"lng\": -0.07284299999999998\n" +
                "                },\n" +
                "                \"viewport\": {\n" +
                "                    \"northeast\": {\n" +
                "                        \"lat\": 51.5095769802915,\n" +
                "                        \"lng\": -0.07149401970849795\n" +
                "                    },\n" +
                "                    \"southwest\": {\n" +
                "                        \"lat\": 51.5068790197085,\n" +
                "                        \"lng\": -0.07419198029150201\n" +
                "                    }\n" +
                "                }\n" +
                "            },\n" +
                "            \"icon\": \"https://maps.gstatic.com/mapfiles/place_api/icons/restaurant-71.png\",\n" +
                "            \"id\": \"3d24eee8f76989b29c0f51d8f0e9d7db083d2d89\",\n" +
                "            \"name\": \"Cafe Rouge\",\n" +
                "            \"opening_hours\": {\n" +
                "                \"open_now\": true,\n" +
                "                \"weekday_text\": []\n" +
                "            },\n" +
                "            \"photos\": [\n" +
                "                {\n" +
                "                    \"height\": 3024,\n" +
                "                    \"html_attributions\": [\n" +
                "                        \"<a href=\\\"https://maps.google.com/maps/contrib/113986967135636485444/photos\\\">ALAN THOMSON</a>\"\n" +
                "                    ],\n" +
                "                    \"photo_reference\": \"CmRaAAAAg40qcJLYQOHxJ4SYvLoTYWon2bUYDTSfZpMkoprYv6kcLUimOTJKuXR_dhTSX3529Qjs24vl4LMkoRC2lo9_L1_M6tXvOuna-WPkoaaHU9IndtlqW1ajmZu-hQuvHf4JEhD3VBAUNMFQIiM0Uyp4Z1HdGhT_W99sjfR1hwNVwKZO3TQ87ftcqg\",\n" +
                "                    \"width\": 4032\n" +
                "                }\n" +
                "            ],\n" +
                "            \"place_id\": \"ChIJT2lBEzYDdkgRBO2q6ruhLgQ\",\n" +
                "            \"price_level\": 2,\n" +
                "            \"rating\": 3.8,\n" +
                "            \"reference\": \"CmRRAAAA_cedoTuEPI0a9SHGSlcWffDaV0k19g0bClDtZu2DxmAMfNqQcaRg9RED9Z9bfbpSltGQG5x81nlHboj2lLzAZ3KAhTnb2SUWn-MSHj3MTZMrwzA3N6EbUKESoqm-rTo9EhB-QDoDK4rc8tWdPNitCNvcGhTulCpCzEleC8WlOba_N3iZQ-3HKQ\",\n" +
                "            \"scope\": \"GOOGLE\",\n" +
                "            \"types\": [\n" +
                "                \"cafe\",\n" +
                "                \"bar\",\n" +
                "                \"restaurant\",\n" +
                "                \"food\",\n" +
                "                \"point_of_interest\",\n" +
                "                \"establishment\"\n" +
                "            ],\n" +
                "            \"vicinity\": \"Unit 4, Quayside Road, St Katharine Docks, London\"\n" +
                "        }, " +
                "        {\n" +
                "            \"geometry\": {\n" +
                "                \"location\": {\n" +
                "                    \"lat\": 51.5083947,\n" +
                "                    \"lng\": -0.0730519\n" +
                "                },\n" +
                "                \"viewport\": {\n" +
                "                    \"northeast\": {\n" +
                "                        \"lat\": 51.5097844802915,\n" +
                "                        \"lng\": -0.07208946970849797\n" +
                "                    },\n" +
                "                    \"southwest\": {\n" +
                "                        \"lat\": 51.5070865197085,\n" +
                "                        \"lng\": -0.07478743029150203\n" +
                "                    }\n" +
                "                }\n" +
                "            },\n" +
                "            \"icon\": \"https://maps.gstatic.com/mapfiles/place_api/icons/restaurant-71.png\",\n" +
                "            \"id\": \"d0f6d91e1f9967dad8841383422efaa418ceb379\",\n" +
                "            \"name\": \"Ping Pong St Katharine Docks\",\n" +
                "            \"opening_hours\": {\n" +
                "                \"open_now\": true,\n" +
                "                \"weekday_text\": []\n" +
                "            },\n" +
                "            \"photos\": [\n" +
                "                {\n" +
                "                    \"height\": 1536,\n" +
                "                    \"html_attributions\": [\n" +
                "                        \"<a href=\\\"https://maps.google.com/maps/contrib/100589886870121773166/photos\\\">Ping Pong St Katharine Docks</a>\"\n" +
                "                    ],\n" +
                "                    \"photo_reference\": \"CmRaAAAAViji7moTFgsFfTR7cuDeE3C1cGQzb2jqcD5MvyiF5u6sU6KDGLuTGicIPqkRyexJK3v-lDUq3JR2666GSQXKNeSVdBVHVWQ_-LAVb5Vp3KFMRJ_mJ231Jxm5gBuGBRmBEhBPuzT9R-KkAa5ZFuZTFGwUGhTNeYV87irYDYrBo-7YK-SoSxNQ-w\",\n" +
                "                    \"width\": 2048\n" +
                "                }\n" +
                "            ],\n" +
                "            \"place_id\": \"ChIJJ-7dCkkDdkgRcj5P1cg1UVY\",\n" +
                "            \"price_level\": 2,\n" +
                "            \"rating\": 4,\n" +
                "            \"reference\": \"CmRRAAAAFdeATZfFHxk6n2CRaY5SBlJelENakQ5cQ_73qRVN-Iu4Zr49u8WXXi98D4y6QXo3Yi6bMRX0jP2I6mNsJPNTiP1iiHrevzFXurF0p0LZi4CCChM4xaZ7D-jd8OMtdXxWEhAPng7WS4m31Qr5E94WHXn1GhRNCV39lpwCwq35q0Z8sXn3Mnn7-A\",\n" +
                "            \"scope\": \"GOOGLE\",\n" +
                "            \"types\": [\n" +
                "                \"bar\",\n" +
                "                \"restaurant\",\n" +
                "                \"food\",\n" +
                "                \"point_of_interest\",\n" +
                "                \"establishment\"\n" +
                "            ],\n" +
                "            \"vicinity\": \"3, Saint Katharine's Way, London\"\n" +
                "        }" +
                "] " +
                "}";
    }

}