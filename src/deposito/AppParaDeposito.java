package deposito;

import ordendecompra.ProductoAlimenticio;

import java.util.ArrayList;
import java.util.Date;

public class AppParaDeposito {
    public void valorTotalProductos(ArrayList<Registro> registroArray)
    {
        float total=0;
        for (Registro i: registroArray) {
            if(i.getFechaEgreso()==null)
            {
                total= total +i.getProducto().getPrecio();
            }
        }
        System.out.println("VALOR TOTAL: "+total);

    }
    public void productosSinStock(ArrayList<Registro> registroArray, ArrayList<ProductoAlimenticio> productos)
    {
        ArrayList<ProductoAlimenticio> productosSinStock=new ArrayList<>();
        int contador=0;
        ProductoAlimenticio productoAUX= new ProductoAlimenticio(null, 0, 0, new Date(120,1,1), new Date (120,9,4));
        for(ProductoAlimenticio j: productos)
        {
            for (Registro i: registroArray)
            {
                if(j.getNombre()!=i.getProducto().getNombre())
                {
                    contador++;
                    productoAUX=j;
                }
            }
            if(contador==productos.size()-1)
            {
                productosSinStock.add(productoAUX);
            }
        }
        System.out.println("PRODUCTOS SIN STOCK: ");
        for(ProductoAlimenticio i: productosSinStock)
        {
            System.out.println("Producto: "+i.getNombre());
        }
    }
    public void stockPorNombre(ArrayList<Registro> registroArray, ProductoAlimenticio producto)
    {
        int contador=0;
        for (Registro i: registroArray)
        {
            if(producto.getNombre()==i.getProducto().getNombre())
            {
                contador++;
            }
        }
        System.out.println("Stock: "+contador);
    }
    public void stockMasDe15(ArrayList<Registro> registroArray, ArrayList<ProductoAlimenticio> productos)
    {
        ArrayList<ProductoAlimenticio> stockMasDe15=new ArrayList<>();
        int contador=0;
        ProductoAlimenticio productoAUX= new ProductoAlimenticio(null, 0, 0, new Date(120,1,1), new Date (120,9,4));
        for(ProductoAlimenticio j: productos)
        {
            for (Registro i: registroArray)
            {
                if(j.getNombre()!=i.getProducto().getNombre())
                {
                    contador++;
                    productoAUX=j;
                }
            }
            if(contador>15)
            {
                stockMasDe15.add(productoAUX);
            }
        }
        System.out.println("PRODUCTOS STOCK > 15: ");
        for(ProductoAlimenticio i: stockMasDe15)
        {
            System.out.println("Producto: "+i.getNombre());
        }
    }
    /*Realizar el registro de productos que ingresan y egresan
    Imprimir el valor monetario equivalente al stock presente en el depósito. (tener en cuenta que el ingreso y egreso de productos modificarán tal monto)
    Imprimir cuáles son los productos sin stock.
    Imprimir cuál es el stock actual de algún producto según el nombre.
    Imprimir cuáles son los productos que tienen menos de 15 unidades.
    Comentarios:*/
    public static void main(String [] args)
    {
        AppParaDeposito app01=new AppParaDeposito();

        ArrayList <ProductoAlimenticio> productos= new ArrayList<>();

        ProductoAlimenticio producto01= new ProductoAlimenticio("Leche", 100, 1, new Date(120,1,1), new Date (120,9,4));
        productos.add(producto01);

        ArrayList<Registro> registroArray= new ArrayList<>();

        Registro registro1= new Registro(producto01, new Date(120,3,1));
        registroArray.add(registro1);

        app01.valorTotalProductos(registroArray);
        app01.productosSinStock(registroArray, productos);
        app01.stockPorNombre(registroArray,producto01);
        app01.stockMasDe15(registroArray, productos);
/* corregir: por cada fecha de ingreso seteada borrar el producto del registroArray, crear un array de productos,
 en el de sin stock comparar los productos que hay en el arreglo productos con los que hay en el arreglo de
 registros*/

    }
}
