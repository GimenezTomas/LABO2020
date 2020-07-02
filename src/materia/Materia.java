package materia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Materia {
    private String nombre;
    ArrayList<Float> notas = new ArrayList<>();

    //GETTERS && SETTERS

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Float> getNotas() {
        return notas;
    }

    public void setNotas(ArrayList<Float> notas) {
        this.notas = notas;
    }

    //CONTRUCTOR
    public Materia(String nombre) {
        this.nombre = nombre;
    }

    //METODOS
    public void agregarNota(float nota, HashMap<Materia, Float> prom)
    {
        if(nota <=10 && nota>0)//chequear
        {
            this.notas.add(nota);
            for (Map.Entry<Materia, Float> materia : prom.entrySet())
            {
                if (materia.getKey().getNombre().equals(this.nombre))
                {
                    prom.put(materia.getKey(), promedio());
                }
            }
        }
        else
        {
            System.out.println("La nota maxima es 10 y la minima 0. Reingresar");
        }
    }
    public void menorNota()
    {
        float menor=11;
        for(Float nota : this.notas)
        {
            if(nota<menor)
            {
                menor=nota;
            }
        }
        if(menor!=11)
        {
            System.out.println("La nota mas baja de "+this.nombre+" es: "+ menor);
        }
        else
        {
            System.out.println("No hay notas");
        }
    }
    public void mayorNota()
    {
        float mayor=0;
        for(Float nota: this.notas)
        {
            if(nota>mayor)
            {
                mayor=nota;
            }
        }
        if(mayor!=0)
        {
            System.out.println("La nota mas alta de"+this.nombre+" es: "+ mayor);
        }
        else
        {
            System.out.println(this.nombre+" No tiene notas");
        }
    }
    public float promedio()
    {
        float n=0;
        for(Float nota : this.notas)
        {
            n=n+nota;
        }
        n=n/this.notas.size();
        return n;
    }
}
