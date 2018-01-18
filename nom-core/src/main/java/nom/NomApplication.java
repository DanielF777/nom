package nom;

import jsonprovider.NoRestaurantsFoundException;
import nom.googleapi.RestaurantDataProvider;
import nom.googleapi.domain.Restaurant;
import nom.googleapi.domain.Results;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class NomApplication {

    private final RestaurantDataProvider restaurantDataProvider;

    public NomApplication(RestaurantDataProvider restaurantDataProvider) {
        this.restaurantDataProvider = restaurantDataProvider;
    }

    public List<Restaurant> findRestaurants(int numberOfRestaurants) {
        try {
            Results results = restaurantDataProvider.getRestaurantResults();

            List<Restaurant> restaurants = filterResultsToGive3RestaurantsAtRandom(results.getRestaurants(), numberOfRestaurants);

            for (Restaurant restaurant : restaurants) {
                System.out.println(restaurant.toString());
            }

            return restaurants;
        } catch (NoRestaurantsFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Restaurant> filterResultsToGive3RestaurantsAtRandom(Restaurant[] restaurants, int numberOfRestaurants) {
        if (restaurants.length < numberOfRestaurants) {
            return Arrays.asList(restaurants);
        }

        restaurants = randomlyShuffleRestaurantArray(restaurants);

        return Arrays.stream(restaurants).limit(numberOfRestaurants).collect(Collectors.toList());
    }

    private Restaurant[] randomlyShuffleRestaurantArray(Object[] restaurantsToShuffle) {

        Restaurant[] restaurants = (Restaurant[]) restaurantsToShuffle;

        int amountOfRestaurants = restaurants.length;
        Random randomNumberGenerator = new Random();
        int randomValue;
        Restaurant randomRestaurant;

        for (int i = 0; i < restaurants.length; i++) {
            randomValue = i + randomNumberGenerator.nextInt(amountOfRestaurants - i);
            randomRestaurant = restaurants[randomValue];
            restaurants[randomValue] = restaurants[i];
            restaurants[i] = randomRestaurant;
        }

        return restaurants;
    }
}
