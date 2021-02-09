package hotel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Hotel {
    private ArrayList<Habitaciones> habitaciones= new ArrayList<>();
    private ArrayList<Huesped> huespedes = new ArrayList<>();
    private ArrayList<Reserva> reservas = new ArrayList<>();
    private JFrame ventana;
    private JPanel panelPrincipal;
    //GETTERS && SETTERS

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    public void setPanelPrincipal(JPanel panelPrincipal) {
        this.panelPrincipal = panelPrincipal;
    }

    public ArrayList<Huesped> getHuespedes() {
        return huespedes;
    }

    public void setHuespedes(ArrayList<Huesped> huespedes) {
        this.huespedes = huespedes;
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }

    public JFrame getVentana() {
        return ventana;
    }

    public void setVentana(JFrame ventana) {
        this.ventana = ventana;
    }

    public ArrayList<Habitaciones> getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(ArrayList<Habitaciones> habitacionesArreglo) {
        this.habitaciones = habitacionesArreglo;
    }
    //CONSTRUCTOR
    public Hotel(int ventanaWidth, int ventanaHeight, String title) {
        this.ventana = new JFrame(title);
        this.ventana.setLayout(null);
        this.ventana.setSize(ventanaWidth, ventanaHeight);
        this.ventana.setVisible(true);
        this.ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.panelPrincipal = new JPanel();
        this.panelPrincipal.setSize(this.ventana.getSize());
        this.panelPrincipal.setName("Panel");
        this.panelPrincipal.setLayout(/*new BorderLayout()*/null);
        this.panelPrincipal.setVisible(true);
        this.ventana.add(panelPrincipal);
    }
     /*public void top6HuespedesMasFrecuentes(ArrayList<Huesped> listaHuespedes, ArrayList<Reserva> reservas) {
         ArrayList<Reserva> copiaReserva = (ArrayList<Reserva>) reservas.clone();
         ArrayList<Integer> top6 = new ArrayList<>();
         ArrayList<Integer> ganadora = new ArrayList<Integer>();
         ArrayList<Huesped> huespedesClon = (ArrayList<Huesped>) listaHuespedes.clone();
         ganadora.add(0);//guardo la cantidad de veces que se repite el id AUX(contadorAUX)
         ganadora.add(0);//guardo el id AUX
         ganadora.add(0);//guardo la cantidad de veces que se repite el id para que el otro se pueda reiniciar(CONTADOR)
         ganadora.add(0);//guardo el id para que se pueda reiniciar
         ganadora.add(0);//guardo indice de huespedes clon(aux)
         ganadora.add(0);//guardo indice de huespedes clon
         for (int x = 0; x < 7; x++) {
             if (x > 0) {
                 top6.add(ganadora.get(3));
                 huespedesClon.remove(huespedesClon.get(ganadora.get(5)));
             }
             ganadora.set(2, 0);
             ganadora.set(3, 0);
             ganadora.set(4,0);
             ganadora.set(5,0);
             ganadora.set(1,0);
             ganadora.set(0,0);
             for (Huesped z : huespedesClon) {

                 if (ganadora.get(2) < ganadora.get(0)) {
                     ganadora.set(3, ganadora.get(1));
                     ganadora.set(2, ganadora.get(0));
                     ganadora.set(5, ganadora.get(4));
                 }
                else if(ganadora.get(2) == ganadora.get(0) && ganadora.get(0)==1)
                 {
                     ganadora.set(5, 0);
                 }
                 ganadora.set(0, 0);
                 ganadora.set(1,0);

                 for (Reserva j : reservas) {
                     if (z.getNumeroDeHuesped() == j.getNumeroHuesped()) {
                         System.out.println("z.getNumeroDeHuesped(): "+z.getNumeroDeHuesped()+" = j.getNumeroHuesped(): "+j.getNumeroHuesped());
                         ganadora.set(0, ganadora.get(0) + 1);
                         ganadora.set(1, z.getNumeroDeHuesped());
                         ganadora.set(4, z.getNumeroDeHuesped()-1);
                     }
                 }
             }
         }
         for (int i = 0; i < 6; i++) {
             System.out.println(i+1 + ") Huesped: " + top6.get(i));
         }
     }*/
    public boolean descSIoNO ( Reserva reserva01)
    {
        Long datediff = dateDiff(reserva01.getFechaIngreso(),reserva01.getFechaEgreso());
        if(datediff>30) {
            reserva01.setDescuento(true);
            aplicarDescuento(reserva01);
        }
        return reserva01.isDescuento();

    }
    public String formatearFecha(Date fechaIngreso)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("d-MMM-yyyy");
        String formatearDate=sdf.format(fechaIngreso);
        return formatearDate;
    }
    public void aplicarDescuento(Reserva reserva01)
    {
        reserva01.getHabitacion().setPrecio(reserva01.getHabitacion().getPrecio()-reserva01.getHabitacion().getPrecio()/4);
    }

    public void top3HabitacionesMasSolicitadas( ArrayList<Habitaciones> habitaciones, ArrayList <Reserva> reservas)
    {
        ArrayList<Reserva> copiaReserva = (ArrayList<Reserva>) reservas.clone();
        ArrayList<Integer> top6 = new ArrayList<>();
        ArrayList<Integer> ganadora = new ArrayList<Integer>();
        ArrayList<Habitaciones> habitacionesClon = (ArrayList<Habitaciones>) habitaciones.clone();
        ganadora.add(0);//guardo la cantidad de veces que se repite el id(AUX)
        ganadora.add(0);//guardo el id(AUX)
        ganadora.add(0);//guardo la cantidad de veces que se repite el id para que el otro se pueda reiniciar
        ganadora.add(0);//guardo el id para que se pueda reiniciar
        ganadora.add(0);//guardo z(aux)
        ganadora.add(0);//guardo z
        for (int x = 0; x < 4; x++) {
            if (x > 0) {
                top6.add(ganadora.get(3));
                habitacionesClon.remove(habitacionesClon.get(ganadora.get(5)));
            }
            ganadora.set(2, 0);
            ganadora.set(3, 0);
            ganadora.set(4,0);
            ganadora.set(5, 0);
            ganadora.set(1,0);
            ganadora.set(0,0);
            for (Habitaciones z : habitacionesClon) {

                if (ganadora.get(2) < ganadora.get(0)) {
                    ganadora.set(3, ganadora.get(1));
                    ganadora.set(2, ganadora.get(0));
                    ganadora.set(5, ganadora.get(4));
                }
                else if(ganadora.get(2)==ganadora.get(0)&&ganadora.get(0)==0)
                {
                    ganadora.set(5,0);
                }
                ganadora.set(0, 0);
                ganadora.set(1,0);

                for (int j = 0; j < reservas.size(); j++) {
                    if (z.getNumeroDeHabitacion() == reservas.get(j).getNumHabitacion()) {
                        ganadora.set(0, ganadora.get(0) + 1);
                        ganadora.set(1, z.getNumeroDeHabitacion());
                        ganadora.set(4, z.getNumeroDeHabitacion()-1);
                    }
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            System.out.println(i+1 + ") HABITACION: " + top6.get(i));
        }
    }
    public void fechaEntradaYSalida(Reserva reserva)
    {
        System.out.println("HUESPED"+reserva.getNumeroHuesped()+" FECHA DE ENTRADA: "+reserva.getFechaIngreso()+" FECHA DE SALIDA: "+reserva.getFechaEgreso());
    }
    public void ingresoTotal(ArrayList<Reserva> reservas) {
        float ingresototal = 0;
        Date dt= new Date();
        String date1, date2;
        DateTimeFormatter df = DateTimeFormatter.ofPattern("d-MMM-yyyy");
        for(Reserva x:reservas)
        {
            date1=formatearFecha(x.getFechaIngreso());
            if(x.getFechaEgreso()==null) {
                date2 = formatearFecha(dt);
            }
            else {
                date2 = formatearFecha(x.getFechaEgreso());
            }
            LocalDate  d1 = LocalDate.parse(date1, df);
            LocalDate  d2 = LocalDate.parse(date2, df);
            Long datediff = ChronoUnit.DAYS.between(d1,d2);
            ingresototal=ingresototal+datediff*x.getHabitacion().getPrecio();
        }
        System.out.println("INGRESO TOTAL: "+ingresototal);
    }
    public void estadiaProlongada (ArrayList<Reserva> reservasNOCLON)
    {
        ArrayList<Reserva> reservas= new ArrayList<>();
        int contador=0;
        ArrayList<Integer> huespedesEstadiaProlongada= new ArrayList<Integer>();
        for(int i=reservasNOCLON.size(); i>0 ; i--)
        {
            contador=0;
            if (reservas.size()==0)
            {
                contador++;
            }
            else{
                for(Reserva j: reservas)
                {
                    if(reservasNOCLON.get(i-1).getNumeroHuesped()!=j.getNumeroHuesped())
                    {
                        contador++;
                    }
                }
            }
            if(contador>=reservas.size())
            {
                reservas.add(reservasNOCLON.get(i-1));
            }
        }
        for(Reserva i : reservas)
        {
                contador=0;
                DateTimeFormatter df = DateTimeFormatter.ofPattern("d-MMM-yyyy");
                Date dt = new Date();
                String date1 = formatearFecha(i.getFechaIngreso());
                String date2;
                if(i.getFechaEgreso()==null) {
                    date2 = formatearFecha(dt);
                }
                else {
                    date2 = formatearFecha(i.getFechaEgreso());
                }
                LocalDate d1 = LocalDate.parse(date1, df);
                LocalDate d2 = LocalDate.parse(date2, df);
                Long datediff = ChronoUnit.DAYS.between(d1, d2);
                if (datediff > 30) {
                    if(huespedesEstadiaProlongada.size()==0)
                    {
                        huespedesEstadiaProlongada.add(i.getNumeroHuesped());
                    }
                    else
                    {
                        for (Integer h : huespedesEstadiaProlongada) {
                            if (i.getNumeroHuesped() != h+1) {
                                contador++;
                            }
                        }
                        if (contador == huespedesEstadiaProlongada.size() ) {
                            huespedesEstadiaProlongada.add(i.getNumeroHuesped());
                        }
                    }
                }
        }
        for(Integer i:huespedesEstadiaProlongada)
        {

            System.out.println(i+") HUESPED: "+ i);
        }
    }
    public void habitacionesOcupadas(ArrayList<Habitaciones> habitaciones, ArrayList<Reserva> reservasNOCLON)
    {
        int contador;
        ArrayList<Integer> habitacionesOcupadas= new ArrayList<>();
        ArrayList<Reserva> reservas=new ArrayList<Reserva>();
        for(int i=reservasNOCLON.size(); i>0 ; i--)
        {
            contador=0;
            if (reservas.size()==0)
            {
                contador++;
            }
            else{
                for(int j=0; j<reservas.size(); j++)
                {
                    if(reservasNOCLON.get(i-1).getNumHabitacion()!=reservas.get(j).getNumHabitacion())
                    {
                        contador++;
                    }
                }
            }
            if(contador>=reservas.size())
            {
                reservas.add(reservasNOCLON.get(i-1));
            }
        }
        for(int i=0; i<reservas.size(); i++)
        {
            Long datediff = dateDiff(new Date(),reservas.get(i).getFechaEgreso());
            if (datediff>=0)
            {
                habitacionesOcupadas.add(reservas.get(i).getNumHabitacion());
            }
        }
        for(int i=0; i<habitacionesOcupadas.size(); i++) {
            System.out.println("NUMERO DE HABITACION OCUPADA: "+habitacionesOcupadas.get(i));
        }
    }
    public void habitacionesDesocupadas(ArrayList<Habitaciones> habitaciones, ArrayList<Reserva> reservasNOCLON)
    {
        int contador;
        Date currentDate= new Date();
        ArrayList<Integer> habitacionesOcupadas= new ArrayList<>();
        ArrayList<Reserva> reservas=new ArrayList<Reserva>();
        for(int i=reservasNOCLON.size(); i>0 ; i--)
        {
            contador=0;
            if (reservas.size()==0)
            {
                contador++;
            }
            else{
                for(int j=0; j<reservas.size(); j++)
                {
                    if(reservasNOCLON.get(i-1).getNumHabitacion()!=reservas.get(j).getNumHabitacion())
                    {
                        contador++;
                    }
                }
            }
            if(contador>=reservas.size())
            {
                reservas.add(reservasNOCLON.get(i-1));
            }
        }
        for(int i=0; i<reservas.size(); i++)
        {
            Long datediff = dateDiff(currentDate,reservas.get(i).getFechaEgreso());
            if (datediff<0)
            {
                habitacionesOcupadas.add(reservas.get(i).getNumHabitacion());
            }
        }
        for (int i=0; i<habitaciones.size();i++)
        {
            if(habitaciones.get(i).isOcupada()==false)
            {
                habitacionesOcupadas.add(habitaciones.get(i).getNumeroDeHabitacion());
            }
        }
        for(int i=0; i<habitacionesOcupadas.size(); i++) {
            System.out.println("NUMERO DE HABITACION DESOCUPADA: "+habitacionesOcupadas.get(i));
        }
    }
    public void mostrarHuespedYSuHabitacion(ArrayList<Reserva> reservasNOCLON)
    {
        ArrayList<Reserva> reservas= new ArrayList<>();
        int contador=0;
        for(int i=reservasNOCLON.size(); i>0 ; i--)
        {
            contador=0;
            if (reservas.size()==0)
            {
                contador++;
            }
            else{
                for(Reserva j:reservas)
                {
                    if(reservasNOCLON.get(i-1).getNumeroHuesped()!=j.getNumeroHuesped())
                    {
                        contador++;
                    }
                }
            }
            if(contador>=reservas.size())
            {
                reservas.add(reservasNOCLON.get(i-1));
            }
        }
        for(Reserva i : reservas)
        {
            System.out.println("HABITACION: "+i.getNumHabitacion()+" HUESPED: "+i.getNumeroHuesped());
        }
    }
    public void cantidadTiempoPorReserva(ArrayList<Reserva> reservas) {
        for (Reserva i : reservas) {
            Long datediff = dateDiff(i.getFechaIngreso(),i.getFechaEgreso());
            System.out.println("HUESPED: "+i.getNumeroHuesped()+" SE QUEDO "+datediff+" DIAS");
        }
    }
    public void importeAPagarxHuespd(ArrayList<Reserva> reservas)
    {
        float ingresototal = 0;
        Long datediff;
        for(Reserva x : reservas)
        {
            datediff=dateDiff(x.getFechaIngreso(),x.getFechaEgreso());
            System.out.println("MONTO TOTAL: "+datediff*x.getHabitacion().getPrecio()+"HUESPED: "+ x.getNumeroHuesped());
        }
    }
    public Reserva elegirLaReserva(ArrayList<Reserva> reservas)
    {
        Scanner scanner= new Scanner(System.in);
        System.out.println("ELIJA EL NUMERO DE RESERVA");
        int nReserva=-1;
        while (nReserva<0 || nReserva>=reservas.size())
        {
            nReserva=scanner.nextInt();
        }
        for(Reserva j: reservas)
        {
            if(j.getNumeroReserva()==nReserva)
            {
                return j;
            }
        }
        return reservas.get(nReserva);
    }
    public Long dateDiff(Date fechaIngreso, Date fechaEgreso)
    {
        float ingresototal = 0;
        String date1, date2;
        DateTimeFormatter df = DateTimeFormatter.ofPattern("d-MMM-yyyy");
            date1=formatearFecha(fechaIngreso);
            date2 = formatearFecha(fechaEgreso);
        LocalDate  d1 = LocalDate.parse(date1, df);
            LocalDate  d2 = LocalDate.parse(date2, df);
            Long datediff = ChronoUnit.DAYS.between(d1,d2);
        return datediff;
    }
    /*public void top6Huespedes(){
        JPanel feedBack = new JPanel();
        feedBack.setSize(this.ventana.getSize());

        ArrayList<Reserva> copiaReserva = (ArrayList<Reserva>) reservas.clone();
        ArrayList<Integer> top6 = new ArrayList<>();
        ArrayList<Integer> ganadora = new ArrayList<Integer>();
        ArrayList<Huesped> huespedesClon = (ArrayList<Huesped>) listaHuespedes.clone();
        ganadora.add(0);//guardo la cantidad de veces que se repite el id AUX(contadorAUX)
        ganadora.add(0);//guardo el id AUX
        ganadora.add(0);//guardo la cantidad de veces que se repite el id para que el otro se pueda reiniciar(CONTADOR)
        ganadora.add(0);//guardo el id para que se pueda reiniciar
        ganadora.add(0);//guardo indice de huespedes clon(aux)
        ganadora.add(0);//guardo indice de huespedes clon
        for (int x = 0; x < 7; x++) {
            if (x > 0) {
                top6.add(ganadora.get(3));
                huespedesClon.remove(huespedesClon.get(ganadora.get(5)));
            }
            ganadora.set(2, 0);
            ganadora.set(3, 0);
            ganadora.set(4,0);
            ganadora.set(5,0);
            ganadora.set(1,0);
            ganadora.set(0,0);
            for (Huesped z : huespedesClon) {

                if (ganadora.get(2) < ganadora.get(0)) {
                    ganadora.set(3, ganadora.get(1));
                    ganadora.set(2, ganadora.get(0));
                    ganadora.set(5, ganadora.get(4));
                }
                else if(ganadora.get(2) == ganadora.get(0) && ganadora.get(0)==1)
                {
                    ganadora.set(5, 0);
                }
                ganadora.set(0, 0);
                ganadora.set(1,0);

                for (Reserva j : reservas) {
                    if (z.getNumeroDeHuesped() == j.getNumeroHuesped()) {
                        System.out.println("z.getNumeroDeHuesped(): "+z.getNumeroDeHuesped()+" = j.getNumeroHuesped(): "+j.getNumeroHuesped());
                        ganadora.set(0, ganadora.get(0) + 1);
                        ganadora.set(1, z.getNumeroDeHuesped());
                        ganadora.set(4, z.getNumeroDeHuesped()-1);
                    }
                }
            }
        }
        for (int i = 0; i < 6; i++) {
            System.out.println(i+1 + ") Huesped: " + top6.get(i));
        }
    }*/

    public void armarMenuPrincipal(){
        JMenuBar menuBarVentana = new JMenuBar();
        this.ventana.setJMenuBar(menuBarVentana);

        JMenu menuHuesped = new JMenu("HUESPED");
        menuHuesped.setName("menuHuesped");
        //menuHuesped.setMenuLocation(ventana.getWidth()/4-menuHuesped.getWidth()/2, menuHuesped.getY());
        menuBarVentana.add(menuHuesped);

        JMenu menuHabitaciones = new JMenu("HABITACIONES");
        menuHabitaciones.setName("menuHabitaciones");
        menuBarVentana.add(menuHabitaciones);

        JMenu menuReserva = new JMenu("RESERVAS");
        menuReserva.setName("menuReservas");
        menuBarVentana.add(menuReserva);

        JMenu menuImportes = new JMenu("IMPORTES");
        menuImportes.setName("menuImportes");
        menuBarVentana.add(menuImportes);

        JMenuItem item6HuespedesMasFrecuentes = new JMenuItem("6 Huespedes mas frecuentes");
        item6HuespedesMasFrecuentes.setName("item6HuespedesMasFrecuentes");
        menuHuesped.add(item6HuespedesMasFrecuentes);

        JMenuItem itemHuespedConDescuento = new JMenuItem("Huesped con descuento");
        itemHuespedConDescuento.setName("itemHuespedConDescuento");
        menuHuesped.add(itemHuespedConDescuento);

        JMenuItem itemHuespedesEstadiaProlongada = new JMenuItem("Huespedes con estadia prolongada");
        itemHuespedesEstadiaProlongada.setName("itemHuespedesEstadiaProlongada");
        menuHuesped.add(itemHuespedesEstadiaProlongada);

        JMenuItem itemPlanillaHabitaciones = new JMenuItem("Planilla habitaciones");//mostrar todas las habitaciones y si estan ocupadas mostrar el huesped
        itemPlanillaHabitaciones.setName("itemPlanillaHabitaciones");
        menuHabitaciones.add(itemPlanillaHabitaciones);

        JMenuItem item3HabitacionesMasSolicitadas = new JMenuItem("3 Habitaciones mas solicitadas");
        item3HabitacionesMasSolicitadas.setName("item3HabitacionesMasSolicitadas");
        menuHabitaciones.add(item3HabitacionesMasSolicitadas);

        JMenuItem itemHabitacionesOcupadas = new JMenuItem("Habitaciones ocupadas");
        itemHabitacionesOcupadas.setName("itemHabitacionesOcupadas");
        menuHabitaciones.add(itemHabitacionesOcupadas);

        JMenuItem itemHabitacionesDesocupadas = new JMenuItem("Habitaciones desocupadas");
        itemHabitacionesDesocupadas.setName("itemHabitacionesDesocupadas");
        menuHabitaciones.add(itemHabitacionesDesocupadas);

        JMenuItem itemIngresoTotal = new JMenuItem("Ingreso total");
        itemIngresoTotal.setName("itemIngresoTotal");
        menuImportes.add(itemIngresoTotal);

        JMenuItem itemImporteAPagar = new JMenuItem("Importe a pagar");
        itemImporteAPagar.setName("itemImporteAPagar");
        menuImportes.add(itemImporteAPagar);

        JMenuItem itemPlanillaReservas = new JMenuItem("Planilla reservas");
        itemPlanillaReservas.setName("itemPlanillaReservas");
        menuReserva.add(itemPlanillaReservas);

        JMenuItem itemProlongarEstadia = new JMenuItem("Prolongar estadia");
        itemProlongarEstadia.setName("itemProlongarEstadia");
        menuReserva.add(itemProlongarEstadia);

        JMenuItem itemEntradaSalida = new JMenuItem("Fecha de entrada y salida");
        itemEntradaSalida.setName("itemEntradaSalida");
        menuReserva.add(itemEntradaSalida);

    }
    public static void main(String [] args)
    {
        Hotel hotel=new Hotel(1350, 700, "HOTEL");

        for (int i = 0; i < 13; i++) {
            if (i<9){
                hotel.getHabitaciones().add(new Habitaciones(1, 545));
            }
            else{
                hotel.getHabitaciones().add(new Habitaciones(2, 745));
            }
        }

        hotel.getHuespedes().add(new Huesped("Frozono", "Ricardo", 47, 22345599));
        hotel.getHuespedes().add(new Huesped("Frozono", "Terrabusi", 37, 12345599));
        hotel.getHuespedes().add(new Huesped("Lopetegui", "Micaela", 27, 32545899));
        hotel.getHuespedes().add(new Huesped("Tinglado", "Francisco", 40, 29855599));
        hotel.getHuespedes().add(new Huesped("Bertran", "Jorge", 48, 28496599));
        hotel.getHuespedes().add(new Huesped("Burruchaga", "Emiliano", 57, 25647599));
        hotel.getHuespedes().add(new Huesped("Pisculichi", "Emiliano", 47, 45187599));
        hotel.getHuespedes().add(new Huesped("Russo", "German", 45, 245677584));

        hotel.getReservas().add(new Reserva(hotel.getHuespedes().get(0),hotel.getHabitaciones().get(0),new Date(119,05,3),new Date(119,05,15),hotel.getReservas(),hotel.getHuespedes(),  hotel.getHabitaciones()));
        hotel.getReservas().add(new Reserva(hotel.getHuespedes().get(0),hotel.getHabitaciones().get(0),new Date(119,05,3), new Date(119,05,15),hotel.getReservas(),hotel.getHuespedes(),  hotel.getHabitaciones()));
        hotel.getReservas().add(new Reserva(hotel.getHuespedes().get(0),hotel.getHabitaciones().get(0),new Date(119,05,3), new Date(119,05,15),hotel.getReservas(),hotel.getHuespedes(),  hotel.getHabitaciones()));
        hotel.getReservas().add(new Reserva(hotel.getHuespedes().get(0),hotel.getHabitaciones().get(0),new Date(119,05,3), new Date(119,05,15), hotel.getReservas(),hotel.getHuespedes(),  hotel.getHabitaciones()));
        hotel.getReservas().add(new Reserva(hotel.getHuespedes().get(0),hotel.getHabitaciones().get(0),new Date(119,05,3), new Date(119,05,15), hotel.getReservas(),hotel.getHuespedes(),  hotel.getHabitaciones()));
        hotel.getReservas().add(new Reserva(hotel.getHuespedes().get(0),hotel.getHabitaciones().get(0),new Date(119,05,3), new Date(119,05,15), hotel.getReservas(),hotel.getHuespedes(),  hotel.getHabitaciones()));
        hotel.getReservas().add(new Reserva(hotel.getHuespedes().get(0),hotel.getHabitaciones().get(0),new Date(119,05,3), new Date(119,05,15), hotel.getReservas(),hotel.getHuespedes(),  hotel.getHabitaciones()));
        hotel.getReservas().add(new Reserva(hotel.getHuespedes().get(0),hotel.getHabitaciones().get(0),new Date(119,05,3), new Date(119,05,15), hotel.getReservas(),hotel.getHuespedes(),  hotel.getHabitaciones()));
        hotel.getReservas().add(new Reserva(hotel.getHuespedes().get(0),hotel.getHabitaciones().get(0), new Date(120,1,06), new Date(120,7,3),hotel.getReservas(),hotel.getHuespedes(),  hotel.getHabitaciones()));

        hotel.armarMenuPrincipal();

        Font timesNewRoman = new Font("Times New Roman", Font.BOLD, 40);
        Font garamond = new Font("Garamond", Font.BOLD, 15);

        JLabel labelBienvenida = new JLabel("¡BIENVENIDO!");
        labelBienvenida.setName("labelBienvenida");
        labelBienvenida.setVisible(true);
        labelBienvenida.setFont(timesNewRoman);
        labelBienvenida.setBounds(hotel.getVentana().getWidth()/2-150, hotel.getVentana().getHeight()/2-60, 300, 50);
        hotel.getPanelPrincipal().add(labelBienvenida);

        JLabel labelSubBienvenida = new JLabel();
        labelSubBienvenida.setText("Usa el menu bar de la esquina superior izquierda para elegir la funcion que necesites");
        labelSubBienvenida.setBounds(hotel.getVentana().getWidth()/2-270, hotel.getVentana().getHeight()/2+10, 600, 50);
        labelSubBienvenida.setFont(garamond);
        hotel.getPanelPrincipal().add(labelSubBienvenida);
    }
}


        /*Scanner scanner= new Scanner(System.in);
        int i=0, x=0;
        while(i !=-1)
        {
            System.out.println("OPCIONES: ");
            System.out.println("-1) SALIR");
            System.out.println("1) 6 HUESPEDES MAS FRECUENTES");
            System.out.println("2) SABER SI UN HUESPED TIENE DESCUENTO");
            System.out.println("3) 3 HABITACIONES MAS SOLICITADAS");
            System.out.println("4) INGRESO TOTAL");
            System.out.println("5) HUESPEDES CON ESTADIA PROLONGADA");
            System.out.println("6) HABITACIONES OCUPADAS");
            System.out.println("7) HABITACIONES DESOCUPADAS");
            System.out.println("8) VER HUSPEDES O SUS RESPECTIVAS HABITACIONES");
            System.out.println("9) TIEMPO DE CADA RESERVA");
            System.out.println("10) FECHA DE ENTRADA Y SALIDA");
            System.out.println("11) PROLONGAR ESTADIA");
            System.out.println("12) IMPORTE A PAGAR POR HUESPED");
            i=scanner.nextInt();
            switch (i)
            {
                case 1:
                    hotel01.top6HuespedesMasFrecuentes(arregloHuespedes, reservas);
                    break;
                case 2:
                    hotel01.descSIoNO(hotel01.elegirLaReserva(reservas));
                    break;
                case 3:
                    hotel01.top3HabitacionesMasSolicitadas(arregloH, reservas);
                    break;
                case 4:
                    hotel01.ingresoTotal(reservas);
                    break;
                case 5:
                    hotel01.estadiaProlongada(reservas);
                    break;
                case 6:
                    hotel01.habitacionesOcupadas(arregloH, reservas);
                    break;
                case 7:
                    hotel01.habitacionesDesocupadas(arregloH, reservas);
                    break;
                case 8:
                    hotel01.mostrarHuespedYSuHabitacion(reservas);
                    break;
                case 9:
                    hotel01.cantidadTiempoPorReserva(reservas);
                    break;
                case 10:
                    hotel01.fechaEntradaYSalida(hotel01.elegirLaReserva(reservas));
                    break;
                case 11:
                    int dia,mes,año;
                    System.out.println("Ingresaste una fecha de egreso invalida. Porfavor reingresala en formato '120(2020)''5''16'");
                    System.out.println("INGRESA UN DIA");
                    dia=scanner.nextInt();
                    System.out.println("INGRESA UN MES(4=MAYO)");
                    mes=scanner.nextInt();
                    System.out.println("INGRESA UN AÑO(120=2020)");
                    año=scanner.nextInt();
                    hotel01.elegirLaReserva(reservas).setFechaEgreso(new Date(año,mes,dia));
                    break;
                case 12:
                    hotel01.importeAPagarxHuespd(reservas);
                    break;
                case -1:
                    i=-1;
                    break;
            }
        }*/

