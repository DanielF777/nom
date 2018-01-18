package nom.googleapi.domain;

public enum PlaceType {
    RESTAURANT("restaurant"),
    BAR("bar"),
    CAFE("cafe"),
    FOOD("food");

    private final String parameterValue;

    PlaceType(String type) {
        this.parameterValue = type;
    }

    public String value() {
        return parameterValue;
    }

}
