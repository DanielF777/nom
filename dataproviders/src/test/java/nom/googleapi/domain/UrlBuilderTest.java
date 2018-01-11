package nom.googleapi.domain;

import org.junit.Test;

import java.net.URI;

import static nom.matchers.UriParameterMatcher.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class UrlBuilderTest {

    private UriBuilder googleApiUrlBuilder = new UriBuilder();

    @Test
    public void validBaseUri() {
        URI uri = googleApiUrlBuilder.asUri();

        assertThat(uri.getHost(), is("maps.googleapis.com"));
        assertThat(uri.getScheme(), is("https"));
        assertThat(uri.getPath(), is("/maps/api/place/nearbysearch/json"));
        assertThat(uri, hasApiKeyParameterOf("AIzaSyBChwbZUapUol5hwM0KS0NXuesRjpv58_A"));
    }

    @Test
    public void validUriWithType() {
        URI uri = googleApiUrlBuilder.withType(PlaceType.RESTAURANT).asUri();

        assertThat(uri, hasTypeParameterOf("restaurant"));
    }

    @Test
    public void validUriWithRadius() {
        URI uri = googleApiUrlBuilder.withRadius(500).asUri();

        assertThat(uri, hasQueryParameter("radius", "500"));
    }

    @Test
    public void validUriWithLocation() {
        MapLocation location = new MapLocation(51.5076656, -0.0700636);
        URI uri = googleApiUrlBuilder.withLocation(location).asUri();

        assertThat(uri, hasQueryParameter("location", location.asString()));
    }

    @Test
    public void validUriWithPriceRange() {
        URI uri = googleApiUrlBuilder.setPriceRange(22, 44).asUri();

        assertThat(uri, hasQueryParameter("minPrice", "22"));
        assertThat(uri, hasQueryParameter("maxPrice", "44"));
    }


}