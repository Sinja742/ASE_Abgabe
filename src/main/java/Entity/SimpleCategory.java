package Entity;

public class SimpleCategory extends Category{

    public SimpleCategory(String description/*, CategoryStatus status*/) {
        super(description/*, status*/);
    }

    @Override
    public boolean containsTag(Tag[] tagFilter) {
        return false;
    }
}