package calculadora;

public class Variable {
    private char nombre;
    private float numero;
//GETTERS && SETTERS
    public float getNumero() {
        return numero;
    }

    public void setNumero(float numero) {
        this.numero = numero;
    }

    public char getNombre() {
        return nombre;
    }

    public void setNombre(char nombre) {
        this.nombre = nombre;
    }
//CONSTRUCTOR

    public Variable(char nombre, float numero) {
        this.nombre = nombre;
        this.numero = numero;
    }
}
