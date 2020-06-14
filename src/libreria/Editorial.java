package libreria;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class Editorial {
    private String nombre;
    private HashMap <String, Float> stock=new HashMap<>();
    private HashMap <String, Integer> librosVendidos=new HashMap<>();
    private ArrayList<Factura> facturas=new ArrayList<>();
    private float descuento=1;
    //GETTERS && SETTERS

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }

    public ArrayList<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(ArrayList<Factura> facturas) {
        this.facturas = facturas;
    }

    public HashMap<String, Integer> getLibrosVendidos() {
        return librosVendidos;
    }

    public void setLibrosVendidos(HashMap<String, Integer> librosVendidos) {
        this.librosVendidos = librosVendidos;
    }

    public HashMap<String, Float> getStock() {
        return stock;
    }

    public void setStock(HashMap<String, Float> stock) {
        this.stock = stock;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    //CONSTRUCTOR
    public Editorial(String nombre) {
        this.nombre = nombre;
    }

    //METODOS
}
