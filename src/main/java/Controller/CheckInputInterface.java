package Controller;

import Entity.CategoryStatus;

public interface CheckInputInterface {

    boolean checkCategoriesExist(String[] elements, CategoryStatus categoryStatus);

    boolean checkTagsExist(String[] tags);

    boolean elementDoNotExists(String element, CategoryStatus categoryStatus);

}
