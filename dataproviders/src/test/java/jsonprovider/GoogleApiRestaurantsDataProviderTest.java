package jsonprovider;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Created by dev on 06/12/2017.
 */
public class GoogleApiRestaurantsDataProviderTest {

    private final GoogleApiRestaurantsDataProvider googleApiRestaurantsDataProvider = new GoogleApiRestaurantsDataProvider();

    @Test
    public void throwsExceptionWhenGoogleReturnsNoResults() throws Exception {
        assertThatThrownBy(googleApiRestaurantsDataProvider::findRestaurants)
                .isInstanceOf(NoRestaurantsFoundException.class)
                .hasMessage("No restaurants found.");

    }

    @Test
    public void name() throws Exception {

    }
}