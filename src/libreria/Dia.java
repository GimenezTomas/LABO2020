package libreria;

import java.util.ArrayList;

public enum Dia {
    DOMINNGO("domingo", new ArrayList<>()), LUNES("lunes", new ArrayList<>()), MARTES("martes", new ArrayList<>()), MIERCOLES("miércoles", new ArrayList<>()), JUEVES("jueves", new ArrayList<>()), VIERNES("viernes", new ArrayList<>()), SABADO("sábado", new ArrayList<>());

    private String nombre;
    private ArrayList<Integer> IdFacturas=new ArrayList<>();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Integer> getIdFacturas() {
        return IdFacturas;
    }

    public void setIdFacturas(ArrayList<Integer> idFacturas) {
        IdFacturas = idFacturas;
    }

    Dia(String nombre, ArrayList<Integer> idFacturas) {
        this.nombre = nombre;
        IdFacturas = idFacturas;
    }
}
