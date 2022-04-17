package Controller.Element;

import Controller.GUI;
import Controller.ManageElement;
import Entity.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AddElementTest {

    GUI gui = mock(GUI.class);
    ManageElement manageElement = mock(ManageElement.class);

    AddElement addElement = new AddElement(gui, manageElement);

    @Test
    void addTags_True() {
        when(addElement.wantAddTags("test")).thenReturn(true);
        when(addElement.readNewTags()).thenReturn(new Tag[]{Tag.FANTASIE});

        Tag[] returnTagArray = addElement.addTags("Test");

        assertEquals(1,returnTagArray.length);
        assertEquals(new Tag[]{Tag.FANTASIE},returnTagArray);
    }

    @Test
    void addTags_False() {
        when(addElement.wantAddTags("test")).thenReturn(false);

        Tag[] returnTagArray = addElement.addTags("Test");

        assertEquals(new Tag[0],returnTagArray);
    }

    @Test
    void wantAddTags_True(){
        when(gui.trueBooleanQuestion("Test")).thenReturn(true);

        boolean returnBoolean = addElement.wantAddTags("Test");

        assertTrue(returnBoolean);
    }

    @Test
    void wantAddTags_False(){
        when(gui.trueBooleanQuestion("Test")).thenReturn(false);

        boolean returnBoolean = addElement.wantAddTags("Test");

        assertFalse(returnBoolean);
    }
}