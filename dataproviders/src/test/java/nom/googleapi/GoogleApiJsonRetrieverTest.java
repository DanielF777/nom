package nom.googleapi;

import nom.googleapi.GoogleApiJsonRetriever;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class GoogleApiJsonRetrieverTest {

    @Test
    public void retrievesRestaurantData() throws Exception {
        GoogleApiJsonRetriever googleApiJsonRetriever = new GoogleApiJsonRetriever();

        String returnData = googleApiJsonRetriever.requestRestaurantsJson();
        assertNotNull(returnData);
    }

}