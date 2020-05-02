package clase4;
import java.util.Scanner;

public class Aplicacion01 {
    //Atributos
    private String nombre;
    private String ocupacion;
    private String apellido;
    private int edad;
    //Metodos
    public void setNombre(String nombre)
    {
        this.nombre=nombre;
    }
    public String getNombre()
    {
        return nombre;
    }
    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
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
    Scanner ingreso01=new Scanner(System.in);

    public String pedirApellid()
    {
        System.out.println("Apellido? ");
        setApellido(ingreso01.nextLine());
        return apellido;
    }
    public String pedirNombre()
    {
        System.out.println("Nombre? ");
        setNombre(ingreso01.nextLine());
        return nombre;
    }
    public String pedirOcupacion()
    {
        System.out.println("Ocupacion?");
        setOcupacion(ingreso01.nextLine());
        return ocupacion;
    }
    public int pedirEdad()
    {
        System.out.println("Edad? ");
        setEdad(ingreso01.nextInt());
        return edad;
    }
}
