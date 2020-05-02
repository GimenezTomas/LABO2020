package Hotel;

public class Habitaciones {
    private int capacidad;
    private float precio;
    private boolean ocupada;
    public static int count=1;
    private int numeroDeHabitacion;

    public int getNumeroDeHabitacion() {
        return numeroDeHabitacion;
    }

    public void setNumeroDeHabitacion(int numeroDeHabitacion) {
        this.numeroDeHabitacion = numeroDeHabitacion;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    public Habitaciones(int capacidad, float precio)
    {
        this.capacidad=capacidad;
        this.precio=precio;
        this.numeroDeHabitacion=count++;
        setOcupada(false);    }
}

