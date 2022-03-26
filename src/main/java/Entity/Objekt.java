package Entity;

import java.util.List;

public class Objekt extends Category {
    private List<String> tags;

    public Objekt(String description, List<String> tags) {
        super(description);
        this.tags = tags;
    }

    //TODO: Contructor TxtReader

    public List<String> getTags() {
        return this.tags;
    }
}
