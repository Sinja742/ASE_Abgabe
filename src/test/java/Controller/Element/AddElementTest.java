package Controller.Element;

import Controller.GUI;
import Controller.ManageElement;
import Entity.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AddElementTest {

    GUI guiMock = mock(GUI.class);
    ManageElement manageElementMock = mock(ManageElement.class);

    AddElement addElement = new AddElement(guiMock, manageElementMock);

    @Test
    void addTags_True() {
        when(this.guiMock.trueBooleanQuestion("Wollen Sie Tags zum Objekt Test hinzufügen? ")).thenReturn(true);
        when(this.guiMock.getTags()).thenReturn(new Tag[]{Tag.FANTASIE});

        Tag[] returnTagArray = addElement.addTags("Test");

        assertEquals(1,returnTagArray.length);
        assertEquals("Fantasie",returnTagArray[0].getDescription());
    }

    @Test
    void addTags_False() {
        when(this.guiMock.trueBooleanQuestion("Wollen Sie Tags zum Objekt Test hinzufügen? ")).thenReturn(false);

        Tag[] returnTagArray = addElement.addTags("Test");

        assertEquals(0,returnTagArray.length);
    }

    @Test
    void wantAddTags_True(){
        String objektDescription = "Test";
        when(this.guiMock.trueBooleanQuestion("Wollen Sie Tags zum Objekt " + objektDescription + " hinzufügen? ")).thenReturn(true);

        boolean returnBoolean = addElement.wantAddTags(objektDescription);

        assertTrue(returnBoolean);
    }

    @Test
    void wantAddTags_False(){
        String objektDescription = "Test";
        when(this.guiMock.trueBooleanQuestion("Wollen Sie Tags zum Objekt " + objektDescription + " hinzufügen? ")).thenReturn(false);

        boolean returnBoolean = addElement.wantAddTags(objektDescription);

        assertFalse(returnBoolean);
    }
}