package Entity;

public abstract class Category implements CategoryInterface{

    protected String description;

    public Category(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public abstract boolean containsTag(Tag[] tagFilter);
}
