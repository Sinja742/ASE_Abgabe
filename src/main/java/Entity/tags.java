package Entity;

public enum Tags {
    LANDSCHAFT("Landschaft"),
    GEGENSTAND("Gegenstand"),
    FANTASY("Fantasy"),
    TIER("Tier");

    private String name;

    Tags(String name) {
        this.name = name;
    }
    public String toString() {
        return this.name;
    }

}
