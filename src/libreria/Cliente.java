package libreria;
import persona.Persona;

import java.util.ArrayList;
import java.util.HashSet;

public class Cliente extends Persona{
    //ATRIBUTOS
    private ArrayList<Factura> compras=new ArrayList<>();
    //GETTERS && SETTERS

    public ArrayList<Factura> getCompras() {
        return compras;
    }

    public void setCompras(ArrayList<Factura> compras) {
        this.compras = compras;
    }

    //CONSTRUCTORES
    public Cliente(String nombre, String apellido, int edad, int documento) {
        super(nombre, apellido, edad, documento);
    }
}
