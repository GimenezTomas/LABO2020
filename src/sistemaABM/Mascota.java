package sistemaABM;
import persona.Persona;

import java.util.Scanner;

public class Mascota {
    private String nombre;
    private String tipoAnimal;
    private String saludo;
    private int alegria;
    private int vidas;
    private Persona dueño;

    //GETTER && SETTERS

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

    public String getSaludo() {
        return saludo;
    }

    public void setSaludo(String saludo) {
        this.saludo = saludo;
    }

    public int getAlegria() {
        return alegria;
    }

    public void setAlegria(int alegria) {
        this.alegria = alegria;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    public Persona getDueño() {
        return dueño;
    }

    public void setDueño(Persona dueño) {
        this.dueño = dueño;
    }

    //CONSTRUCTOR
    public Mascota(String nombre, String tipoAnimal, Persona dueño) {
        this.dueño=dueño;
        this.nombre=nombre;
        this.tipoAnimal=tipoAnimal;
        if(tipoAnimal.equals("Pez"))
        {
            this.vidas=10;
            this.saludo=null;
        }
        else if(tipoAnimal.equals("Perro"))
        {
            this.alegria=0;
            this.saludo="guau";
        }
        else if(tipoAnimal.equals("Gato"))
        {
            this.saludo="miau";
            this.alegria=0;
        }
        else
        {
            this.saludo="pio";
            this.alegria=0;
        }
    }
}
