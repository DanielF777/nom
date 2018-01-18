package nom.googleapi.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Results {

    private Restaurant[] restaurants;

    public Results(@JsonProperty("results") Restaurant[] restaurants) {
        this.restaurants = restaurants;
    }

    public Restaurant[] getRestaurants() {
        return restaurants;
    }
}
