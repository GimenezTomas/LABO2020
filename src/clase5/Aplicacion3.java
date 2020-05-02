package clase5;

import java.util.ArrayList;
import java.util.Scanner;

public class Aplicacion3 {
    private int n1;
    Scanner scanner= new Scanner(System.in);
    public int getN1() {
        return n1;
    }

    public void setN1(int n1) {
        this.n1 = n1;
    }
    public void pedirNumero()
    {
        int contador=0;
        ArrayList <Integer> arreglo = new ArrayList<>();
        System.out.println("Ingresa numeros enteros, con -1 se termina el programa");
        System.out.println("Ingresa un numero entero");
        setN1(scanner.nextInt());
        int suma=0;
        while(n1!=(-1))
        {
            arreglo.add(n1);
            suma=suma+n1;
            System.out.println("Ingresa un numero entero");
            setN1(scanner.nextInt());
            contador++;
        }
        System.out.println("Los numeros ingresados son: "+contador);
        System.out.println("La suma de los numeros es: "+suma);
        for(int i=0; i<arreglo.size(); i++)
        {
            System.out.println(arreglo.get(i));
        }
        System.out.println("Se ingresaron numeros ( "+contador+" ) veces");
    }
    public static void main (String [] args)
    {
        Aplicacion3 obj1 = new Aplicacion3();
        obj1.pedirNumero();

    }
}
