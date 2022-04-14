package Entity;

public class SimpleCategory extends Category implements CategoryInterface{

    public SimpleCategory(String description) {
        super(description);
    }

    public boolean containsTag(Tag[] tagFilter) {
        return false;
    }

    public String toString(){
        return this.description;
    }
}