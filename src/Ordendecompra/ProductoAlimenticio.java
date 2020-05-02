package Ordendecompra;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class ProductoAlimenticio {
    private String nombre;
    private float precio;
    private Date fechaELABORACION;
    private Date fechaVENCIMIENTO;
    private float pesoKG;
    //Getters and Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Date getFechaELABORACION() {
        return fechaELABORACION;
    }

    public void setFechaELABORACION(Date fechaELABORACION) {
        this.fechaELABORACION = fechaELABORACION;
    }

    public Date getFechaVENCIMIENTO() {
        return fechaVENCIMIENTO;
    }

    public void setFechaVENCIMIENTO(Date fechaVENCIMIENTO) {
        this.fechaVENCIMIENTO = fechaVENCIMIENTO;
    }

    public float getPesoKG() {
        return pesoKG;
    }

    public void setPesoKG(float pesoKG) {
        this.pesoKG = pesoKG;
    }
    //Constructor

    public ProductoAlimenticio(String nombre, float precio, float pesoKG, Date fechaELABORACION, Date fechaVENCIMIENTO) {
        this.fechaELABORACION = fechaELABORACION;
        this.fechaVENCIMIENTO=fechaVENCIMIENTO;
        this.nombre=nombre;
        this.pesoKG=pesoKG;
        this.precio=precio;
    }

    //metodos
    public boolean pesoMasQue5(ProductoAlimenticio producto)
    {
        boolean masQue5=true;
        if(producto.pesoKG<5){
            masQue5=false;
        }
        return masQue5;
    }
    public void verificarVencimiento(ProductoAlimenticio producto)
    {
        Long datediff=dateDiff(producto.fechaELABORACION, new Date());
        if(datediff<0)
        {
            System.out.println("Esta vencido");
        }
    }
    public String formatearFecha(Date fechaIngreso)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("d-MMM-yyyy");
        String formatearDate=sdf.format(fechaIngreso);
        return formatearDate;
    }
    public Long dateDiff(Date fechaIngreso, Date fechaEgreso)
    {
        String date1, date2;
        DateTimeFormatter df = DateTimeFormatter.ofPattern("d-MMM-yyyy");
        date1=formatearFecha(fechaIngreso);
        date2 = formatearFecha(fechaEgreso);
        LocalDate d1 = LocalDate.parse(date1, df);
        LocalDate  d2 = LocalDate.parse(date2, df);
        Long datediff = ChronoUnit.DAYS.between(d1,d2);
        return datediff;
    }
}
