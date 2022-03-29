package Entity;

public abstract class Category {

    protected String description;
//    protected CategoryStatus status;

    public Category(String description/*, CategoryStatus status*/) {
        this.description = description;
//        this.status = status;
    }

    public String getDescription() {
        return this.description;
    }

//    public CategoryStatus getStatus() {
//        return this.status;
//    }

    public abstract boolean containsTag(Tag[] tagFilter);
}
