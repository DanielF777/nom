package nom.googleapi.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang.builder.EqualsBuilder;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Restaurant {
    private final String name;
    private final int priceLevel;
    private final double rating;
    private final String address;

    public Restaurant(
            @JsonProperty("name") String name,
            @JsonProperty("price_level") int priceLevel,
            @JsonProperty("rating") double rating,
            @JsonProperty("vicinity") String address) {
        this.name = name;
        this.priceLevel = priceLevel;
        this.rating = rating;
        this.address = address;
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public String toString() {
        return "Name: " + name + " Price Level: " + priceLevel + " Rating: " + rating + " Address: " + address;
    }
}