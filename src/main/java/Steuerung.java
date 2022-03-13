import jobs.TxtReader;
import Entity.Entity;
import Entity.EntityStatus;

import java.util.List;

public class Steuerung {
    private List<Entity> artList;
    private List<Entity> stimmungList;
    private List<Entity> objektList;

    private void readEntitys() {
        this.artList = TxtReader.readEntity(EntityStatus.ART);
        this.stimmungList = TxtReader.readEntity(EntityStatus.STIMMUNG);
        this.objektList = TxtReader.readEntity(EntityStatus.OBJEKT);
    }
}
