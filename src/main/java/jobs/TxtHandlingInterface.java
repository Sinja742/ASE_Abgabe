package jobs;

import Entity.Category;

import java.util.List;

public interface TxtHandlingInterface {
    String[] readTxt();

    void rewriteTxt(List<Category> arten, List<Category> stimmungen, List<Category> objekte);
}
