import jobs.YmlReader;
import Entity.Entity;
import Entity.entityStatus;

import java.util.List;

public class Steuerung {

    public static void main(String[] args) {

    }

    private List<Entity> artList;
    private List<Entity> stimmungList;
    private List<Entity> objektList;

    private void readEntitys() {
        this.artList = YmlReader.readEntity(entityStatus.ART);
        this.stimmungList = YmlReader.readEntity(entityStatus.STIMMUNG);
        this.objektList = YmlReader.readEntity(entityStatus.OBJEKT);
    }
}
