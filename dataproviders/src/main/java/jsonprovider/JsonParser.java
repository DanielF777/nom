package jsonprovider;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dev on 06/12/2017.
 */
public class JsonParser {

    private final ObjectMapper objectMapper;

    public JsonParser(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public List<Restaurant> parseString(String s) {
        ArrayList<Restaurant> restaurants = new ArrayList<>();

        try {
            restaurants = objectMapper.readValue(s, new TypeReference<List<Restaurant>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }

        return restaurants;
    }
}
