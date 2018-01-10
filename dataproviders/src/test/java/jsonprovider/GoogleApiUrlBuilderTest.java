package jsonprovider;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

/**
 * Created by dev on 06/12/2017.
 */
public class GoogleApiUrlBuilderTest {

    private GoogleApiURLBuilder googleApiUrlBuilder = new GoogleApiURLBuilder();

    @Test
    public void createRestaurantQueryUrl() throws Exception {
        GoogleApiURL url = googleApiUrlBuilder.setType("restaurant").build();

        GoogleApiURL expectedUrl = new GoogleApiURL("https://maps.googleapis.com/maps/api/place/nearbysearch/json?key=AIzaSyDy8zdsCIFrzd1pBq_E8-b71iNL4-3CZ38&type=restaurant");

        assertEquals(url, expectedUrl);

    }
}