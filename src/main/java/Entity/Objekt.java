package Entity;

import java.util.List;

public class Objekt extends Category {
    private List<Tag> tags;

    public Objekt(String description, List<Tag> tags) {
        super(description);
        this.tags = tags;
    }

    //TODO: Contructor TxtReader

    public List<Tag> getTags() {
        return this.tags;
    }
}
