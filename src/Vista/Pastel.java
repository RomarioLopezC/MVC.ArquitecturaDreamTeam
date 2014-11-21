package Vista;


import Modelo.Candidato;
import Modelo.Modelo;
import java.util.ArrayList;

public class Pastel extends Vista{
    private final GraficaPastel graficaPastel;
    private ArrayList<Candidato> candidatos;
    
    public Pastel(Modelo modelo, int idEvento) {
        super(modelo, idEvento);
        this.candidatos= modelo.listaCandidatos();
        graficaPastel=new GraficaPastel();
    }

    @Override
    public void actualizar(Object datos) {
        super.actualizar(datos);
        this.candidatos= (ArrayList<Candidato>) datos;
        activar();
    }

    @Override
    public void desplegar(){
    }


    @Override
    public void activar() {
        graficaPastel.init(this.candidatos);
        graficaPastel.setVisible(true);
    }

    
}
