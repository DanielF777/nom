package nom;

import nom.googleapi.RestaurantDataProvider;
import nom.googleapi.domain.Restaurant;
import nom.googleapi.domain.Results;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class NomApplicationTest {

    @Mock
    private RestaurantDataProvider restaurantDataProvider;

    @Test
    public void find3RestaurantsAtRandom() throws Exception {
        restaurantDataProvider = Mockito.mock(RestaurantDataProvider.class);
        NomApplication nomApplication = new NomApplication(restaurantDataProvider);

        Restaurant[] restaurants = new Restaurant[5];

        restaurants[0] = new Restaurant("Pete", 2, 3, "");
        restaurants[1] = new Restaurant("Dan", 2, 4, "");
        restaurants[2] = new Restaurant("Tim", 2, 3, "");
        restaurants[3] = new Restaurant("Imke", 2, 5, "");
        restaurants[4] = new Restaurant("Paul", 2, 4, "");

        when(restaurantDataProvider.getRestaurantResults()).thenReturn(new Results(restaurants));

        List<Restaurant> randomRestaurants = nomApplication.find3Restaurants();

        assertThat(randomRestaurants.size(), is(3));
    }
}