package nom.googleapi.domain;

public enum ReturnFormat {
    JSON("json"),
    XML("xml");

    private final String value;

    ReturnFormat(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
