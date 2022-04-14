package Controller;

import Entity.CategoryStatus;

public interface CheckInputInterface {

    void checkCategories(String[] elements, CategoryStatus categoryStatus);

    void checkTags(String[] tags);

    public void elementDoNotExists(String element, CategoryStatus categoryStatus);

}
