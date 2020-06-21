package libreria;

public enum Cuaderno{
    CHICO(24, 100, "Cuaderno chico"),MEDIANO(48, 150, "Cuaderno mediano"),GRANDE(98, 200, "Cuaderno grande");
    private int cantHojas;
    private float precio;
    private String nombre;
    private Cuaderno(int cantHojas, float precio, String nombre)
    {
        this.cantHojas=cantHojas;
        this.precio=precio;
        this.nombre=nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantHojas()
    {
        return cantHojas;
    }

    public float getPrecio() {
        return precio;
    }
}
