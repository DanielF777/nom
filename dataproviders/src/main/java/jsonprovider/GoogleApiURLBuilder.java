package jsonprovider;

/**
 * Created by dev on 06/12/2017.
 */
public class GoogleApiUrlBuilder {
    private String returnFormat;
    private String apiKey;
    private String location;
    private String radius;
    private String type;
    private String minPrice;
    private String maxPrice;

    public GoogleApiUrlBuilder setReturnFormat(String returnFormat) {
        this.returnFormat = returnFormat;
        return this;
    }

    public GoogleApiUrlBuilder setApiKey(String apiKey) {
        this.apiKey = apiKey;
        return this;
    }

    public GoogleApiUrlBuilder setLocation(String location) {
        this.location = location + "&";
        return this;
    }

    public GoogleApiUrlBuilder setRadius(String radius) {
        this.radius = radius + "&";
        return this;
    }

    public GoogleApiUrlBuilder setType(String type) {
        this.type = type + "&";
        return this;
    }

    public GoogleApiUrlBuilder setMinPrice(String minPrice) {
        this.minPrice = minPrice + "&";
        return this;
    }

    public GoogleApiUrlBuilder setMaxPrice(String maxPrice) {
        this.maxPrice = maxPrice;
        return this;
    }

    public String build() {
        if (returnFormat == null && apiKey == null) {
            throw new NullPointerException("Incorrect Amount of parameters set");
        }
        return "https://maps.googleapis.com/maps/api/place/nearbysearch/" +
                returnFormat + "?" +
                apiKey + "&" +
                location +
                radius +
                type +
                minPrice +
                maxPrice;

    }
}