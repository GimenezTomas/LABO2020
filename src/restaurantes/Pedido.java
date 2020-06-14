package restaurantes;

import java.util.HashMap;

public class Pedido {
    private HashMap<String, Integer> platos = new HashMap<>();
    public static int count=1;
    private int nPedido;
    private boolean entregado=false;
    //GETTERS && SETTERS

    public boolean isEntregado() {
        return entregado;
    }

    public void setEntregado(boolean entregado) {
        this.entregado = entregado;
    }

    public HashMap<String, Integer> getPlatos() {
        return platos;
    }

    public void setPlatos(HashMap<String, Integer> platos) {
        this.platos = platos;
    }

    public int getnPedido() {
        return nPedido;
    }

    public void setnPedido(int nPedido) {
        this.nPedido = nPedido;
    }
    //CONSTRUCTOR
    public Pedido(HashMap<String, Integer> platos) {
        this.platos = platos;
        this.nPedido = count++;
    }
}
