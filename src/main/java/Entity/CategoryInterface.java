package Entity;

public interface CategoryInterface {
    String getDescription();

    boolean containsTag(Tag[] tagFilter);

    String toString();
}
