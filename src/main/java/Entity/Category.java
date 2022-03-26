package Entity;

public class Category {
    private String description;

    public Category(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public String toString() {
        return this.description;
    }

}