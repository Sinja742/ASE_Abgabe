package Entity;

public enum Tags {
    LANDSCHAFT(1, "Landschaft"),
    GEGENSTAND(2, "Gegenstand"),
    FANTASIE(3, "Fantasie"),
    TIER(4, "Tier"),
    ABSTRAKT(5, "Abstrakt"),
    MODERN(6, "Modern");

    private final int id;
    private final String tag;

    Tags(int id, String tag) {
        this.id = id;
        this.tag = tag;
    }

    public String toString() {
        return this.tag;
    }

    public int getId() {
        return this.id;
    }
}