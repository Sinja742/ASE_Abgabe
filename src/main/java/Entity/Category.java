package Entity;

import java.util.Objects;

public class Category {
    private String description;

    public Category(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public boolean containsTag(Tag[] tagFilter) {
        return false;
    }
}