package Entity;

public enum EntityStatus {

    ART("art"),
    STIMMUNG("stimmung"),
    OBJEKT("objekt");

    private String status;

    EntityStatus(String status) {
        this.status = status;
    }

    public String toString() {
        return this.status;
    }
}
