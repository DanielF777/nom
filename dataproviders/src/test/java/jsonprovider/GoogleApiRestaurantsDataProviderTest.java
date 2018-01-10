package jsonprovider;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Created by dev on 06/12/2017.
 */
public class GoogleApiRestaurantsDataProviderTest {

    private final GoogleApiRestaurantsDataProvider googleApiRestaurantsDataProvider = new GoogleApiRestaurantsDataProvider();

    @Test(expected = NoRestaurantsFoundException.class)
    public void throwsExceptionWhenGoogleReturnsNoResults() throws Exception {

        googleApiRestaurantsDataProvider.findRestaurants();

//        assertThatThrownBy(googleApiRestaurantsDataProvider::findRestaurants)
//                .isInstanceOf(NoRestaurantsFoundException.class)
//                .hasMessage("No restaurants found.");

    }

    @Test
    public void name() throws Exception {

    }
}