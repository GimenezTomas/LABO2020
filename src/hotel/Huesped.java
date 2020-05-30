package hotel;

public class Huesped extends Persona{

    private int numeroDeHuesped;
    public static int count=1;

    //GETTERS && SETTERS

    public int getNumeroDeHuesped() {
        return numeroDeHuesped;
    }

    public void setNumeroDeHuesped(int numeroDeHuesped) {
        this.numeroDeHuesped = numeroDeHuesped;
    }

    public Huesped(String apellido, String nombre, int edad, int dni)
    {
        super(apellido, nombre, edad, dni);
        numeroDeHuesped=count++;
    }
}
