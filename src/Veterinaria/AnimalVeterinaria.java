package Veterinaria;

import appABM.Animal;
import persona.Persona;

import java.util.ArrayList;
import java.util.Date;

public class AnimalVeterinaria extends Animal{
    public static int count=0;
    private int id;
    private ArrayList<Date> fechaVisita = new ArrayList<>();
    private int visitasPorAño;

    public int getVisitasPorAño() {
        return visitasPorAño;
    }

    public void setVisitasPorAño(int visitasPorAño) {
        this.visitasPorAño = visitasPorAño;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Date> getFechaVisita() {
        return fechaVisita;
    }

    public void setFechaVisita(ArrayList<Date> fechaVisita) {
        this.fechaVisita = fechaVisita;
    }

    public AnimalVeterinaria(String tipoAnimal, int visitasPorAño) {
        super(tipoAnimal);
        this.id=count++;
        this.visitasPorAño=visitasPorAño;
    }

}


