package hotel;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Hotel {
    private ArrayList<Habitaciones> habitacionesArreglo;
     public ArrayList<Habitaciones> getHabitacionesArreglo() {
        return habitacionesArreglo;
    }

    public void setHabitacionesArreglo(ArrayList<Habitaciones> habitacionesArreglo) {
        this.habitacionesArreglo = habitacionesArreglo;
    }
     public void top6HuespedesMasFrecuentes(ArrayList<Huesped> listaHuespedes, ArrayList<Reserva> reservas) {
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
     }
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
        /*Date dt= new Date();
        String date1, date2;
        DateTimeFormatter df = DateTimeFormatter.ofPattern("d-MMM-yyyy");*/
        Long datediff;
        for(Reserva x : reservas)
        {
            datediff=dateDiff(x.getFechaIngreso(),x.getFechaEgreso());
            /*date1=formatearFecha(x.getFechaIngreso());
            date2 = formatearFecha(x.getFechaEgreso());
            LocalDate  d1 = LocalDate.parse(date1, df);
            LocalDate  d2 = LocalDate.parse(date2, df);
            Long datediff = ChronoUnit.DAYS.between(d1,d2);*/
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
    public static void main(String [] args)
    {
        Hotel hotel01=new Hotel();
        Habitaciones habitacion01= new Habitaciones(1, 545);
        Habitaciones habitacion02= new Habitaciones(1, 545);
        Habitaciones habitacion03= new Habitaciones(1, 545);
        Habitaciones habitacion04= new Habitaciones(1, 545);
        Habitaciones habitacion05= new Habitaciones(1, 545);
        Habitaciones habitacion06= new Habitaciones(1, 545);
        Habitaciones habitacion07= new Habitaciones(1, 545);
        Habitaciones habitacion08= new Habitaciones(1, 545);
        Habitaciones habitacion09= new Habitaciones(2, 745);
        Habitaciones habitacion10= new Habitaciones(2, 745);
        Habitaciones habitacion11= new Habitaciones(2, 745);
        Habitaciones habitacion12= new Habitaciones(2, 745);
        Habitaciones habitacion13= new Habitaciones(2, 745);

        Huesped huesped01=new Huesped("Frozono", "Ricardo", 47, 22345599);
        Huesped huesped02=new Huesped("Frozono", "Terrabusi", 37, 12345599);
        Huesped huesped03=new Huesped("Lopetegui", "Micaela", 27, 32545899);
        Huesped huesped04=new Huesped("Tinglado", "Francisco", 40, 29855599);
        Huesped huesped05=new Huesped("Bertran", "Jorge", 48, 28496599);
        Huesped huesped06=new Huesped("Burruchaga", "Emiliano", 57, 25647599);
        Huesped huesped07=new Huesped("Pisculichi", "Emiliano", 47, 45187599);
        Huesped huesped08= new Huesped("Russo", "German", 45, 245677584);

        ArrayList<Habitaciones> arregloH=new ArrayList<Habitaciones>();
        hotel01.setHabitacionesArreglo(arregloH);
        arregloH.add(habitacion01);
        arregloH.add(habitacion02);
        arregloH.add(habitacion03);
        arregloH.add(habitacion04);
        arregloH.add(habitacion05);
        arregloH.add(habitacion06);
        arregloH.add(habitacion07);
        arregloH.add(habitacion08);
        arregloH.add(habitacion09);
        arregloH.add(habitacion10);
        arregloH.add(habitacion11);
        arregloH.add(habitacion12);
        arregloH.add(habitacion13);

        ArrayList<Huesped> arregloHuespedes=new ArrayList<Huesped>();
        arregloHuespedes.add(huesped01);
        arregloHuespedes.add(huesped02);
        arregloHuespedes.add(huesped03);
        arregloHuespedes.add(huesped04);
        arregloHuespedes.add(huesped05);
        arregloHuespedes.add(huesped06);
        arregloHuespedes.add(huesped07);
        arregloHuespedes.add(huesped08);

        ArrayList<Reserva>reservas= new ArrayList<>();
        Reserva reserva1=new Reserva(huesped01,habitacion01,new Date(119,05,3),new Date(119,05,15) ,reservas,arregloHuespedes,  arregloH);
        reservas.add(reserva1);
        Reserva reserva2=new Reserva(huesped02,habitacion02,new Date(119,05,3), new Date(119,05,15),reservas,arregloHuespedes,  arregloH);
        reservas.add(reserva2);
        Reserva reserva3=new Reserva(huesped03,habitacion03,new Date(119,05,3), new Date(119,05,15), reservas,arregloHuespedes,  arregloH);
        reservas.add(reserva3);
        Reserva reserva4=new Reserva(huesped04,habitacion04,new Date(119,05,3), new Date(119,05,15), reservas,arregloHuespedes,  arregloH);
        reservas.add(reserva4);
        Reserva reserva5=new Reserva(huesped05,habitacion05,new Date(119,05,3), new Date(119,05,15), reservas,arregloHuespedes,  arregloH);
        reservas.add(reserva5);
        Reserva reserva6=new Reserva(huesped06,habitacion06,new Date(119,05,3), new Date(119,05,15), reservas,arregloHuespedes,  arregloH);
        reservas.add(reserva6);
        Reserva reserva7=new Reserva(huesped07,habitacion07,new Date(119,05,3), new Date(119,05,15), reservas,arregloHuespedes,  arregloH);
        reservas.add(reserva7);
        Reserva reserva8=new Reserva(huesped08,habitacion08,new Date(119,05,3), new Date(119,05,15), reservas,arregloHuespedes,  arregloH);
        reservas.add(reserva8);
        Reserva reserva9=new Reserva(huesped02, habitacion02, new Date(120,1,06), new Date(120,7,3),reservas,arregloHuespedes,  arregloH);
        reservas.add(reserva9);

        Scanner scanner= new Scanner(System.in);
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
            System.out.println("8) VER HUSPEDES U SUS RESPECTIVAS HABITACIONES");
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
        }
    }
}

