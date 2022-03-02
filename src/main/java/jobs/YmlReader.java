package jobs;

import Entity.Entity;
import Entity.Objekt;
import Entity.entityStatus;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class YmlReader {
    public static Map<String, ArrayList<String>> readYml(){
        Yaml yaml = new Yaml();
        try{
            FileInputStream fis = new FileInputStream("Elemente.yml");
            return yaml.load(fis);
        }catch (Exception e){
            e.getMessage();
            return null;
        }
    }

    public static List<Entity> readEntity(entityStatus entityStatus) {
        if(isObjekt(entityStatus)) {
            return getObjekt(entityStatus);
        } else {
            return getEntity(entityStatus);
        }
        //return (isObjekt(entityStatus) ? getObjekt() : getEntity(entityStatus));
    }

    private static boolean isObjekt(entityStatus entityStatus) {
        return entityStatus.equals(entityStatus.OBJEKT);
    }

    private static List<Entity> getEntity(entityStatus entityStatus) {
        List<Entity> entityList = new ArrayList<>();
        Map<String, ArrayList<String>> list = readYml();

        for (int entitaetsZaehler = 0; entitaetsZaehler <list.get(entityStatus.toString()).size();entitaetsZaehler++){
            entityList.add(new Entity(list.get(entityStatus.toString()).get(entitaetsZaehler)));
        }
        return entityList;
    }

    public static List<Entity> getObjekt(entityStatus entityStatus){
        List<Entity> objektList = new ArrayList<>();
        Map<String, ArrayList<String>> list = readYml();
        ArrayList objektObj = list.get(entityStatus.toString());

        for (java.lang.Object o : objektObj) {
            LinkedHashMap objekt = (LinkedHashMap) o;
            objektList.add(new Objekt(objekt.get("name").toString(), (ArrayList<String>) objekt.get("tag")));
        }
        return objektList;
    }
}
