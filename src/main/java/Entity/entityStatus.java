package Entity;

public enum entityStatus {

    ART("art"),
    STIMMUNG("stimmung"),
    OBJEKT("objekt");

    private String bezeichnung;

    entityStatus(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public String toString() {
        return this.bezeichnung;
    }
}
