package libreria;

import java.util.*;

public class Libreria {
    private String nombre;
    private ArrayList<Editorial> editoriales=new ArrayList<>();
    private ArrayList<Libro> libros= new ArrayList<>();
    //GETTERS && SETTERS

    public ArrayList<Editorial> getEditoriales() {
        return editoriales;
    }

    public void setEditoriales(ArrayList<Editorial> editoriales) {
        this.editoriales = editoriales;
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }

    public void setLibros(ArrayList<Libro> libros) {
        this.libros = libros;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    //CONSTRUCTOR

    public Libreria(String nombre) {
        this.nombre = nombre;
    }

    //METODOS
    public void comprarLibro()
    {
        int cantidad=0;
        String nombreLibro="";
        String nombreEditorial="";
        Scanner scanner= new Scanner(System.in);
        for(int i=0; i!=-1;i++)
        {
            System.out.println("INGRESA: EL NOMBRE DEL LIBRO QUE QUIERAS(1), LISTADO(2) o SALIR(-2).");
            i=scanner.nextInt();
            switch(i)
            {
                case 1:
                    boolean libroElegido=false, editorialElegida=false;
                    for(int x=0; x!=-1; x++)
                    {
                        System.out.println("NOMBRE LIBRO: ");
                        nombreLibro=scanner.next();
                        for(Libro libro: this.libros)
                        {
                            if(nombreLibro.equals(libro.getNombre()))
                            {
                                libroElegido=true;
                                System.out.println("NOMBRE EDITORIAL: ");
                                nombreEditorial=scanner.next();
                                for(Editorial editorial: this.editoriales)
                                {
                                    if(nombreEditorial.equals(editorial.getNombre()) && editorial.getStock().containsKey(nombreLibro))
                                    {
                                        editorialElegida=true;
                                        System.out.println("CANTIDAD(si queres volver(0)):");
                                        cantidad=scanner.nextInt();
                                        while(cantidad<1)
                                        {
                                            if(cantidad==0)
                                            {
                                                x=-2;
                                                i=-2;
                                            }
                                            else
                                            {
                                                System.out.println("CANTIDAD:");
                                                cantidad=scanner.nextInt();
                                            }
                                        }
                                    }
                                }
                                if(editorialElegida==false)
                                {
                                    System.out.println("Esa editorial no tiene el libro, (0) Listado, (1) para elegir otra editorial y (2) para salir");
                                    int k=scanner.nextInt();
                                    if(k==2)
                                    {
                                        x=-2;
                                        i=-2;
                                    }
                                    else if(k==0)
                                    {
                                        i=1;
                                        x=-2;
                                    }
                                }
                            }
                        }
                        if(libroElegido==false)
                        {
                            System.out.println("No tenemos ese libro, (1) para elegir otro y (2) para salir");
                            int k=scanner.nextInt();
                            if(k==2)
                            {
                                x=-2;
                                i=-2;
                            }
                        }
                        if(libroElegido==true && editorialElegida==true && cantidad>0)
                        {
                            x=-2;
                            i=-2;
                        }
                    }
                    break;
                case 2:
                    for(int x=0; x<this.editoriales.size(); x++)
                    {
                        System.out.println(this.editoriales.get(x).getNombre());
                        for(Map.Entry<String, Float> editorialAux: this.editoriales.get(x).getStock().entrySet())
                        {
                            System.out.println(editorialAux);
                        }
                    }
                    break;
            }
            if(nombreEditorial != null && nombreLibro != null && cantidad != 0)
            {
                venta(cantidad, nombreLibro, nombreEditorial);
            }
        }
    }
    public void venta(int cantidad, String nombreLibro, String nombreEditorial)
    {
        for(int x=0; x<this.editoriales.size(); x++)
        {
            if(this.editoriales.get(x).getNombre().equals(nombreEditorial))
            {
                for(Map.Entry librosvendidos:this.editoriales.get(x).getStock().entrySet())
                {
                    if (librosvendidos.getKey().equals(nombreLibro))
                    {
                        this.editoriales.get(x).getLibrosVendidos().replace(nombreLibro, cantidad + this.editoriales.get(x).getLibrosVendidos().get(nombreLibro));
                        this.editoriales.get(x).getFacturas().add(new Factura(this.editoriales.get(x).getStock().get(nombreLibro), new Date(), nombreLibro, cantidad));
                    }
                }
            }
        }
    }
    public void rellenarLibrosVendidos()
    {
        int contador=0;
        for(int x=0; x<this.editoriales.size(); x++)
        {
                for(Map.Entry stockEditorial:this.editoriales.get(x).getStock().entrySet())
                {
                    for(Map.Entry ventasEditorial:this.editoriales.get(x).getLibrosVendidos().entrySet())
                    {
                        if(stockEditorial.getKey() != ventasEditorial.getKey())
                        {
                            contador++;
                        }
                    }
                    if(contador==this.editoriales.get(x).getLibrosVendidos().size())
                    {
                        this.editoriales.get(x).getLibrosVendidos().put(stockEditorial.getKey().toString(), 0);
                    }
                    contador=0;
                }
        }
    }
    public void ventasDelDia()
    {
        int total=0;
        String nombreEditorial="";
        for(Editorial editorial: this.editoriales)
        {
            int aux=0;
            for(Factura factura:editorial.getFacturas())
            {
                if(factura.getFecha().getDay()==new Date().getDay()&&factura.getFecha().getMonth()==new Date().getMonth()&&factura.getFecha().getYear()==new Date().getYear())
                {
                    aux=aux+factura.getCantidadLibros();
                }
            }
            if(total<aux)
            {
                nombreEditorial=editorial.getNombre();
                total=aux;
            }
            System.out.println(editorial.getNombre()+" VENDIO: "+aux);
        }
        System.out.println("MAS VENTAS: "+nombreEditorial);
    }
    public static void main(String [] args)
    {
        Libreria libreria=new Libreria("Yenny");

        Libro libro1=new Libro("Hola", 100);
        Libro libro2=new Libro("Polo", 1235);
        Libro libro3=new Libro("Pila", 100);
        Libro libro4=new Libro("Lazo", 142);
        Libro libro5=new Libro("Jorda", 100);

        libreria.libros.add(libro1);
        libreria.libros.add(libro2);
        libreria.libros.add(libro3);
        libreria.libros.add(libro4);
        libreria.libros.add(libro5);

        Editorial editorial1= new Editorial("Kapelusz");
        Editorial editorial2= new Editorial("Sudamericana");
        Editorial editorial3= new Editorial("Atlántida");
        Editorial editorial4= new Editorial("ElAteneo");
        Editorial editorial5= new Editorial("Interzona");
        Editorial editorial6= new Editorial("Sur");
        Editorial editorial7= new Editorial("Alianza");

        libreria.editoriales.add(editorial1);
        libreria.editoriales.add(editorial2);
        libreria.editoriales.add(editorial3);
        libreria.editoriales.add(editorial4);
        libreria.editoriales.add(editorial5);
        libreria.editoriales.add(editorial6);
        libreria.editoriales.add(editorial7);

        editorial1.getStock().put(libro1.getNombre(), libro1.getPrecio());
        editorial1.getStock().put(libro2.getNombre(), libro2.getPrecio());
        editorial1.getStock().put(libro3.getNombre(), libro3.getPrecio());
        editorial2.getStock().put(libro4.getNombre(), libro4.getPrecio());
        editorial5.getStock().put(libro4.getNombre(), libro4.getPrecio());
        editorial5.getStock().put(libro5.getNombre(), libro5.getPrecio());
        editorial6.getStock().put(libro1.getNombre(), libro1.getPrecio());

        Scanner scanner= new Scanner(System.in);
        libreria.rellenarLibrosVendidos();
        for(int i=1;i!=0; i=i)
        {
            System.out.println("COMPRAR(1), VENTAS DEL DIA (2) Y SALIR(0)");
            i=scanner.nextInt();
            switch(i)
            {
                case 1:
                    libreria.comprarLibro();
                    break;
                case 2:
                    for(int k=0; k<editorial1.getFacturas().size(); k++)
                    {
                        System.out.println(editorial1.getFacturas().get(k).getCantidadLibros()+" "+editorial1.getFacturas().get(k).getNombreLibro());
                    }
                    libreria.ventasDelDia();
                    break;
            }
        }
    }
}
