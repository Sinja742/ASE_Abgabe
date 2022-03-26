package Entity;

public enum CategoryStatus {

    ART("Art"),
    STIMMUNG("Stimmung"),
    OBJEKT("Objekt");

    private final String status;

    CategoryStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }
}
