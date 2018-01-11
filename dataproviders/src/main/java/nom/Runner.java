package nom;

import com.fasterxml.jackson.databind.ObjectMapper;
import jsonprovider.JsonParser;
import nom.googleapi.RestaurantDataProvider;
import nom.googleapi.domain.MapLocation;
import nom.googleapi.domain.PlaceType;
import nom.googleapi.domain.UriBuilder;

public class Runner {

    public static void main(String[] args) {

        UriBuilder uriBuilder = new UriBuilder();
        uriBuilder = uriBuilder.setPriceRange(0, 3)
                .withType(PlaceType.FOOD)
                .withLocation(new MapLocation(51.5076656, -0.0700636))
                .withRadius(750);

        RestaurantDataProvider restaurantDataProvider = new RestaurantDataProvider(uriBuilder.asUri(), new JsonParser(new ObjectMapper()));

        NomApplication nomApplication = new NomApplication(restaurantDataProvider);

        nomApplication.findRestaurants(5);

    }

}
