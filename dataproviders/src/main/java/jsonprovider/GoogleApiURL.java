package jsonprovider;

import org.apache.commons.lang.builder.EqualsBuilder;

public class GoogleApiURL {

    private String url;

    public GoogleApiURL(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }

    @Override
    public String toString() {
        return "Url: " + url;
    }

}
