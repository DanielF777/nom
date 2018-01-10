package nom.googleapi.domain;

import nom.googleapi.domain.MapLocation;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MapLocationTest {

    @Test
    public void rendersAsString() throws Exception {
        MapLocation mapLocation = new MapLocation(30.506, -0.88375);
        assertThat(mapLocation.asString(), is("30.506,-0.88375"));
    }

}