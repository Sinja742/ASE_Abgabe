package Entity;

import java.util.ArrayList;
import java.util.List;

public class Objekt extends Category {
    private List<Tag> tags;

    public Objekt(String description/*, CategoryStatus status*/, List<Tag> tags) {
        super(description/*, status*/);
        this.tags = tags;
    }

//    public Objekt(String description/*, CategoryStatus status*/) {
//        super(description/*, status*/);
//        this.tags = new ArrayList<>();
//    }

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
