package Entity;

import java.util.List;

public class Objekt extends Entity{
    private List<String> tags;

    public Objekt(String bezeichnung, List<String> tags) {
        super(bezeichnung);
        this.tags = tags;
    }

    public List<String> getTags() {
        return this.tags;
    }
}
