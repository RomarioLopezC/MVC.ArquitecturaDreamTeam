package Modelo;

import Cache.DreamTeamCache;
import java.util.ArrayList;

public class Modelo {

    //Este atributo privado mantiene el vector con los observadores
    protected ArrayList<Evento> eventos;
    protected Object datos;
    public static DreamTeamCache cache;
    private static final int MAX_ELEMENTOS_CACHE = 1000;

    //El constructor crea el vector con la asociacion Observable-Observador 
    //De igual manera se ingresa lo necesario para hacer que la cache funcione
    public Modelo() {
        this.cache = new DreamTeamCache();
        cache.configLoad();
        eventos = new ArrayList();
    }

    public void registrarObservador(Observer observer, int idEvento) {
        for (Evento evento : eventos) {
            if (evento.getIdEvento() == idEvento) {
                evento.agregarMiembro(observer);
                return;
            }
        }
    }

    public void eliminarObservador(Observer observer, int idEvento) {
        for (Evento evento : eventos) {
            if (evento.getIdEvento() == idEvento) {
                evento.eliminarMiembro(observer);
                return;
            }
        }
    }

    public void agregarEvento(Evento evento) {
        for (Evento evt : this.eventos) {
            if (evt.getIdEvento() == evento.getIdEvento()) {
                break;
            } else {
                eventos.add(evento);
            }
        }
    }

    public void notificarObservadoresEvento(int idEvento) {
        for (Evento evento : eventos) {
            if (evento.getIdEvento() == idEvento) {
                for (Observer observer : evento.getMiembros()) {
                    observer.actualizar(getDatos());
                }
                break;
            }
        }
    }

    /**
     * @return the datos
     */
    public Object getDatos() {
        return datos;
    }

    /**
     * @param datos the datos to set
     */
    public void setDatos(Object datos) {
        this.datos = datos;
    }

    /**
     * Método que obtiene los candidatos de la cache y los ingresa a un
     * ArrayList
     *
     * @return regresa la lista de candidatos
     */
    public ArrayList<Candidato> listaCandidatos() {
        ArrayList<Candidato> candidatos = new ArrayList<>();
        //Se recorre la cache para agregar los candidatos que tenga dentro:
        for (int i = 1; i < MAX_ELEMENTOS_CACHE; i++) {
            Candidato unCandidato = (Candidato) cache.get(i);
            //si devuelve null, se deja de recorrer la cache
            if (unCandidato == null) {
                break;
            }
            candidatos.add(unCandidato);
        }
        return candidatos;
    }
}
