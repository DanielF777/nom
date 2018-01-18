package jsonprovider;

/**
 * Created by dev on 06/12/2017.
 */
public class NoRestaurantsFoundException extends Exception {
    public NoRestaurantsFoundException(String message) {
        super(message);
    }
}
