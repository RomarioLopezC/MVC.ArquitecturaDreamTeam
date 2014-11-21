package Vista;

import Modelo.Modelo;
import Modelo.Observer;

public abstract class Vista implements Observer {

    private Modelo modelo;

    public Vista(Modelo modelo, int idEvento) {
        this.modelo = modelo;
        this.modelo.registrarObservador(this, idEvento);
    }

    public void actualizar(Object o) {
        System.out.println("si actualiza, vista");
    }


    public abstract void activar();

    public abstract void desplegar();
}
