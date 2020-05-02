package clase5;

import java.util.ArrayList;
import java.util.Scanner;

public class Aplicacion2 {
    public int getN1() {
        return n1;
    }
    Scanner scanner = new Scanner(System.in);
    public void setN1(int n1) {
        this.n1 = n1;
    }

    private int n1;
    public int pedirN1()
    {
        System.out.println("ingresa un numero entero positivo");
        setN1(scanner.nextInt());
        while(n1<0)
        {
            System.out.println("ingresa un numero entero positivo");
            setN1(scanner.nextInt());
        }
        return n1;
    }
    public void primerosPares(int n1)
    {
        ArrayList <Integer> to = new ArrayList<>();
        int nAUX=0;

        for(int i=0; i<n1; i++)
        {
            nAUX= nAUX+2;
            to.add(nAUX);
        }
        for(int i=0; i<to.size(); i++)
        {
            System.out.println(to.get(i));
        }
    }
    public static void main (String [] args)
    {
        Aplicacion2 obj1= new Aplicacion2();
        obj1.pedirN1();
        obj1.primerosPares(obj1.getN1());
    }
}
