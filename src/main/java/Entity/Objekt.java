package Entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Objekt extends Category {
    private List<Tag> tags;

    public Objekt(String description, List<Tag> tags) {
        super(description);
        this.tags = tags;
    }

    public Objekt(String description, Tag[] tags) {
        super(description);
        this.tags = new ArrayList<>();
        this.tags.addAll(Arrays.asList(tags));
    }

    //TODO: Contructor TxtReader

    public List<Tag> getTags() {
        return this.tags;
    }

    @Override
    public boolean containsTag(Tag[] filterTags) {
        if (!tags.isEmpty()) {
            for (Tag filterTag : filterTags) {
                for (Tag tag : this.tags) {
                    if (tag.equals(filterTag)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        List<String> objektList = new ArrayList<>();
        objektList.add(this.description);
        for (int i = 0; i < this.tags.size(); i++) {
            objektList.add(String.valueOf(this.tags.get(i).getId()));
        }
        return String.join(";", objektList);
    }
}
