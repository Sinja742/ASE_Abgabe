package Entity;

public enum EntityStatus {

    ART("art"),
    STIMMUNG("stimmung"),
    OBJEKT("objekt");

    private String bezeichnung;

    EntityStatus(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public String toString() {
        return this.bezeichnung;
    }
}
