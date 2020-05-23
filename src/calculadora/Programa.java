package calculadora;

import java.util.ArrayList;
import java.util.Scanner;

public class Programa {
    private ArrayList<Rutina> rutinas = new ArrayList<Rutina>();

    public ArrayList<Rutina> getRutinas() {
        return rutinas;
    }

    public void setRutinas(ArrayList<Rutina> rutinas) {
        this.rutinas = rutinas;
    }
    public void AgregarInstruccion(String nombre, String nombreInstruccion) {
        boolean i=true;
        float n=0.0f;
        char nombreVariable;
        Scanner scanner= new Scanner(System.in);
        for (int x=0; x<this.rutinas.size(); x++)//Pregunta si ya existe la rutina
        {
            if(this.rutinas.get(x).getNombre().equals(nombre))
            {
                i=false;
            }
        }
        if (i)// Si no existe la crea
        {
            this.rutinas.add(new Rutina(nombre, nombreInstruccion));
            for (int x=0; x<this.rutinas.size(); x++)//Rellena la rutina con una instruccion y opcional nombre variable y numero
            {
                if(this.rutinas.get(x).getNombre().equals(nombre))
                {
                    if(nombreInstruccion.equals("push")){
                        System.out.println("INGRESA UN NUMERO PARA LA "+nombre+" E INSTRUCCION "+nombreInstruccion);
                        n=scanner.nextFloat();
                        this.rutinas.get(x).getInstrucciones().get(this.rutinas.get(x).getInstrucciones().size()-1).setNumero(n);
                    }
                    else if(nombreInstruccion.equals("read") || nombreInstruccion.equals("write"))
                    {
                        System.out.println("INGRESA UNA LETRA PARA LA VARIABLE EN LA "+nombre+" E INSTRUCCION "+nombreInstruccion+" Y UN VALOR PARA ESTA ");
                        nombreVariable=scanner.next().charAt(0);//chequear si sirve
                        n=scanner.nextFloat();
                        this.rutinas.get(x).getInstrucciones().get(this.rutinas.get(x).getInstrucciones().size()-1).setNumero(0);
                        this.rutinas.get(x).getInstrucciones().get(this.rutinas.get(x).getInstrucciones().size()-1).setNombreVariable(nombreVariable);
                    }
                }
            }
        }
        else
        {
            for (int x = 0; x < this.rutinas.size(); x++)//Lo mismo que el for anterior pero para una rutina ya creada
            {
                if (this.rutinas.get(x).getNombre().equals(nombre)) {
                    if (nombreInstruccion.equals("push")) {
                        this.rutinas.get(x).getInstrucciones().add(new Instruccion(nombreInstruccion));
                        System.out.println("INGRESA UN NUMERO PARA LA " + nombre + " E INSTRUCCION " + nombreInstruccion);
                        n = scanner.nextFloat();
                        this.rutinas.get(x).getInstrucciones().get(this.rutinas.get(x).getInstrucciones().size() - 1).setNumero(n);
                    } else if (nombreInstruccion.equals("read") || nombreInstruccion.equals("write")) {
                        System.out.println("INGRESA UNA LETRA PARA LA VARIABLE EN LA " + nombre + " E INSTRUCCION " + nombreInstruccion);
                        nombreVariable = scanner.next().charAt(0);
                        this.rutinas.get(x).getInstrucciones().add(new Instruccion(nombreInstruccion));
                        this.rutinas.get(x).getInstrucciones().get(this.rutinas.get(x).getInstrucciones().size() - 1).setNumero(0);
                        this.rutinas.get(x).getInstrucciones().get(this.rutinas.get(x).getInstrucciones().size() - 1).setNombreVariable(nombreVariable);
                    } else {
                        System.out.println(nombre + " E INSTRUCCION " + nombreInstruccion);
                        this.rutinas.get(x).getInstrucciones().add(new Instruccion(nombreInstruccion));
                    }
                }
            }
        }
    }
}
