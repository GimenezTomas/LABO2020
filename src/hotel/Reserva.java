package hotel;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Reserva {
    public static int count=1;
    private String apellido;
    private int numeroHuesped;
    private int numHabitacion;
    private Date fechaIngreso;
    private Date fechaEgreso;
    private int numeroReserva;
    private boolean descuento=false;
    private Huesped huesped;
    private Habitaciones habitacion;

    public Habitaciones getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitaciones habitacion) {
        this.habitacion = habitacion;
    }

    public Huesped getHuesped() {
        return huesped;
    }

    public void setHuesped(Huesped huesped) {
        this.huesped = huesped;
    }

    public int getNumHabitacion() {
        return numHabitacion;
    }

    public void setNumHabitacion(int numHabitacion) {
        this.numHabitacion = numHabitacion;
    }

    public int getNumeroHuesped() {
        return numeroHuesped;
    }

    public void setNumeroHuesped(int numeroHuesped) {
        this.numeroHuesped = numeroHuesped;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Reserva.count = count;
    }

    public boolean isDescuento() {
        return descuento;
    }

    public void setDescuento(boolean descuento) {
        this.descuento = descuento;
    }

    public int getNumeroReserva() {
        return numeroReserva;
    }

    public void setNumeroReserva(int numeroReserva) {
        this.numeroReserva = numeroReserva;
    }

    public Date getFechaEgreso() {
        return fechaEgreso;
    }

    public void setFechaEgreso(Date fechaEgreso) {
        this.fechaEgreso = fechaEgreso;

    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public  Reserva(Huesped huesped, Habitaciones habitacion, Date fechaIngreso, Date fechaEgreso,ArrayList<Reserva> arreglo, ArrayList<Huesped> arregloHuespedes, ArrayList<Habitaciones> arregloHabitacion)
    {
        numeroReserva=count++;
        int n,p;
        this.numHabitacion=numHabitacion;
        this.numeroHuesped=numeroHuesped;
        this.fechaIngreso=fechaIngreso;
        this.fechaEgreso=fechaEgreso;
        this.habitacion=habitacion;
        p=habitacion.getNumeroDeHabitacion();
        n=huesped.getNumeroDeHuesped();
        Scanner scanner = new Scanner(System.in);
        for (int i=0; i<arreglo.size(); i++)
        {
            if (arreglo.get(i).getNumeroHuesped()==n &&(fechaIngreso.getYear()<arreglo.get(i).getFechaEgreso().getYear()||(fechaIngreso.getYear()==arreglo.get(i).getFechaEgreso().getYear()&&(arreglo.get(i).getFechaEgreso().getDay()>=fechaIngreso.getDay()&&arreglo.get(i).getFechaEgreso().getMonth()>fechaIngreso.getMonth()) ||arreglo.get(i).getFechaEgreso().getDay()<fechaIngreso.getDay()&&arreglo.get(i).getFechaEgreso().getMonth()<fechaIngreso.getMonth()))) {
                while ((arreglo.get(i).getNumeroHuesped()==n && (fechaIngreso.getYear()<arreglo.get(i).getFechaEgreso().getYear()||(fechaIngreso.getYear()==arreglo.get(i).getFechaEgreso().getYear()&&(arreglo.get(i).getFechaEgreso().getDay()>=fechaIngreso.getDay()&&arreglo.get(i).getFechaEgreso().getMonth()>fechaIngreso.getMonth()) ||arreglo.get(i).getFechaEgreso().getDay()<fechaIngreso.getDay()&&arreglo.get(i).getFechaEgreso().getMonth()<fechaIngreso.getMonth())))|| n>arregloHuespedes.size()-1)
                {
                    System.out.println("NUMERO DE HUESPED: "+arreglo.get(i).getNumeroHuesped()+" Ingresaste un huesped invalido, este tiene una reserva a su nombre sin concluir. Porfavor reingresa el numero de huesped");
                    n=scanner.nextInt();
                }
            }
        }
        for(int i=0; i<arreglo.size(); i++)
        {
            if (arreglo.get(i).getNumHabitacion() == habitacion.getNumeroDeHabitacion() && (fechaIngreso.getYear()<arreglo.get(i).getFechaEgreso().getYear()||(fechaIngreso.getYear()==arreglo.get(i).getFechaEgreso().getYear()&&(arreglo.get(i).getFechaEgreso().getDay()>=fechaIngreso.getDay()&&arreglo.get(i).getFechaEgreso().getMonth()>fechaIngreso.getMonth()) ||arreglo.get(i).getFechaEgreso().getDay()<fechaIngreso.getDay()&&arreglo.get(i).getFechaEgreso().getMonth()<fechaIngreso.getMonth()))|| p>arregloHabitacion.size()-1)
             {
                while (arreglo.get(i).getNumHabitacion() == p && habitacion.isOcupada() == true ) {
                    System.out.println("Ingresaste una habitacion invalida, esta tiene una reserva sin concluir. Porfavor reingresa el numero de habitacion");
                    p = scanner.nextInt();
                }
            }
        }
        while(fechaEgreso.getYear()<fechaIngreso.getYear()||((fechaEgreso.getDay()<=fechaIngreso.getDay()&&fechaEgreso.getMonth()<fechaIngreso.getMonth())||fechaEgreso.getDay()>fechaIngreso.getDay()&&fechaEgreso.getMonth()<fechaIngreso.getMonth()))
        {
            int dia,mes,año;
            System.out.println("Ingresaste una fecha de egreso invalida. Porfavor reingresala en formato '120(2020)''5''16'");
            System.out.println("INGRESA UN DIA");
            dia=scanner.nextInt();
            System.out.println("INGRESA UN MES(4=MAYO)");
            mes=scanner.nextInt();
            System.out.println("INGRESA UN AÑO(120=2020)");
            año=scanner.nextInt();
            fechaEgreso=new Date(año,mes,dia);

        }
        this.numeroHuesped=n;
        this.numHabitacion=p;
        this.numHabitacion=numHabitacion;
        this.numeroHuesped=numeroHuesped;
        this.fechaIngreso=fechaIngreso;
        this.fechaEgreso=fechaEgreso;
        this.habitacion=habitacion;
        habitacion.setOcupada(true);
    }
}