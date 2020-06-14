package libreria;

import java.util.Date;

public class Factura {
    private float total;
    public static int count=1;
    private int nFactura;
    private Date fecha;
    private String nombreLibro;
    private int cantidadLibros;
    private String apellidoCliente;
    private int documentoCliente;
    //GETTERS && SETTERS

    public int getDocumentoCliente() {
        return documentoCliente;
    }

    public void setDocumentoCliente(int documentoCliente) {
        this.documentoCliente = documentoCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public int getnFactura() {
        return nFactura;
    }

    public void setnFactura(int nFactura) {
        this.nFactura = nFactura;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNombreLibro() {
        return nombreLibro;
    }

    public void setNombreLibro(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }

    public int getCantidadLibros() {
        return cantidadLibros;
    }

    public void setCantidadLibros(int cantidadLibros) {
        this.cantidadLibros = cantidadLibros;
    }
    //CONSTRUCTOR
    public Factura(float precioLibro, Date fecha, String nombreLibro, int cantidadLibros, String apellidoCliente, int documentoCliente) {
        this.total = precioLibro*cantidadLibros;
        this.nFactura = count++;
        this.fecha = fecha;
        this.nombreLibro = nombreLibro;
        this.cantidadLibros = cantidadLibros;
        this.apellidoCliente = apellidoCliente;
        this.documentoCliente = documentoCliente;
    }
}
