package restaurantes;

import java.util.*;

public class Restaurante {
    private HashSet<Mesa> mesas = new HashSet<>();
    private HashSet<Plato> platos = new HashSet<>();
    private ArrayList <Pedido> pedidos = new ArrayList<>();
    //GETTERS && SETTERS

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public HashSet<Mesa> getMesas() {
        return mesas;
    }

    public void setMesas(HashSet<Mesa> mesas) {
        this.mesas = mesas;
    }

    public HashSet<Plato> getPlatos() {
        return platos;
    }

    public void setPlatos(HashSet<Plato> platos) {
        this.platos = platos;
    }

    public void añadirPedido(){
        Scanner scanner = new Scanner(System.in);
        int mesa=0, cantidad=0, contAux=0;
        String plato="";
        HashMap<String, Integer> platosAux= new HashMap<>();

        System.out.println("Ingrese el numero de mesa");
        mesa=scanner.nextInt();
        mesa=comprobarMesa(mesa);
        if(mesa!=-1)
        {
            for(int i=1; i>0; contAux++)
            {
                System.out.println("(1) para añadir un plato al pedido y (-1) para salir");
                i=scanner.nextInt();
                if(i!=(-1))
                {
                    System.out.println("Ingresa una letra seguido de un espacio y el plato que desees seguido de la cantidad");
                    scanner.next();//tuve que hacer esto para que me tome el pedido de forma correcta
                    plato=scanner.nextLine();
                    plato=comprobarPlato(plato);
                    System.out.println("Ingresa la cantidad");
                    cantidad=scanner.nextInt();//8
                    while(cantidad<1)
                    {
                        System.out.println("El valor de cantidad debe ser mayor a 0, reingreselo.");
                        cantidad=scanner.nextInt();
                    }

                    for(Plato platoAux: this.platos)//agrega a plato.getVecesPedido la cantidad pedida
                    {
                        if(platoAux.getNombre().equals(plato))
                        {
                            platoAux.setVecesPedido(platoAux.getVecesPedido()+cantidad);
                        }
                    }
                    if(contAux==0 || platosAux.get(plato)==null)
                    {
                        platosAux.put(plato, cantidad);
                    }
                    else
                    {
                        platosAux.put(plato, cantidad + platosAux.get(plato));// Al dope

                    }
                }
                else
                {
                    Pedido pedido1= new Pedido(platosAux);
                    for(Mesa mesaAux: this.mesas)
                    {
                        if(mesaAux.getnMesa()==mesa)
                        {
                            mesaAux.getMesaPedidos().add(pedido1);
                        }
                    }
                    this.pedidos.add(pedido1);
                }
            }
        }
    }
    public int comprobarMesa(int mesa)
    {
        Scanner scanner=new Scanner(System.in);
        while(0==0)
        {
            int contador=0;
            boolean salir=false;
            for(Mesa mesaAux: this.mesas)
            {
                if(mesaAux.getnMesa()==mesa || contador==this.mesas.size()-1)
                {
                    if(mesaAux.isOcupada()==false)
                    {
                        System.out.println("La mesa esta vacia o no se ecuentra en el sistema, elija otra. Elija -1 si quiere salir");
                        mesa=scanner.nextInt();
                        if(mesa==-1)
                        {
                            salir=true;
                            break;
                        }
                    }
                    else
                    {
                        salir=true;
                        break;
                    }
                }
                else
                {
                    contador++;
                }
            }
            if(salir)
            {
                break;
            }
        }
        return mesa;
    }

