package Vista;

import Modelo.Candidato;
import Modelo.Modelo;
import java.util.ArrayList;

public class Barras extends Vista{
    private ArrayList<Candidato> candidatos;
    private final GraficaBarras graficaBarras;
    
    public Barras(Modelo modelo,int idEvento) {
        super(modelo,idEvento);
        this.candidatos= new ArrayList();
        this.graficaBarras=new GraficaBarras();
    }

    @Override
    public void actualizar(Object datos) {
        super.actualizar(datos);
        this.candidatos= (ArrayList<Candidato>) datos;
        desplegar();
        activar();
    }

    @Override
    public void desplegar(){
        System.out.println("Barras candidatos: "+candidatos.size());
        for (Candidato candidato : candidatos) {
            System.out.println(candidato.getNombre());
        }
    }


    @Override
    public void activar() {       
        graficaBarras.init(candidatos);
        graficaBarras.setVisible(true);      
    }
}
