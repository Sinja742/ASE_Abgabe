package Entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Tag {
    LANDSCHAFT(1, "Landschaft"),
    GEGENSTAND(2, "Gegenstand"),
    FANTASIE(3, "Fantasie"),
    TIER(4, "Tier"),
    ABSTRAKT(5, "Abstrakt"),
    MODERN(6, "Modern"),
    GEBAEUDE(7, "Gebäude"),
    STADT(8, "Stadt"),
    TECHNIK(9, "Technik"),
    HYPERREALISMUS(10, "Hyperrealismus"),
    REALISMUS(11, "Realismus"),
    SURREALISMUS(12, "Surrealismus"),
    ABSTRAHIERT(13, "Abstrahiert"),
    FIGURATIV(14, "Figurativ"),
    ILLUSTRATION(15, "Illustration"),
    NAIV(16, "Naiv"),
    KLASSIK(17, "Klassik"),
    SYMBOLISMUS(18, "Symbolismus"),
    EXPRESSIONISMUS(19, "Expressionismus"),
    POINTILISMUS(20, "Pointilismus"),
    IMPRESSIONISMUS(21, "Impressionismus"),
    SCI_FI(22, "Sci-Fi"),
    HISTORIE(23, "Historie"),
    MANGA(24, "Manga"),
    COMIC(25, "Comic");

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

    public static Tag getTag(int id) {
        for(Tag tag : Tag.values()) {
            if(tag.getId() == id) {
                return tag;
            }
        }
        return null;
    }

    public static Tag getTag(String description) {
        for(Tag tag : Tag.values()) {
            if(tag.getDescription().equals(description)) {
                return tag;
            }
        }
        return null;
    }
    public static List<Tag> getAllTags() {
        return new ArrayList<>(Arrays.asList(Tag.values()));
    }

    public static List<String> tagsToStringList(List<Tag> tagsList) {
        List<String> tagsListString = new ArrayList<>();
        for(Tag tag : tagsList) {
            tagsListString.add(tag.getDescription());
        }

        return tagsListString;
    }

}