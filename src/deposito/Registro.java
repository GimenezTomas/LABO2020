package deposito;

import ordendecompra.ProductoAlimenticio;

import java.util.ArrayList;
import java.util.Date;

public class Registro {
    private Date fechaIngreso;
    private Date fechaEgreso;
    private ProductoAlimenticio producto;
//Getters y Setters
    public ProductoAlimenticio getProducto() {
        return producto;
    }

    public void setProducto(ProductoAlimenticio producto) {
        this.producto = producto;
    }

    public Date getFechaEgreso() {
        return fechaEgreso;
    }

    public void setFechaEgreso(Date fechaEgreso, ArrayList<Registro> registro)
    {
        this.fechaEgreso = fechaEgreso;
        for (int i=0; i<registro.size(); i++)
        {
            if(registro.get(i).getFechaEgreso()==this.fechaEgreso)
            {
                registro.remove(i);
            }
        }
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    // constructor

    public Registro(ProductoAlimenticio producto, Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
        this.producto=producto;
    }
}
