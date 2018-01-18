package jsonprovider;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import nom.googleapi.domain.Results;

import java.io.IOException;

/**
 * Created by dev on 06/12/2017.
 */
public class JsonParser {

    private final ObjectMapper objectMapper;

    public JsonParser(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
        objectMapper.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, false);
    }

    public Results parseString(String jsonStringToParse) {
        Results restaurants;

        try {
            restaurants = objectMapper.readValue(jsonStringToParse, Results.class);
            return restaurants;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }
}
