package libreria;

import java.util.*;

public class Libreria {
    private String nombre;
    private ArrayList<Editorial> editoriales=new ArrayList<>();
    private ArrayList<Libro> libros= new ArrayList<>();
    private HashSet<Cliente> clientes=new HashSet<>();
    //GETTERS && SETTERS

    public HashSet<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(HashSet<Cliente> clientes) {
        this.clientes = clientes;
    }

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
    public void comprarLibro(Cliente cliente)
    {
        int cantidad=0;
        String nombreLibro="", nombreEditorial="";
        Scanner scanner= new Scanner(System.in);
        for(int i=0; i!=-1;i++)
        {
            System.out.println("INGRESA: EL NOMBRE DEL LIBRO QUE QUIERAS(1), LISTADO(2) o SALIR(-2).");
            i=scanner.nextInt();
            switch(i)
            {
                case 1:
                    elegirLibro(cantidad, nombreLibro, nombreEditorial, i, cliente);
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
        }
    }
    public void elegirLibro(int cantidad, String nombreLibro, String nombreEditorial, int i, Cliente cliente)
    {
        Scanner scanner=new Scanner(System.in);
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
        if(nombreEditorial != null && nombreLibro != null && cantidad != 0)
        {
            venta(cantidad, nombreLibro, nombreEditorial, cliente);
        }
    }
    public void venta(int cantidad, String nombreLibro, String nombreEditorial, Cliente cliente)
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
                        this.editoriales.get(x).getFacturas().add(new Factura(this.editoriales.get(x).getStock().get(nombreLibro)*this.editoriales.get(x).getDescuento(), new Date(), nombreLibro, cantidad, cliente.getApellido(), cliente.getDocumento()));
                        cliente.getCompras().add(new Factura(this.editoriales.get(x).getStock().get(nombreLibro)*this.editoriales.get(x).getDescuento(), new Date(), nombreLibro, cantidad, cliente.getApellido(), cliente.getDocumento()));/*probar*/
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
        int totalCantidad=0;
        float totalDinero=0;
        String nombreEditorial="";
        for(Editorial editorial: this.editoriales)
        {
            int auxCantidad=0;
            float auxDinero=0;
            for(Factura factura:editorial.getFacturas())
            {
                if(factura.getFecha().getDay()==new Date().getDay()&&factura.getFecha().getMonth()==new Date().getMonth()&&factura.getFecha().getYear()==new Date().getYear())
                {
                    auxCantidad=auxCantidad+factura.getCantidadLibros();
                    auxDinero=auxDinero+factura.getTotal();
                }
            }
            if(totalCantidad<auxCantidad)
            {
                nombreEditorial=editorial.getNombre();
                totalCantidad=auxCantidad;
                totalDinero=auxDinero;
            }
            System.out.println(editorial.getNombre()+" VENDIO: "+totalCantidad);
        }

        System.out.println("MAS VENTAS: "+nombreEditorial+" TOTAL VENTAS: "+totalCantidad+" TOTAL DINERO: "+totalDinero);
    }
    public boolean comprobarEditorial(String nombre)
    {
        for(Editorial editorial: this.editoriales)
        {
            if(editorial.getNombre().equals(nombre))
            {
                return true;
            }
        }
        return false;
    }
    public void agregarCliente()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el numero de documento");
        int doc=scanner.nextInt();
        boolean ok=true;
        int edad=0;
        String nombre="", apellido="";
        for(Cliente cliente:this.clientes)
        {
            if(doc==cliente.getDocumento())
            {
                System.out.println("Ya hay un cliente con ese documento");
                ok=false;
                break;
            }
        }
        if(ok)
        {
            System.out.println("Ingresa el nombre, apellido y edad. En ese orden");
            scanner.next();
            nombre=scanner.nextLine();//probar si funciona
            apellido=scanner.nextLine();//probar si funciona
            edad=scanner.nextInt();//probar si funciona
            this.clientes.add(new Cliente(nombre, apellido, edad, doc));
        }
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

        Cliente cliente1= new Cliente("Tomás", "Giménez", 17, 44550000);
        Cliente cliente2= new Cliente("Tiara", "Lopez", 20, 41000000);
        Cliente cliente3= new Cliente("Tatiana", "Semedo", 19, 43500000);
        Cliente cliente4= new Cliente("Taiel", "Benitez", 55, 24550000);

        libreria.editoriales.add(editorial1);
        libreria.editoriales.add(editorial2);
        libreria.editoriales.add(editorial3);
        libreria.editoriales.add(editorial4);
        libreria.editoriales.add(editorial5);
        libreria.editoriales.add(editorial6);
        libreria.editoriales.add(editorial7);

        libreria.getClientes().add(cliente1);
        libreria.getClientes().add(cliente2);
        libreria.getClientes().add(cliente3);
        libreria.getClientes().add(cliente4);

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
            System.out.println("COMPRAR(1), VENTAS DEL DIA (2), CAMBIAR DESCUENTO EDITORIAL(3), AGREGAR CLIENTE(4), FACTURAS CLIENTE(5) Y SALIR(0)");
            i=scanner.nextInt();
            switch(i)
            {
                case 1:
                    System.out.println("Ingrese el dni del cliente");
                    int doc=scanner.nextInt();
                    for(Cliente cliente: libreria.getClientes())
                    {
                        if(doc==cliente.getDocumento())
                        {
                            libreria.comprarLibro(cliente);
                        }
                    }
                    break;
                case 2:
                    for(int k=0; k<editorial1.getFacturas().size(); k++)
                    {
                        System.out.println(editorial1.getFacturas().get(k).getCantidadLibros()+" "+editorial1.getFacturas().get(k).getNombreLibro());
                    }
                    libreria.ventasDelDia();
                    break;
                case 3:
                    System.out.println("Ingrese el nombre de la editorial");
                    scanner.nextLine();
                    String nombreEditorial = scanner.nextLine();
                    if(libreria.comprobarEditorial(nombreEditorial))
                    {
                        System.out.println("Ingrese el descuento");
                        for(Editorial editorial: libreria.getEditoriales())
                        {
                            if(editorial.getNombre().equals(nombreEditorial))
                            {
                                float desc=scanner.nextFloat();
                                editorial.setDescuento(desc);
                            }
                        }
                    }
                    break;
                case 4:
                    libreria.agregarCliente();
                    break;
                case 5:
                    System.out.println("Ingrese el dni del cliente");
                    doc=scanner.nextInt();
                    for(Cliente cliente: libreria.getClientes())
                    {
                        if(doc==cliente.getDocumento())
                        {
                            for(Factura factura:cliente.getCompras())
                            {
                                System.out.println("FACTURA: "+factura.getnFactura());
                                System.out.println("FECHA: "+factura.getFecha());
                                System.out.println("LIBRO: "+factura.getNombreLibro()+" CANTIDAD: "+factura.getCantidadLibros());
                                System.out.println("IMPORTE: "+factura.getTotal());
                            }
                        }
                    }
                    break;
            }
        }
    }
}
