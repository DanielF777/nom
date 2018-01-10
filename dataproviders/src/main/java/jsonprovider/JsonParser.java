package jsonprovider;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dev on 06/12/2017.
 */
public class JsonParser {

    private final ObjectMapper objectMapper;

    public JsonParser(ObjectMapper objectMapper) {

        this.objectMapper = objectMapper;
    }

    public List<Restaurant> parseString(String s) {

        ArrayList<Restaurant> restaurants = new ArrayList<>();

        Restaurant restaurant = new Restaurant("Cafe Rouge", 2, 3.8, "Unit 4, Quayside Road, St Katharine Docks, London");



        restaurants.add(restaurant);

        return restaurants;
    }
}
