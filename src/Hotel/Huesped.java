package Hotel;

public class Huesped {
    private int edad;
    private int dni;
    private String apellido;
    private String nombre;
    private int numeroDeHuesped;
    public static int count=1;
    public int getNumeroDeHuesped() {
        return numeroDeHuesped;
    }

    public void setNumeroDeHuesped(int numeroDeHuesped) {
        this.numeroDeHuesped = numeroDeHuesped;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public Huesped(String apellido, String nombre, int edad, int dni)
    {
        this.apellido=apellido;
        this.dni=dni;
        this.nombre=nombre;
        this.edad=edad;
        numeroDeHuesped=count++;
    }


}
