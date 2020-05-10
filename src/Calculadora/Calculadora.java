package Calculadora;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;

public class Calculadora {
    //ATRIBUTOS
    private HashSet<Programa> programas= new HashSet<Programa>();
    private Programa programa;
    private ArrayList<Float> pila= new ArrayList<>();
    private ArrayList<Variables> variables= new ArrayList<Variables>();
    //GETTERS && SETTERS
    public ArrayList<Float> getPila() {
        return pila;
    }
    public void setPila(ArrayList<Float> pila) {
        this.pila = pila;
    }
    public Programa getPrograma() {
        return programa;
    }
    public void cargarPrograma(Programa programa) {
        this.programa = programa;
    }
    public HashSet<Programa> getProgramas() {
        return programas;
    }
    public void setProgramas(HashSet<Programa> programas) {
        this.programas = programas;
    }
    public ArrayList<Variables> getVariables() {
        return variables;
    }
    public void setVariables(ArrayList<Variables> variables) {
        this.variables = variables;
    }
    //METODOS
    public void add(ArrayList<Float> pila)
    {
        float resultado;
        if(pila.size()==0)
        {
            resultado=0;
        }
        else if(pila.size()==1)
        {
            resultado=pila.get(0);
        }
        else
        {
            resultado=pila.get(pila.size()-1)+pila.get(pila.size()-2);
            remover(pila);
        }
        pila.add( resultado);
    }
    public void sub(ArrayList<Float> pila)
    {
        float resultado;
        if(pila.size()==0)
        {
            resultado=0;
        }
        else if(pila.size()==1)
        {
            resultado=pila.get(0);
        }
        else
        {
            resultado = pila.get(pila.size()-2) - pila.get(pila.size()-1);
            remover(pila);
        }
        pila.add( resultado)
        ;
    }
    public void push(ArrayList<Float> pila, float n)
    {
        pila.add(n);
    }
    public void mul(ArrayList<Float> pila)
    {
        float resultado;
        if(pila.size()==0)
        {
            resultado=0;
        }
        else if(pila.size()==1)
        {
            resultado=pila.get(0);
        }
        else
        {
            resultado = pila.get(pila.size()-2) * pila.get(pila.size()-1);
            remover(pila);
        }
        pila.add(resultado);
    }
    public void remover(ArrayList<Float> pila)
    {
        pila.remove(pila.size()-1);
        pila.remove(pila.size()-2);
    }
    public void read(Variables variable, ArrayList<Float> pila)
    {
        float resultado=0;
        if(variable == null)
        {
            pila.add(resultado);
        }
        else
        {
            pila.add(variable.getNumero());
        }
    }
    public void write(Variables variable, ArrayList<Float> pila)
    {
        variable.setNumero(pila.get(pila.size()-1));
    }
    public static void main(String [] args)
    {
        Calculadora calculadora= new Calculadora();
        Programa p = new Programa();
        p.AgregarInstruccion("Rutina A", );

    }
}
/*Crear una mini-calculadora programable.
La calculadora se inicializa cargándole un programa.
Cada programa contiene varias rutinas y cada rutina está asociada a un nombre
y consta de una secuencia de instrucciones.
La calculadora opera con una pila que almacena valores numéricos, y
con una memoria en la que se pueden guardar variables identificadas por nombre.

Los programas pueden utilizar seis distintos tipos de operaciones:
cuatro operaciones aritméticas (push, add, sub, mul),
dos operaciones de manejo de variables (read, write).

Ejemplo:
La rutina "A" contiene las instrucciones:
	read(x)
	push(2)
	add
	write(y)

La Rutina "B" contiene las intstrucciones:
	push(2)
	read(x)
	mul
	write(x)

Operaciones aritméticas:

push(número), mete una constante numérica en la pila.

add, saca dos valores del tope de la pila, los suma y apila el resultado.
En caso de que la pila se encuentre vacía, se toma 0 como valor por defecto. En caso de que
haya sólo un valor, se deja tal cual está.

sub, saca dos valores del tope de la pila, los resta y apila el resultado.
El valor en el tope de la pila es el
sustraendo. Igual que para la suma, si la pila está vacía, el valor por defecto es 0.

mul, saca dos valores del tope de la pila, los multiplica y apila el resultado.
Al igual que antes, si la pila está vacía, el valor por defecto es 0.


Operaciones de manejo de variables:

Las operaciones de manejo de variables permiten almacenar un valor en la memoria de
la calculadora.

write(variable), saca el valor del tope de la pila y lo guarda en la variable indicada.
Si la pila está vacía, el valor por defecto es 0.

ejemplo:
	si la pila contiene sólo al valor 34
	las variables presentes en la memoria de la calculadora son
	x con valor 12 (en el tope)
	y con valor 45
	se ejecuta la instrucción write(x)
	entonces ahora la pila estará vacía porque el valor 34 se guardó
	en la variable x y la memoria pasará a tener los siguientes valores:
	x von valor 34 (en el tope)
	y con valor 45

read(variable), mete en la pila el valor actual de la variable indicada.
Si la variable no fue inicializada anteriormente, se considera que su valor
por defecto es 0.

ejemplo:
	si la pila se encuentra vacía
	las variables de la calculadora, tiene a:
	x con valor 7 (en el tope)
    y con valor 32
	se ejecuta la instrucción read(y). Entonces, la pila
	ahora contendrá el valor 32.

-------------------------------------------------------------------

Cómo se utilizaría la calculadora?

Programa p = new Programa();

p.agregarInstruccion("rutinaA", new Instruccion(PUSH, 2));
p.agregarInstruccion("rutinaA", new Instruccion(ADD));
p.agregarInstruccion("rutinaA", new Instruccion(WRITE, "y"));
p.agregarInstruccion("rutinaA", new Instruccion(READ, "x"));
p.agregarInstruccion("rutinaB", new Instruccion(READ, "x"));
p.agregarInstruccion("rutinaB", new Instruccion(MUL));
p.agregarInstruccion("rutinaB", new Instruccion(WRITE, "x"));
p.agregarInstruccion("rutinaB", new Instruccion(PUSH, 2));

Calculadora calc = new Calculadora();
calc.cargarPrograma(p);
calc.ejecutar("rutinaB");

-----------------------------------------------------------------
comentarios:
* pueden usar cualquier estructura de datos que hayamos visto.
*/