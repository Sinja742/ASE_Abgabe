package Entity;

public interface CategoryInterface {
    String getDescription();

    boolean containsTag(Tag[] tagFilter);

    boolean equalsDescription(String description);

    String toString();
}
