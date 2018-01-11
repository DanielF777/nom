package nom;

import jsonprovider.NoRestaurantsFoundException;
import nom.googleapi.RestaurantDataProvider;
import nom.googleapi.domain.Restaurant;
import nom.googleapi.domain.Results;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class NomApplication {

    private final RestaurantDataProvider restaurantDataProvider;

    public NomApplication(RestaurantDataProvider restaurantDataProvider) {
        this.restaurantDataProvider = restaurantDataProvider;
    }

    public List<Restaurant> find3Restaurants() {

        Results results = null;

        try {
            results = restaurantDataProvider.getRestaurantResults();
        } catch (NoRestaurantsFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Restaurant> restaurants;

        restaurants = filterResultsToGive3RestaurantsAtRandom(results.getRestaurants());

        for (Restaurant restaurant : restaurants) {
            System.out.println(restaurant.toString());
        }

        return restaurants;

    }

    private List<Restaurant> filterResultsToGive3RestaurantsAtRandom(Restaurant[] restaurants) {

        List<Restaurant> threeRestaurantsAtRandom = new ArrayList<>();

        if (restaurants.length == 2) {
            return Arrays.asList(restaurants);
        }

        restaurants = randomlyShuffleRestaurantArray(restaurants);

        threeRestaurantsAtRandom.add(restaurants[0]);
        threeRestaurantsAtRandom.add(restaurants[1]);
        threeRestaurantsAtRandom.add(restaurants[2]);

        return threeRestaurantsAtRandom;

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
