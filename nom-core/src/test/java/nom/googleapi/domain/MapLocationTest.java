package nom.googleapi.domain;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MapLocationTest {

    @Test
    public void rendersAsString() throws Exception {
        MapLocation mapLocation = new MapLocation(30.506, -0.88375);
        assertThat(mapLocation.asString(), is("30.506,-0.88375"));
    }

}