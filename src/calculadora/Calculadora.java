package calculadora;

import java.util.ArrayList;

public class Calculadora {
    //ATRIBUTOS
    private Programa programa;
    private ArrayList<Float> pila= new ArrayList<>();
    private ArrayList<Variable> variables= new ArrayList<Variable>();
    //GETTERS && SETTERS

    public ArrayList<Variable> getVariables() {
        return variables;
    }

    public void setVariables(ArrayList<Variable> variables) {
        this.variables = variables;
    }

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

    //METODOS
    public void ejecutarRutina(String nombreRutina){
        for (Rutina rutinas: this.programa.getRutinas())
        {
            if(rutinas.getNombre().equals(nombreRutina))//Pregunta si ya existe la rutina
            {
                for(Instruccion instruccion: rutinas.getInstrucciones())
                {
                    String instruccionActual=instruccion.getNombre();
                    switch (instruccionActual)
                    {
                        case "push":
                            push(instruccion.getNumero());
                            break;

                        case "mul":
                            mul();
                            break;

                        case "add":
                            add();
                            break;
                        case "read":
                            read(instruccion);
                            break;
                        case "write":
                            write(instruccion);
                            break;
                        case "sub":
                            sub();
                            break;
                    }
                }
            }
        }
    }
    public void add()
    {
        float resultado;
        if(this.pila.size()==0)
        {
            resultado=0;
            this.pila.add( resultado);
        }
        else if(this.pila.size()==1)
        {
            resultado=this.pila.get(0);
        }
        else
        {
            resultado=this.pila.get(this.pila.size()-1)+this.pila.get(this.pila.size()-2);
            remover();
            this.pila.add( resultado);
        }
    }
    public void sub()
    {
        float resultado;
        if(this.pila.size()==0)
        {
            resultado=0;
            this.pila.add( resultado);
        }
        else if(this.pila.size()==1)
        {
            resultado=this.pila.get(0);
        }
        else
        {
            resultado = this.pila.get(this.pila.size()-2) - this.pila.get(this.pila.size()-1);
            remover();
            this.pila.add( resultado);
        }
    }
    public void push(float n)
    {
        this.pila.add(n);
    }
    public void mul()
    {
        float resultado;
        if(this.pila.size()==0)
        {
            resultado=0;
            this.pila.add( resultado);
        }
        else if(this.pila.size()==1)
        {
            resultado=this.pila.get(0);
        }
        else
        {
            resultado = this.pila.get(this.pila.size()-2) * this.pila.get(this.pila.size()-1);
            remover();
            this.pila.add( resultado);
        }
    }
    public void remover()
    {
        this.pila.remove(this.pila.size()-1);
        this.pila.remove(this.pila.size()-1);
    }
    public void read(Instruccion instruccion)
    {
        this.pila.add(buscarVariable(instruccion).getNumero());
        for(int i=0; i<this.variables.size(); i++)
        {
            if (this.variables.get(i).getNombre() == instruccion.getNombreVariable())
            {
                this.variables.get(i).setNumero(0);
            }
        }
    }
    public void write(Instruccion instruccion)
    {
        agregarVariable(instruccion);
        for(int i=0; i<this.variables.size(); i++)
        {
            if (this.variables.get(i).getNombre() == instruccion.getNombreVariable())
            {
                this.variables.get(i).setNumero(this.pila.get(this.pila.size()- 1));
            }
        }
        this.pila.remove(this.pila.size()-1);
    }
    public void agregarVariable(Instruccion instruccion)
    {
        boolean variableExistente=true;
        for(Variable variable: this.variables)
        {
            if(instruccion.getNombreVariable()==(variable.getNombre()))
            {
                variableExistente=false;
            }
        }
        if(variableExistente)
        {
            this.variables.add(new Variable(instruccion.getNombreVariable(), 0));
        }
    }
    public Variable buscarVariable(Instruccion instruccion)
    {
        agregarVariable(instruccion);//Agregar la variable si es que no existe
        Variable variableAux=new Variable('a',0);
        for(Variable variable : this.variables)
            {
                if(instruccion.getNombreVariable()==variable.getNombre())
                {
                    variableAux.setNumero(variable.getNumero());
                    variableAux.setNombre(variable.getNombre());
                }
            }
        return variableAux;
    }
    public static void main(String [] args) {
        Calculadora calculadora = new Calculadora();
        Programa p = new Programa();
        p.AgregarInstruccion("Rutina A", "push");
        p.AgregarInstruccion("Rutina A", "push");
        p.AgregarInstruccion("Rutina A", "add");
        p.AgregarInstruccion("Rutina A", "mul");
        p.AgregarInstruccion("Rutina A", "push");
        p.AgregarInstruccion("Rutina A", "sub");
        p.AgregarInstruccion("Rutina A", "push");
        p.AgregarInstruccion("Rutina A", "write");
        p.AgregarInstruccion("Rutina A", "read");

        calculadora.cargarPrograma(p);
        calculadora.ejecutarRutina("Rutina A");
        System.out.println("PILA");
        for (float nPila : calculadora.getPila()) {
            System.out.println(nPila);
        }
        System.out.println("TAMAÑO PILA: " + calculadora.pila.size());
        for (int j = 0; j < calculadora.getVariables().size(); j++) {
            System.out.println("VARIABLE: " + calculadora.getVariables().get(j).getNombre() + " | " + calculadora.getVariables().get(j).getNumero());
        }
    }
}
