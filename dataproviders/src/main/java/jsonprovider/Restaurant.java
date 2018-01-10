package jsonprovider;

import org.apache.commons.lang.builder.EqualsBuilder;

public class Restaurant {
    private final String name;
    private final int priceLevel;
    private final double rating;
    private final String address;

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
