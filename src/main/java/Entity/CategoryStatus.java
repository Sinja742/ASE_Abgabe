package Entity;

public enum CategoryStatus {

    ART("Art", "Arten"),
    STIMMUNG("Stimmung", "Stimmungen"),
    OBJEKT("Objekt", "Objekte");

    private final String status;
    private final String statusPlural;

    CategoryStatus(String status, String statusPlural) {
        this.status = status;
        this.statusPlural = statusPlural;
    }

    public String getStatus() {
        return this.status;
    }

    public String getStatusPlural() {
        return this.statusPlural;
    }

    public boolean isEqualCategory(CategoryStatus category) {
        return category.equals(this);
    }
}
