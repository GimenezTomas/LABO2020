package restaurantes;

public class Plato {
    private String nombre;
    private float precio;
    private int vecesPedido;
    //GETTERS && SETTERS
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getVecesPedido() {
        return vecesPedido;
    }

    public void setVecesPedido(int vecesPedido) {
        this.vecesPedido = vecesPedido;
    }
    //CONSTRUCTOR
    public Plato(String nombre, float precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
}
