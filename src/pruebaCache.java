
import Cache.DreamTeamCache;
import Modelo.Candidato;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.jcs.access.exception.CacheException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Romario
 */
public class pruebaCache {
    public static void main(String[] args) {
        DreamTeamCache Cache = new DreamTeamCache();
        
        try {
            Cache.configLoad();
        } catch (CacheException ex) {
            Logger.getLogger(pruebaCache.class.getName()).log(Level.SEVERE, null, ex);
        }
        Cache.put(5, new Candidato("Romario"));
        
        
        System.out.println(((Candidato)Cache.get(5)).getNumVotos());
        
    }
}
