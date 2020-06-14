package restaurantes;

import java.util.ArrayList;

public class Mesa {
    private ArrayList<Pedido> mesaPedidos = new ArrayList<>();
    public static int count=1;
    private int nMesa;
    private boolean ocupada=false;
    private int nOcupaciones=0;
    //GETTERS && SETTERS

    public int getnOcupaciones() {
        return nOcupaciones;
    }

    public void setnOcupaciones(int nOcupaciones) {
        this.nOcupaciones = nOcupaciones;
    }

    public ArrayList<Pedido> getMesaPedidos() {
        return mesaPedidos;
    }

    public void setMesaPedidos(ArrayList<Pedido> mesaPedidos) {
        this.mesaPedidos = mesaPedidos;
    }

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
            if(ocupada)
            {
                this.nOcupaciones++;
            }
            else
            {
                this.mesaPedidos.clear();
            }
        }
    }
    //CONSTRUCTOR
    public Mesa() {
        this.nMesa=count++;
        this.nOcupaciones=0;
    }
}