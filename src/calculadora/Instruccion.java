package calculadora;

import java.util.Scanner;

public class Instruccion {
    //ATRIBUTOS
         private String nombre;
         private float numero;
         private char nombreVariable;
    //GETTERS && SETTERS

    public char getNombreVariable() {
        return nombreVariable;
    }

    public void setNombreVariable(char nombreVariable) {
        this.nombreVariable = nombreVariable;
    }

    public float getNumero() {
        return numero;
    }

    public void setNumero(float numero) {
        this.numero = numero;
    }

    public String getNombre() {
                return nombre;
        }
        public void setNombre(String nombre) {
                this.nombre = nombre;
        }
    //CONSTRUCTOR
        public Instruccion(String nombre) {
                String arrayNombres[]={"add","push","mul","sub","write","read"};
                int contador=0;
                Scanner scanner=new Scanner(System.in);
                while(contador==0)
                {
                        for(String nombresInst: arrayNombres)
                        {
                                if(nombresInst.equals(nombre))
                                {
                                        this.nombre = nombre;
                                        contador++;
                                }
                        }
                        if(contador==0)
                        {
                                System.out.println("INSTRUCCION INVALIDA ("+nombre+"), REINGRESAR");
                                nombre=scanner.nextLine();
                        }
                }
        }
}
