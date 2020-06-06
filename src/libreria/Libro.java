package libreria;

public class Libro {
    private String nombre;
    private float precio;
    //GETTERS && SETTERS

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    //CONSTRUCTOR
    public Libro(String nombre, float precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    //METODOS
}
