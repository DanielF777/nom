package nom.googleapi.domain;

import com.google.common.base.Joiner;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import static nom.googleapi.domain.ReturnFormat.JSON;

public class UriBuilder {

    private final Map<String, String> queryParams = new HashMap<>();
    private ReturnFormat returnFormat;
    private String apiKey;
    private final String host;

    public UriBuilder() {
        returnFormat = JSON;
        apiKey = "AIzaSyBChwbZUapUol5hwM0KS0NXuesRjpv58_A";
        host = "https://maps.googleapis.com";
    }

    public UriBuilder(String host) {
        this.host = host;
        apiKey = "AIzaSyBChwbZUapUol5hwM0KS0NXuesRjpv58_A";
        returnFormat = JSON;
    }

    public UriBuilder withLocation(MapLocation location) {
        this.queryParams.put("location", location.asString());
        return this;
    }

    public UriBuilder withRadius(int radius) {
        this.queryParams.put("radius", String.valueOf(radius));
        return this;
    }

    public UriBuilder withType(PlaceType type) {
        queryParams.put("type", type.value());
        return this;
    }

    public UriBuilder setPriceRange(int minPrice, int maxPrice) {
        queryParams.put("minPrice", String.valueOf(minPrice));
        queryParams.put("maxPrice", String.valueOf(maxPrice));
        return this;
    }

    public URI asUri() {
        queryParams.put("key", apiKey);
        return URI.create(String.format("%s/maps/api/place/nearbysearch/%s?%s",
                host,
                returnFormat.value(),
                Joiner.on("&").withKeyValueSeparator("=").join(queryParams)
        ));
    }
}