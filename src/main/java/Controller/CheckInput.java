package Controller;

import Entity.CategoryStatus;
import Entity.Tag;
import Error.FalseInputException;

public class CheckInput implements CheckInputInterface {

    private final ManageElement manageElement;

    public CheckInput(ManageElement manageElement) {
        this.manageElement = manageElement;
    }

    public boolean checkCategoriesExist(String[] elements, CategoryStatus categoryStatus) {
        for (String element : elements) {
            if (!this.checkCategory(element, categoryStatus)) {
                return false;
            }
        }
        return true;
    }

    boolean checkCategory(String element, CategoryStatus categoryStatus) {
        try {
            if (this.manageElement.getCategoryToDescription(element, categoryStatus) == null) {
                throw new FalseInputException();
            } else {
                return true;
            }
        } catch (FalseInputException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean checkTagsExist(String[] tags) {
        for (String tag : tags) {
            if (!this.checkTag(tag)) {
                return false;
            }
        }
        return true;
    }

    boolean checkTag(String tag) {
        try {
            if (Tag.getTag(tag) == null) {
                throw new FalseInputException();
            } else {
                return true;
            }
        } catch (FalseInputException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean elementDoNotExists(String element, CategoryStatus categoryStatus) {
        try {
            if (this.manageElement.getCategoryToDescription(element, categoryStatus) != null) {
                throw new Exception();
            } else {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Das Element existiert bereits");
            return false;
        }
    }
}
