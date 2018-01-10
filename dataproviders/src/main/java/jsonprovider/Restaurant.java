package jsonprovider;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang.builder.EqualsBuilder;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Restaurant {
    @JsonProperty("name")
    private String name;

    @JsonProperty("price_level")
    private int priceLevel;

    @JsonProperty("rating")
    private double rating;

    @JsonProperty("vicinity")
    private String address;

    public Restaurant() {
    }

    public Restaurant(String name, int priceLevel, double rating, String address) {
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