package appABM;

import persona.Persona;
import sistemaABM.Mascota;

import java.util.HashSet;

public class Pez extends Animal {
    private int vidas=10;

    public Pez(String nombre, String tipoAnimal, Persona dueño) {
        super(nombre, tipoAnimal, dueño);
    }

    @Override
    public void alimentar() {
        this.vidas++;
    }

    //@Override
    public void saludar(int dni, HashSet<Animal> animales) {
        if(dni == this.getDueño().getDocumento())
        {
            this.vidas--;
        }
        else
        {
            this.vidas=0;
        }
    }
}
