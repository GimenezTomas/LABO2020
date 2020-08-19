package restaurantes;

import java.util.ArrayList;
import java.util.HashMap;

public class Mesa {
    public static int count=1;
    private int nMesa;
    private boolean ocupada=false;

    //GETTERS && SETTERS

    public int getnMesa() {
        return nMesa;
    }

    public void setnMesa(int nMesa) {
        this.nMesa = nMesa;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        if(this.ocupada && ocupada)
        {
            System.out.println("Esa mesa ya esta ocupada");
        }
        else
        {
            this.ocupada = ocupada;
        }
    }
    //CONSTRUCTOR
    public Mesa() {
        this.nMesa=count++;
    }
}