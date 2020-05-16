package Calculadora;

public class Variables {
    /*
    los nombres de las clases deben estar en singular
     */
    private String nombre;
    private float numero;

    public float getNumero() {
        return numero;
    }

    public void setNumero(float numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

/*
    Hola, Gimenez!
    Buenos trabajos!

    Recordar:
    - los nombres de paquetes solo pueden tener letras en
    minúsculas y se debe evitar usar más de una palabra en
    el nombre de un paquete.
    Además todos los nombres de paquetes deben ser declarativos.
    La idea es que cada uno vaya construyendo su propia librería.
    Además, en el futuro volverán a utilizar estas clases.

    - aplicar el concepto de alta cohesión en todas las clases

    - los nombres de todas las variables deben ser declarativas.

    - con respecto a los nombres de los atributos, si tienen
    sólo una palabra, van en minúsculas; si tienen más de una
    palabra, la primera va con minúsculas y las demás deben comenzar
    con letra mayúscula.


 */