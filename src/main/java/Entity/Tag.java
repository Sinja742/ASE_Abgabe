package Entity;

public enum Tag {
    LANDSCHAFT(1, "Landschaft"),
    GEGENSTAND(2, "Gegenstand"),
    FANTASIE(3, "Fantasie"),
    TIER(4, "Tier"),
    ABSTRAKT(5, "Abstrakt"),
    MODERN(6, "Modern");

    private final int id;
    private final String description;

    Tag(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public int getId() {
        return this.id;
    }
}