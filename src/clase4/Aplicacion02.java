package clase4;

import java.util.ArrayList;
import java.util.Scanner;

public class Aplicacion02 {
    private String nombre;
    private int precio;
    private int unidades;
    private String marca;
    ArrayList<Aplicacion02> canastA = new ArrayList<Aplicacion02>();
    Scanner ingreso02 = new Scanner(System.in);

    public ArrayList<Aplicacion02> getCanastA() {
        return canastA;
    }

    public void setCanast(ArrayList<Aplicacion02> canastA) {
        this.canastA = canastA;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String pedirNombre()
    {
        System.out.println("Nombre? ");
        setNombre(ingreso02.nextLine());
        return nombre;
    }
    public String pedirMarca()
    {
        System.out.println("Marca? ");
        setMarca(ingreso02.nextLine());
        return marca;
    }
    public int pedirUnidades()
    {
        System.out.println("Unidades? ");
        setUnidades(ingreso02.nextInt());
        return unidades;
    }
    public int pedirPrecio()
    {
        System.out.println("Precio? ");
        setPrecio(ingreso02.nextInt());
        return precio;
    }
    public void detalleDeFactura(ArrayList<Aplicacion02> canastA)
    {
        int importeTotal=0;
        getCanastA().size();
        for(int i=0; i < canastA.size(); i++)
        {
            importeTotal= importeTotal + ((canastA.get(i).precio)*(canastA.get(i).unidades));
        }
        System.out.println("Importe total: "+importeTotal);
    }
}
