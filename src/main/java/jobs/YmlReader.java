package jobs;

import Entity.Art;
import Entity.Objekt;
import Entity.Stimmung;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class YmlReader {
    public Map<String, ArrayList<String>> readYml(){
        Yaml yaml = new Yaml();
        try{
            FileInputStream fis = new FileInputStream("Elemente.yml");
            return yaml.load(fis);
        }catch (Exception e){
            e.getMessage();
            return null;
        }
    }

    public List<Art> createArt(){
        List<Art> artList = new ArrayList<>();
        Map<String, ArrayList<String>> list = readYml();
        for (int i = 0; i <list.get("art").size();i++){
            artList.add(new Art(list.get("art").get(i)));
        }
        return artList;
    }

    public List<Stimmung> createStimmung (){
        List<Stimmung> stimmungList = new ArrayList<>();
        Map<String, ArrayList<String>> list = readYml();
        for (int i = 0; i <list.get("stimmung").size();i++){
            stimmungList.add(new Stimmung(list.get("stimmung").get(i)));
        }
        return stimmungList;
    }

    public List<Objekt> createObjekt (){
        List<Objekt> objektList = new ArrayList<>();
        Map<String, ArrayList<String>> list = readYml();
        ArrayList objektObj = list.get("objekt");
        for (Object o : objektObj) {
            LinkedHashMap objekt = (LinkedHashMap) o;
            objektList.add(new Objekt(objekt.get("name").toString(), (ArrayList<String>) objekt.get("tag")));
        }
        return objektList;
    }
}
