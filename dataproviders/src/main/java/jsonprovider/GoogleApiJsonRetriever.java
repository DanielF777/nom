package jsonprovider;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

import java.io.IOException;

/**
 * Created by dev on 06/12/2017.
 */
public class GoogleApiJsonRetriever {

    private CloseableHttpClient closeableHttpClient;

    public String requestRestaurantsJson() throws IOException {
        closeableHttpClient = HttpClients.createDefault();

        return closeableHttpClient.execute(new HttpGet("https://maps.googleapis.com/maps/api/place/nearbysearch/json?key=AIzaSyDy8zdsCIFrzd1pBq_E8-b71iNL4-3CZ38&" +
                "location=51.5076656,-0.0700636&" +
                "radius=500&" +
                "type=restaurant&" +
                "minprice=0&" +
                "maxprice=3"))
                .getEntity()
                .getContent()
                .toString();
    }
}
