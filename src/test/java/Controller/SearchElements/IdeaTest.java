package Controller.SearchElements;

import Controller.GUI;
import Controller.ManageElement;
import Entity.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class IdeaTest {

    private final SearchElements searchElements = mock(SearchElements.class);
    private final ManageElement manageElement = mock(ManageElement.class);
    private final GUI gui = mock(GUI.class);
    private final FilterIdea filterIdea = mock(FilterIdea.class);
    private final FilterObjektIdea filterObjektIdea = mock(FilterObjektIdea.class);

    private void initMocks() {
        when(this.manageElement.getAllArten()).thenReturn(null);
        when(this.manageElement.getAllStimmungen()).thenReturn(null);
        when(this.manageElement.getAllObjekte()).thenReturn(null);

        when(this.searchElements.getSearchElements(CategoryStatus.ART, null)).thenReturn(new Category[] {new SimpleCategory("Art")});
        when(this.searchElements.getSearchElements(CategoryStatus.STIMMUNG, null)).thenReturn(new Category[] {new SimpleCategory("Stimmung")});
        when(this.searchElements.getSearchElements(CategoryStatus.OBJEKT, null)).thenReturn(new Category[] {new Objekt("Objekt", new Tag[0])});

        when(this.filterIdea.random()).thenReturn(new SimpleCategory("Art"));
        when(this.filterObjektIdea.random()).thenReturn(new Objekt("Objekt", new Tag[0]));
    }

    @Test
    void testToString() {
        //Given
        Idea idea = new Idea(this.gui, this.manageElement);

        //When
        initMocks();
        String ideaString = idea.toString();

        //Then
        assertEquals("Art Stimmung Objekt", ideaString);
    }
}