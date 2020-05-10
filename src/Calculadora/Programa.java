package Calculadora;

import java.util.HashSet;

public class Programa {
    private HashSet<Rutina> agregarInstruccion= new HashSet<Rutina>();

    public HashSet<Rutina> getAgregarInstruccion() {
        return agregarInstruccion;
    }
    public void setAgregarInstruccion(HashSet<Rutina> agregarInstruccion) {
        this.agregarInstruccion = agregarInstruccion;
    }

    public void AgregarInstruccion(String nombre, Instruccion instruccion) {
        boolean i=true;
        for (Rutina r: this.agregarInstruccion)
        {
            if(nombre.equals(r.getNombre()))
            {
                r.getInstrucciones().add(instruccion);
                i=false;
            }
        }
        if (i == false)
        {
            this.agregarInstruccion.add(new Rutina(nombre, instruccion));
        }
    }
}
