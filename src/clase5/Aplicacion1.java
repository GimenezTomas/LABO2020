package clase5;
import java.util.Scanner;

public class Aplicacion1 {
    private int n1;
    private int n2;
    Scanner scanner= new Scanner(System.in);

    public int getN2() {
        return n2;
    }

    public void setN2(int n2) {
        this.n2 = n2;
    }
    public int getN1() {
        return n1;
    }

    public void setN1(int n1) {
        this.n1 = n1;
    }

    public int pedirNumero()
    {
        System.out.println("Ingresa un numero entero");
        setN1(scanner.nextInt());
        return n1;
    }
    public void mayorMenorIgual(int n1, int n2)
    {
        if(n1<n2)
        {
            System.out.println("n2 es mas grande: "+n2);
        }
        else if(n1>n2)
        {
            System.out.println("n1 es mas grande: "+n1);
        }
        else
        {
            System.out.println("Son iguales: "+n1+" = "+n2);
        }

    }
    public static void main(String[] args)
    {
        Aplicacion1 hola=new Aplicacion1();
        int numero1;
        int n2;
        numero1=hola.pedirNumero();
        n2=hola.pedirNumero();
        hola.mayorMenorIgual(numero1,n2);
    }
}
