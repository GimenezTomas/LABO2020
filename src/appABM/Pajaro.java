package appABM;

import persona.Persona;
import sistemaABM.Mascota;

public class Pajaro extends Animal {
    private String saludo="pio";
    private int alegria=0;

    public Pajaro(String nombre, String tipoAnimal, Persona dueño) {
        super(nombre, tipoAnimal, dueño);
    }

    @Override
    public void alimentar() {
        this.alegria=this.alegria+1;
    }
    @Override
    public void saludar(int dni) {
        if (dni == this.getDueño().getDocumento())
        {
            for (int i = 0; i <this.alegria ; i++) {
                System.out.print(this.saludo+" ");
            }
            System.out.println("");
        }
    }
}
