import Entity.tags;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GUI {
    final String JA = "j";
    final String NEIN = "n";

    public String[] getSearchTags() throws IOException {
        if(this.wantSearch("Tags")) {
            return this.getTags();
        } else {
            return new String[0];
        }
    }

    private boolean wantSearch(String kriterium) throws IOException {
        BufferedReader tastatur = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Wollen Sie nach " + kriterium + " suchen? (" + this.JA + "/" + this.NEIN + "): ");
        return tastatur.readLine().equals(this.JA);
    }

    private String[] getTags() throws IOException{
        this.showOpportunities("Tags");
        System.out.println("Geben Sie die gewünschten Tags ein: ");

        BufferedReader tastatur = new BufferedReader(new InputStreamReader(System.in));
        return tastatur.readLine().split(" ");
    }

    private void showOpportunities(String kriterium) {
        System.out.println("Diese " + kriterium + " können gesetzt werden:");
        for(tags tag : tags.values()) {
            System.out.print(tag + " ");
        }
        System.out.println();
    }
}
