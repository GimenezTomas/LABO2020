package Calculadora;

import java.util.HashSet;

public class Rutina {
    //ATRIBUTOS
    private String nombre;
    private HashSet<Instruccion> instrucciones=new HashSet<Instruccion>();
    //METODOS
    public HashSet<Instruccion> getInstrucciones() {
        return instrucciones;
    }
    public void setInstrucciones(HashSet<Instruccion> instrucciones) {
        this.instrucciones = instrucciones;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    //CONSTRUCTOR
    public Rutina(String nombre, Instruccion instrucciones) {
        this.nombre=nombre;
        this.instrucciones.add(instrucciones);
    }
}