    public String comprobarPlato(String plato)/*Arreglar para no tener que poner /*todo dos veces*/
    {
        Scanner scanner=new Scanner(System.in);
        while (0==0)
        {
            int contador=this.platos.size();
            for(Plato plato1: this.platos)
            {
                if(plato.equals(plato1.getNombre())==false)
                {
                    contador--;
                }
                else
                {
                    break;//ver si funciona
                }
            }
            if(contador==0)
            {
                System.out.println("El plato elegido no se ecuentra disponible, reingreselo.");
                plato=scanner.nextLine();
            }
            else
            {
                break;
            }
        }
        return plato;
    }
    public void platoMasPedido()
    {
        int contador=0;
        String platoGanador="";
        for(Plato plato:this.getPlatos())
        {
            if(plato.getVecesPedido()>=contador)
            {
                contador=plato.getVecesPedido();
                platoGanador=plato.getNombre();
            }

        }
        System.out.println(platoGanador+" veces pedido: "+contador);
    }
    public void platoMenosPedido()
    {
        int contador=0;
        String platoGanador="";
        for(Plato plato:this.getPlatos())
        {
            if(plato.getVecesPedido()<=contador)
            {
                contador=plato.getVecesPedido();
                platoGanador=plato.getNombre();
            }
        }
        System.out.println(platoGanador+" veces pedido: "+contador);
    }
    public void mesaMasOcupada()
    {
        int contador=0, mesaGanadora=0;
        for(Mesa mesa:this.getMesas())
        {
            if(mesa.getnOcupaciones()>=contador)
            {
                contador=mesa.getnOcupaciones();
                mesaGanadora=mesa.getnMesa();
            }

        }
        System.out.println(mesaGanadora+" veces pedido: "+contador);
    }
    public void entregarPedido()
    {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Ingresa el pedido entregado");
        int nPedido=scanner.nextInt();
        int contador=0;
        for(Pedido pedido: this.pedidos)
        {
            if(pedido.getnPedido()==nPedido)
            {
                if(pedido.isEntregado())
                {
                    System.out.println("Ya fue entregado");
                }
                else
                {
                    pedido.setEntregado(true);
                    System.out.println("Se entrego el pedido con exito");
                }
            }
            else
            {
                contador++;
            }
        }
        if(contador==this.pedidos.size())
        {
            System.out.println("No esta ese pedido en el sistema");
        }
    }
    public void proximoPedido()
    {
        for(Pedido pedido: this.pedidos)
        {
            if(pedido.isEntregado()==false)
            {
                System.out.println("El proximo pedido es el "+pedido.getnPedido());
                break;
            }
        }
    }
    public static void main(String [] args){
        Restaurante restaurante = new Restaurante();

        restaurante.getPlatos().add(new Plato("Milanesa con puré de papas", 0));
        restaurante.getPlatos().add(new Plato("Ravioles rellenos con carne", 0));
        restaurante.getPlatos().add(new Plato("Pizza a la Piedra", 0));
        restaurante.getPlatos().add(new Plato("Polenta con salsa Fileto", 0));
        restaurante.getPlatos().add(new Plato("Arroz primavera", 0));

        Mesa mesa1= new Mesa();
        Mesa mesa2= new Mesa();
        Mesa mesa3= new Mesa();
        Mesa mesa4= new Mesa();
        Mesa mesa5= new Mesa();
        Mesa mesa6= new Mesa();

        restaurante.getMesas().add(mesa1);
        restaurante.getMesas().add(mesa2);
        restaurante.getMesas().add(mesa3);
        restaurante.getMesas().add(mesa4);
        restaurante.getMesas().add(mesa5);
        restaurante.getMesas().add(mesa6);

        for(int i=0; i!=-1; i=i)
        {
            Scanner scanner=new Scanner(System.in);
            System.out.println("INGRESA (1) PARA OCUPAR UNA MESA, (2) DESOCUPAR UNA MESA, (3) HACER UN PEDIDO, (4) PLATO MAS PEDIDO, (5) PLATO MENOS PEDIDO");
            System.out.println("(6) MESA MAS OCUPADA, (7) ENTREGAR PEDIDO, (8) PROXIMO PEDIDO ,(9)VACIAR INFO PEDIDOS-PLATOS, (-1)SALIR");
            i=scanner.nextInt();
            switch (i)
            {
                case 1:
                    System.out.println("Ingrese la mesa a ocupar");
                    int mesa=scanner.nextInt();
                    int contador=0;
                    for(Mesa mesaAux: restaurante.getMesas())
                    {
                        if(mesaAux.getnMesa()==mesa)
                        {
                            mesaAux.setOcupada(true);
                        }
                        else
                        {
                            contador++;
                        }
                    }
                    if(contador==restaurante.getMesas().size())
                    {
                        System.out.println("La mesa no esta en el sistema");
                    }
                    break;
                case 2:
                    System.out.println("Ingrese la mesa a desocupar");
                    mesa=scanner.nextInt();
                    contador=0;
                    for(Mesa mesaAux: restaurante.getMesas())
                    {
                        if(mesaAux.getnMesa()==mesa)
                        {
                            mesaAux.setOcupada(false);
                        }
                        else
                        {
                            contador++;
                        }
                    }
                    if(contador==restaurante.getMesas().size())
                    {
                        System.out.println("La mesa no esta en el sistema");
                    }
                    break;
                case 3:
                    restaurante.añadirPedido();
                    break;
                case 4:
                    restaurante.platoMasPedido();
                    break;
                case 5:
                    restaurante.platoMenosPedido();
                    break;
                case 6:
                    restaurante.mesaMasOcupada();
                    break;
                case 7:
                    restaurante.entregarPedido();
                    break;
                case 8:
                    restaurante.proximoPedido();
                    break;
                case 9:
                    for(Plato plato:restaurante.getPlatos())
                    {
                        plato.setVecesPedido(0);
                    }
                    break;
            }
        }
    }
}
