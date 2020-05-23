package equipo_futbol;

public class Jugador {
    private int edad;
    private String nombre;
    private String apellido;
    private int numeroJugador;
    public static int count=1;//FIJARSE SI EL PRIMER JUGADOR TIENE JN°1

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Jugador(String nombre, String apellido, int edad) {
        this.edad = edad;
        this.apellido = apellido;
        this.nombre = nombre;
        numeroJugador=count++;
    }
}
