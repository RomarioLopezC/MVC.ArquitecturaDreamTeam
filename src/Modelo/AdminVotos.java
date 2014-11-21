package Modelo;

import Cache.DreamTeamCache;
import java.util.ArrayList;

public class AdminVotos extends Modelo {

    private DreamTeamCache cache;
    static AdminVotos adminVtos;
    private ArrayList<Candidato> cands;
    private int contador = 0;

    public AdminVotos() {
        this.cache = new DreamTeamCache();
        cache.configLoad();
        inicializarCandidatos();
        this.cands = listaCandidatos();
        inicializarEventos();
        super.datos = cands;
    }

    public static AdminVotos getInstance() {
        if (adminVtos == null) {
            adminVtos = new AdminVotos();
        }
        return adminVtos;
    }

    private void inicializarCandidatos() {
        Candidato A = new Candidato(1, "Romario");
        cache.put(A.getId(), A);

        Candidato B = new Candidato(2, "David");
        cache.put(B.getId(), B);

        Candidato C = new Candidato(3, "Victor");
        cache.put(C.getId(), C);
    }

    public void inicializarEventos() {
        int numeroDeEventos = 3;
        for (int i = 0; i < numeroDeEventos; i++) {
            eventos.add(new Evento(i));
        }
    }

    public void agregarCandidatos(int id, String nombre) {
        Candidato candidatoNuevo = new Candidato(id, nombre);
        cache.put(id, candidatoNuevo);
        super.datos=listaCandidatos();
        notificarObservadoresEvento(0);
    }

    public void agregarVoto(int id) {
        Candidato candidato = (Candidato) cache.get(id);
        candidato.agregarVoto();
        cache.put(id, candidato);
        notificarObservadoresEvento(0);
    }

    public void eliminarCandidatos(String nombre, String peticion) {
        for (Candidato candidato : ((ArrayList<Candidato>) getDatos())) {
            if (candidato.getNombre().equals(nombre)) {
                ((ArrayList<Candidato>) getDatos()).remove(candidato);
                break;
            }
        }
        notificarObservadoresEvento(0);
    }

}
