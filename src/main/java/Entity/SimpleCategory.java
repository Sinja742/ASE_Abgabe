package Entity;

public class SimpleCategory extends Category{

    public SimpleCategory(String description) {
        super(description);
    }

    @Override
    public boolean containsTag(Tag[] tagFilter) {
        return false;
    }

    @Override
    public String toString(){
        return this.description;
    }
}