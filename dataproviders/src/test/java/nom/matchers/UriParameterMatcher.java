package nom.matchers;

import com.google.common.base.Splitter;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import java.net.URI;
import java.util.Map;

public class UriParameterMatcher extends TypeSafeMatcher<URI> implements Matcher<URI> {

    public static Matcher<URI> hasQueryParameter(String param, String expectedValue) {
        return new UriParameterMatcher(expectedValue, param);
    }

    public static Matcher<URI> hasApiKeyParameterOf(String expectedValue) {
        return hasQueryParameter("key", expectedValue);
    }

    public static Matcher<URI> hasTypeParameterOf(String expectedValue) {
        return hasQueryParameter("type", expectedValue);
    }


    private final String expectedValue;
    private final String param;

    public UriParameterMatcher(String expectedValue, String param) {
        this.expectedValue = expectedValue;
        this.param = param;
    }

    @Override
    protected boolean matchesSafely(URI item) {
        return getParam(item).equals(expectedValue);
    }

    @Override
    public void describeTo(Description description) {
        description.appendText(param + " to be " + expectedValue);
    }

    @Override
    protected void describeMismatchSafely(URI item, Description mismatchDescription) {
        mismatchDescription.appendText(param + " was " + getParam(item));
    }

    private String getParam(URI item) {
        Map<String, String> queryItems = Splitter.on("&").withKeyValueSeparator("=").split(item.getQuery());
        return queryItems.getOrDefault(param, "not set");
    }
}
