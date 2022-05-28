package Entity;

public abstract class Category implements CategoryInterface {

    protected String description;

    public Category(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public boolean equalsDescription(String description) {
        return this.description.equals(description);
    }

    public abstract boolean containsTag(Tag[] tagFilter);

    @Override
    public abstract String toString();
}
