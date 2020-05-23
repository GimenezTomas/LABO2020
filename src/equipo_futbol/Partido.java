package equipo_futbol;

import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;

public class Partido {
    private Date fechaDelPartido;
    private Equipos equipoLocal;
    private Equipos equipoVisitante;
    private int golesLocal;
    private int golesVisitante;
    public static int count=1;
    private int nPartido;

    public int getGolesVisitante() {
        return golesVisitante;
    }

    public void setGolesVisitante(int golesVisitante) {
        this.golesVisitante = golesVisitante;
    }

    public int getGolesLocal() {
        return golesLocal;
    }

    public void setGolesLocal(int golesLocal) {
        this.golesLocal = golesLocal;
    }

    public Date getFechaDelPartido() {
        return fechaDelPartido;
    }
    public void setFechaDelPartido(Date fechaDelPartido) {
        this.fechaDelPartido = fechaDelPartido;
    }

    public Equipos getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(Equipos equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    public Equipos getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(Equipos equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public Partido(Equipos equipoLocal, Equipos equipoVisitante, Date fechaDelPartido, HashSet<Equipos> equipos, int golesLocal, int golesVisitante) {
        Scanner scanner=new Scanner(System.in);
        String n;
            while (equipoVisitante.equals(equipoLocal))
            {
                System.out.println("LOS EQUIPOS SON IGUALES, REELIGI EL EQUIPO VISITANTE");
                n=scanner.nextLine();
                for(Equipos equipos1: equipos)
                {
                    if(n.equals(equipos1.getNombre()))
                    {
                        equipoVisitante=equipos1;
                    }
                }
            }
        this.equipoVisitante=equipoVisitante;
        this.equipoLocal=equipoLocal;
        this.fechaDelPartido = fechaDelPartido;
        this.golesLocal=golesLocal;
        this.golesVisitante=golesVisitante;
        nPartido = count++;
        if (golesLocal>golesVisitante)
        {
            equipoLocal.setGanados(equipoLocal.getGanados()+1);
            equipoVisitante.setPerdidos(equipoVisitante.getPerdidos()+1);
        }
        else if(golesLocal==golesVisitante)
        {
            equipoLocal.setEmpatados(equipoLocal.getEmpatados()+1);
            equipoVisitante.setEmpatados(equipoVisitante.getEmpatados()+1);
        }
        else
        {
            equipoLocal.setPerdidos(equipoLocal.getPerdidos()+1);
            equipoVisitante.setGanados(equipoVisitante.getGanados()+1);
        }
        equipoLocal.setGoles(equipoLocal.getGoles()+golesLocal);
        equipoVisitante.setGoles(equipoVisitante.getGoles()+golesVisitante);
        equipoLocal.setGolesEnContra(equipoLocal.getGolesEnContra()+golesVisitante);
        equipoVisitante.setGolesEnContra(equipoVisitante.getGolesEnContra()+golesLocal);
    }
}
