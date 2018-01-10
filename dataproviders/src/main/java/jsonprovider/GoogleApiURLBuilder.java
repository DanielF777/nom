package jsonprovider;

/**
 * Created by dev on 06/12/2017.
 */
public class GoogleApiURLBuilder {
    private String returnFormat = "";
    private String apiKey = "";
    private String location = "";
    private String radius = "";
    private String type = "";
    private String minPrice = "";
    private String maxPrice = "";

    public GoogleApiURLBuilder() {
        returnFormat = "json?";
        apiKey = "key=AIzaSyDy8zdsCIFrzd1pBq_E8-b71iNL4-3CZ38&";
    }

    public GoogleApiURLBuilder(String returnFormat, String apiKey) {
        this.returnFormat = returnFormat;
        this.apiKey = apiKey;
    }

    public GoogleApiURLBuilder setLocation(String location) {
        this.location = "location=" + location + "&";
        return this;
    }

    public GoogleApiURLBuilder setRadius(String radius) {
        this.radius = "radius=" + radius + "&";
        return this;
    }

    public GoogleApiURLBuilder setType(String type) {
        this.type = "type=" + type + "&";
        return this;
    }

    public GoogleApiURLBuilder setMinPrice(String minPrice) {
        this.minPrice = "minprice=" + minPrice + "&";
        return this;
    }

    public GoogleApiURLBuilder setMaxPrice(String maxPrice) {
        this.maxPrice = "minprice=" + maxPrice + "&";
        return this;
    }

    public GoogleApiURL build() {
        String urlString = "https://maps.googleapis.com/maps/api/place/nearbysearch/" +
                returnFormat +
                apiKey +
                location +
                radius +
                type +
                minPrice +
                maxPrice;

        return new GoogleApiURL(urlString.substring(0, urlString.length() - 1));

    }
}