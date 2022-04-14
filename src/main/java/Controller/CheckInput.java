package Controller;

import Entity.CategoryStatus;
import Entity.Tag;

public class CheckInput implements CheckInputInterface {

    private final ManageElement manageElement;

    public CheckInput(ManageElement manageElement) {
        this.manageElement = manageElement;
    }

    public void checkCategories(String[] elements, CategoryStatus categoryStatus) {
        for (String element : elements) {
            this.checkCategory(element, categoryStatus);
        }
    }

    private void checkCategory(String element, CategoryStatus categoryStatus) {
        this.manageElement.getCategoryToDescription(element, categoryStatus);
        //TODO: nicht null!!!
    }

    public void checkTags(String[] tags) {
        for(String tag : tags) {
            this.checkTag(tag);
        }
    }

    private void checkTag(String tag) {
        Tag.getTag(tag);
        //TODO: nicht null!!!
    }

    public void elementDoNotExists(String element, CategoryStatus categoryStatus) {
        this.manageElement.getCategoryToDescription(element, categoryStatus);
        //TODO: muss null sein!!!
    }
}
