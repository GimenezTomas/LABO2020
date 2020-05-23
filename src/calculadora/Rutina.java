package calculadora;

import java.util.ArrayList;

public class Rutina {
    //ATRIBUTOS
    private String nombre;
    private ArrayList<Instruccion> instrucciones=new ArrayList<>();
    //GETTERS && SETTERS
    public ArrayList<Instruccion> getInstrucciones() {
        return instrucciones;
    }

    public void setInstrucciones(ArrayList<Instruccion> instrucciones) {
        this.instrucciones = instrucciones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //CONSTRUCTOR
    public Rutina(String nombre, String nombreInstruccion) {
        this.nombre=nombre;
        this.instrucciones.add(new Instruccion(nombreInstruccion));
    }
}
