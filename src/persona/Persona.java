package persona;

public class Persona {
    private String nombre;
    private String apellido;
    private int edad;
    private int documento;
    //GETTERS && SETTERS

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

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    //CONSTRUCTORES

    public Persona(String nombre, String apellido, int edad, int documento) {
        this.nombre = nombre;
        this.edad = edad;
        this.apellido=apellido;
        this.documento=documento;
    }
}
