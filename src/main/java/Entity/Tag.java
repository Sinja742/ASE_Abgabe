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
        List<Tag> tagList = new ArrayList<>();
        tagList.addAll(Arrays.asList(Tag.values()));
        return tagList;
    }

    public static List<String> tagsToStringList(List<Tag> tagsList) {
        List<String> tagsListString = new ArrayList<>();
        for(Tag tag : tagsList) {
            tagsListString.add(tag.getDescription());
        }

        return tagsListString;
    }

    //    public static Tag[] tagsToArray(List<Tag> tagsList) {
//        Tag[] tags = new Tag[tagsList.size()];
//        for(int countTags = 0; countTags < tagsList.size(); countTags++) {
//            tags[countTags] = tagsList.get(countTags);
//        }
//        return tags;
//    }
//
}