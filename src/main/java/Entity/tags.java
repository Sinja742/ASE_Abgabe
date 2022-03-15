package Entity;

public enum Tags {
    LANDSCHAFT(01, "Landschaft"),
    GEGENSTAND(02, "Gegenstand"),
    FANTASIE(03, "Fantasie"),
    TIER(04, "Tier"),
    ABSTRAKT(05, "Abstrakt"),
    MODERN(06, "Modern");

    private int id;
    private String tag;

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