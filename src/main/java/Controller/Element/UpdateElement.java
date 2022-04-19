package Controller.Element;

import Controller.GUI;
import Controller.ManageElement;
import Entity.Category;
import Entity.CategoryStatus;

import java.util.List;

public class UpdateElement extends HandlingElement {

    public UpdateElement(ManageElement manageElement) {
        super(manageElement);
    }

    public void updateElement(CategoryStatus categoryStatus, List<Category> allElements) {
        String question = "Wollen Sie ein Element des Typs " + categoryStatus.getStatus() + " bearbeiten?";
        if (gui.trueBooleanQuestion(question)) {
            updateElementOfTypeCategory(categoryStatus, allElements);
        }
    }

    //    Verhaltensmuster Update = delete + new
    public void updateElementOfTypeCategory(CategoryStatus categoryStatus, List<Category> allElements) {
        String element = handleElement(categoryStatus, allElements, "bearbeiten");
        if (!this.checkInput.checkCategoriesExist(new String[]{element}, categoryStatus)) {
            updateElementOfTypeCategory(categoryStatus, allElements);
        } else {
            updateAfterCheckExist(categoryStatus,allElements,element);
        }
    }

    private void updateAfterCheckExist(CategoryStatus categoryStatus, List<Category> allElements, String element){
        String newElement = gui.getNewElement(categoryStatus);
        if (!this.checkInput.elementDoNotExists(newElement,categoryStatus)){
            updateElementOfTypeCategory(categoryStatus,allElements);
        }else{
           finalUpdate(categoryStatus,newElement,element);
        }
    }

    private void finalUpdate(CategoryStatus categoryStatus,String newElement,String element){
        manageElement.deleteElement(element, categoryStatus);
        new AddElement(manageElement).saveNewElement(newElement, categoryStatus);
    }
}
