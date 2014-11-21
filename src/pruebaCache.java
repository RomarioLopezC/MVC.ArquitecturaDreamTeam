
import Cache.DreamTeamCache;
import Modelo.Candidato;

public class pruebaCache {
    
    public static void main(String[] args) {
        DreamTeamCache cache = new DreamTeamCache();
        
        cache.configLoad();
        Candidato candidato = new Candidato(1, "Romario");
        cache.put(candidato.getId(), candidato);
        
        System.out.println("Candidato:"+candidato+"  Votos:"+candidato.getNumVotos());
        
    }
}
