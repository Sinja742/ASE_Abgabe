package Entity;

public class SimpleCategory extends Category{

    public SimpleCategory(String description) {
        super(description);
    }

    @Override
    public boolean containsTag(Tag[] tagFilter) {
        return false;
    }
}