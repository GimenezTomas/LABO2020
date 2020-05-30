package hotel;

public class Persona {
    private int edad;
    private int dni;
    private String nombre;
    private String apellido;

    //GETTERS && SETTERS
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    //CONSTRUCTOR
    public Persona(String apellido, String nombre, int edad, int dni) {
        this.edad = edad;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }
}
