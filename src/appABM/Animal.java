package appABM;

import persona.Persona;

public class Animal {
    private String nombre;
    private String tipoAnimal;
    private Persona dueño;

    //GETTERS && SETTERS

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoAnimal() {
        return tipoAnimal;
    }

    public void setTipoAnimal(String tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }

    public Persona getDueño() {
        return dueño;
    }

    public void setDueño(Persona dueño) {
        this.dueño = dueño;
    }

    //CONSTRUCTOR

    public Animal(String nombre, String tipoAnimal, Persona dueño){
        this.nombre = nombre;
        this.tipoAnimal = tipoAnimal;
        this.dueño = dueño;
    }
    public Animal(String tipoAnimal){
        this.tipoAnimal = tipoAnimal;
       // this.dueño = dueño;
    }
    public void alimentar()    {
        System.out.println("Se alimento a "+this.nombre);
    }
    public void saludar(int dni){

    }
}
