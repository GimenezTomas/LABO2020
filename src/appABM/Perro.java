package appABM;

import persona.Persona;
//import sistemaABM.Mascota;

public class Perro extends Animal {
    private String saludo="guau";
    private int alegria=0;

    public Perro(String nombre, String tipoAnimal, Persona dueño) {
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
        }
        else
        {
            for (int i = 0; i <this.alegria ; i++) {
                System.out.print(this.saludo.toUpperCase()+"! ");
            }
        }
        System.out.println("");
    }
}
