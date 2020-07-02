package materia;

import persona.Persona;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Alumno extends Persona {
    private HashMap<Materia, Float> materias=new HashMap<>();
//GETTERS && SETTERS
    public HashMap<Materia, Float> getMaterias() {
        return materias;
    }

    public void setMaterias(HashMap<Materia, Float> materias) {
        this.materias = materias;
    }
//CONSTRUCTOR
    public Alumno(String nombre, String apellido, int edad, int documento) {
        super(nombre, apellido, edad, documento);
    }
    //METODOS
    public void promedioFinal()
    {
       float promF = 0;
       for(Map.Entry<Materia, Float> materia : this.materias.entrySet())
       {
            promF=materia.getValue()+promF;
       }
        System.out.println("El promedio final de "+this.getNombre()+" es "+promF/this.materias.size());
    }
    public void agregarMateria(String nombre) {
        boolean ok = true;
        for (Map.Entry<Materia, Float> materia : this.materias.entrySet())
        {
            if (materia.getKey().getNombre().equals(nombre))
            {
                ok = false;
            }
        }
        if (ok)
        {
            this.getMaterias().put(new Materia(nombre), 0.0f);
        }
        else
        {
            System.out.println("Ya existe una materia con ese nombre");
        }
    }
    public void promedioSegunMateria(String nombre)
    {
        for(Map.Entry<Materia, Float> materia : this.materias.entrySet())
        {
            if (materia.getKey().getNombre().equals(nombre))
            {
                System.out.println(materia.getKey().promedio());
            }
        }
    }
    public void menorPromedio()
    {
        float menorPromedio=11;
        for(Map.Entry<Materia, Float> materia : this.materias.entrySet())
        {
            if (materia.getKey().promedio()<menorPromedio)
            {
                menorPromedio=materia.getKey().promedio();
            }
        }
        System.out.println("El menor promedio de "+this.getNombre()+" es: "+menorPromedio);
    }
    public void mayorPromedio()
    {
        float mayorPromedio=0;
        for(Map.Entry<Materia, Float> materia : this.materias.entrySet())
        {
            if (materia.getKey().promedio()>mayorPromedio)
            {
                mayorPromedio=materia.getKey().promedio();
            }
        }
        System.out.println("El mayor promedio de "+this.getNombre()+" es: "+mayorPromedio);
    }
    public void agregarNotas(String nombre, Float nota)
    {
        for(Map.Entry<Materia, Float> materia : this.materias.entrySet())
        {
            if (materia.getKey().getNombre().equals(nombre))
            {
                materia.getKey().agregarNota(nota, this.getMaterias());
            }
        }
    }
    public static void main(String [] args)
    {
        Alumno alumno1=new Alumno("Tomás", "Giménez", 17, 44000000);
        alumno1.agregarMateria("Matematica");
        alumno1.agregarMateria("Fisica");
        alumno1.agregarMateria("Literatura");

        alumno1.agregarNotas("Matematica", 5f);
        alumno1.agregarNotas("Matematica", 10f);
        alumno1.agregarNotas("Matematica", 10f);
        alumno1.agregarNotas("Matematica", 5f);
        alumno1.agregarNotas("Fisica", 10f);

        alumno1.promedioFinal();
        alumno1.promedioSegunMateria("Matematica");
        alumno1.menorPromedio();
        alumno1.mayorPromedio();
    }
}
