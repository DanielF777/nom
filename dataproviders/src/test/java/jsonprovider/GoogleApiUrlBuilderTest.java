package jsonprovider;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by dev on 06/12/2017.
 */
public class GoogleApiUrlBuilderTest {

    public static final String RESTAURANT_FIELD_URL = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?key=AIzaSyDy8zdsCIFrzd1pBq_E8-b71iNL4-3CZ38&type=restaurant&";
    GoogleApiUrlBuilder googleApiUrlBuilder = new GoogleApiUrlBuilder();

    @Test
    public void createRestaurantQueryUrl() throws Exception {
        String queryUrl = googleApiUrlBuilder.setType("restaurant").build();

        assertThat(queryUrl).isEqualTo(RESTAURANT_FIELD_URL);
    }
}