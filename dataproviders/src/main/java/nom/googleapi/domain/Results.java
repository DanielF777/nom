package nom.googleapi.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Results {

    @JsonProperty("results")
    private Restaurant[] restaurants;


    public Restaurant[] getRestaurants() {
        return restaurants;
    }
}
