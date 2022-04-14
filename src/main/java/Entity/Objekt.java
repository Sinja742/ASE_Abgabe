package Entity;

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
        this.tags.addAll(Arrays.asList(tags));
    }

    //TODO: Contructor TxtReader

    public List<Tag> getTags() {
        return this.tags;
    }

    @Override
    public boolean containsTag(Tag[] filterTags) {
        if(!tags.isEmpty()) {
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
}
