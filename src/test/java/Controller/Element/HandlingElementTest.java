package Controller.Element;

import Controller.GUI;
import Controller.ManageElement;
import Entity.Category;
import Entity.CategoryStatus;
import Entity.SimpleCategory;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class HandlingElementTest {

    GUI gui = mock(GUI.class);
    ManageElement manageElement = mock(ManageElement.class);
    HandlingElement handlingElement = new HandlingElement(gui,manageElement) {
        @Override
        protected String handleElement(CategoryStatus categoryStatus, List<Category> allElements, String action) {
            return super.handleElement(categoryStatus, allElements, action);
        }
    };

    @Test
    void handleElement() {
        List<Category> testArtenList = Collections.singletonList(new SimpleCategory("art1"));
        when(gui.getStringArrayOfElements(CategoryStatus.ART,testArtenList,"Test")).thenReturn(new String[]{"TestArt1"});

        String returnString = handlingElement.handleElement(CategoryStatus.ART,testArtenList,"Test");

        assertEquals("TestArt1",returnString);
    }
}