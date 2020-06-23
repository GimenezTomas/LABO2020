package libreria;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public enum Editorial {
    Kapelusz("Kapelusz", new HashMap<>(), new HashMap<>(), new ArrayList<>(), 1), Sudamericana("Sudamericana", new HashMap<>(), new HashMap<>(), new ArrayList<>(), 1), Atlántida("Atlántida", new HashMap<>(), new HashMap<>(), new ArrayList<>(), 1), ElAteneo("ElAteneo", new HashMap<>(), new HashMap<>(), new ArrayList<>(), 1), Interzona("Interzona", new HashMap<>(), new HashMap<>(), new ArrayList<>(), 1), Sur("Sur", new HashMap<>(), new HashMap<>(), new ArrayList<>(), 1), Alianza("Alianza", new HashMap<>(), new HashMap<>(), new ArrayList<>(), 1);

    private String nombre;
    private HashMap<String, Float> stock=new HashMap<>();
    private HashMap <String, Integer> librosVendidos=new HashMap<>();
    private ArrayList<Integer> idFacturas=new ArrayList<>();
    private float descuento=1;


    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }

    public ArrayList<Integer> getIdFacturas() {
        return idFacturas;
    }

    public void setIdFacturas(ArrayList<Integer> idFacturas) {
        this.idFacturas = idFacturas;
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

    Editorial(String nombre, HashMap<String, Float> stock, HashMap<String, Integer> librosVendidos, ArrayList<Integer> idFacturas, float descuento) {
        this.nombre = nombre;
        this.stock = stock;
        this.librosVendidos = librosVendidos;
        this.idFacturas = idFacturas;
        this.descuento = descuento;
    }

}

