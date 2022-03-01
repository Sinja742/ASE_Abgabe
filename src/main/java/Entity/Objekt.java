package Entity;

import java.util.List;

public class Objekt {
    public String name;
    public List<String> tags;

    public Objekt(String name, List<String> tags) {
        this.name = name;
        this.tags = tags;
    }
}
