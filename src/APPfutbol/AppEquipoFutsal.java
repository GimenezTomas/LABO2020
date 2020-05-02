package APPfutbol;

import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;

public class AppEquipoFutsal {
    private HashSet<Partido> partidos;
    private HashSet<Equipos> equipos;
    //Getters && Setters
    public HashSet<Equipos> getEquipos() {
        return equipos;
    }

    public void setEquipos(HashSet<Equipos> equipos) {
        this.equipos = equipos;
    }

    public HashSet<Partido> getPartidos() {
        return partidos;
    }

    public void setPartidos(HashSet<Partido> partidos) {
        this.partidos = partidos;
    }
    //METODOS
    public void imprimirInformacionDelTorneo(HashSet<Partido> partidos)
    {
        System.out.println("PARTIDOS: ");
        for(Partido partido: partidos)
        {
            System.out.println(partido.getEquipoLocal().getNombre()+" "+partido.getGolesLocal()+" "+partido.getGolesVisitante()+" "+partido.getEquipoVisitante().getNombre()+" FECHA: "+partido.getFechaDelPartido());
        }
    }
    public void estadisticasDeLosEquipos(HashSet<Equipos> equipos, HashSet<Partido> partidos)
    {
        for(Equipos equipo: equipos)
        {
            int jugados=equipo.getEmpatados()+equipo.getGanados()+equipo.getPerdidos();
            System.out.println("------------------------------------------------------------------------------------------------------------");
            System.out.println("|"+equipo.getNombre()+"| PJ "+jugados+"| GANADOS "+equipo.getGanados()+"| EMPATADOS "+equipo.getEmpatados()+"| PERDIDOS "+equipo.getPerdidos()+"| GOLES A FAVOR "+equipo.getGoles()+" | GOLES EN CONTRA "+equipo.getGolesEnContra());
            System.out.println("------------------------------------------------------------------------------------------------------------");
        }
    }
    public void jugadoresInscriptosPorEquipo(HashSet<Equipos> equipos)
    {
        System.out.println("-----------------------------JUGADORES-----------------------------");
        System.out.println("|        NOMBRE        |       APELLIDO      |       EDAD      |");
        for(Equipos equipo: equipos)
        {
            System.out.println("------------------------"+equipo.getNombre()+"----------------------");
            for (Jugador jugador: equipo.getJugadores())
            {
                System.out.println("|        "+jugador.getNombre()+"                   "+jugador.getApellido()+"                 "+jugador.getEdad()+"       |");
            }
        }
    }
    public static  void main(String [] args) {
        AppEquipoFutsal appEquipoFutsal = new AppEquipoFutsal();
        //EQUIPO 1
        Jugador jugador1=new Jugador("Tomas", "Gimenez", 17);
        Jugador jugador2=new Jugador("Mario", "Sarachi", 19);
        Jugador jugador3=new Jugador("Hernan", "Rodriguez", 17);
        Jugador jugador4=new Jugador("Lisandro", "Rodriguez", 25);
        Jugador jugador5=new Jugador("Lautaro", "Martinez", 28);
        Jugador jugador6=new Jugador("Carlos", "Etchegoyen", 31);
        //EQUIPO 2
        Jugador jugador7=new Jugador("Ariel", "Pavone", 48);
        Jugador jugador8=new Jugador("Carlos", "Bilardo", 18);
        Jugador jugador9=new Jugador("Micaela", "Sanchez", 18);
        Jugador jugador10=new Jugador("Hernan", "Sanchez", 17);
        Jugador jugador11=new Jugador("Ricardo", "Rodriguez", 19);
        Jugador jugador12=new Jugador("Camila", "Montaner", 26);
        //EQUIPO 3
        Jugador jugador13=new Jugador("Lucas", "Pratto", 17);
        Jugador jugador14=new Jugador("Jose", "Mercado", 17);
        Jugador jugador15=new Jugador("Fabian", "Miranda", 17);
        Jugador jugador16=new Jugador("Morena", "Fernandez", 20);
        Jugador jugador17=new Jugador("Miranda", "Lusteo", 21);
        Jugador jugador18=new Jugador("Carolina", "Zacchi", 20);
        //JUGADORES POR EQUIPO
        HashSet<Jugador> equipo1 = new HashSet<>();
        HashSet<Jugador> equipo2 = new HashSet<>();
        HashSet<Jugador> equipo3 = new HashSet<>();
        //CREACION DE EQUIPOS
        Equipos river= new Equipos("River Plate", equipo1);
        Equipos estudiantes= new Equipos("Estudiantes de la Plata", equipo2);
        Equipos boca= new Equipos("Boca Juniors", equipo3);
        //AGREGAR JUGADORES AL EQUIPO
        river.getJugadores().add(jugador1);
        river.getJugadores().add(jugador2);
        river.getJugadores().add(jugador3);
        river.getJugadores().add(jugador4);
        river.getJugadores().add(jugador5);
        river.getJugadores().add(jugador6);

        estudiantes.getJugadores().add(jugador7);
        estudiantes.getJugadores().add(jugador8);
        estudiantes.getJugadores().add(jugador9);
        estudiantes.getJugadores().add(jugador10);
        estudiantes.getJugadores().add(jugador11);
        estudiantes.getJugadores().add(jugador12);

        boca.getJugadores().add(jugador13);
        boca.getJugadores().add(jugador14);
        boca.getJugadores().add(jugador15);
        boca.getJugadores().add(jugador16);
        boca.getJugadores().add(jugador17);
        boca.getJugadores().add(jugador18);
        //JUGADORES DEL TORENO POR EQUIPO
        HashSet<Equipos> equipos= new HashSet<>();
        appEquipoFutsal.setEquipos(equipos);
        //AÑADIR EQUIPOS AL TORNEO
        equipos.add(river);
        equipos.add(estudiantes);
        equipos.add(boca);
        //PARTIDOS
        Partido partido1= new Partido(river, boca, new Date(120, 4, 12, 20, 05), equipos, 3, 1);
        Partido partido2= new Partido(river,estudiantes, new Date(120, 4, 22, 20, 05), equipos, 4, 0);
        Partido partido3= new Partido(estudiantes,boca, new Date(120, 4, 30, 20, 05), equipos, 1, 1);
        //AÑADIR PARTIDOS AL TORNEO
        HashSet<Partido> partidos= new HashSet<>();
        partidos.add(partido1);
        partidos.add(partido2);
        partidos.add(partido3);

        int w=-1;
        Scanner scanner= new Scanner(System.in);
        while (w!=0)
        {
            System.out.println("ELEGI LA OPCION");
            System.out.println("0) SALIR");
            System.out.println("1) INFORMACION DEL TORNEO");
            System.out.println("2) ESTADISTICAS DE LOS EQUIPOS");
            System.out.println("3) JUGADORES INSCRIPTOS POR EQUIPO");
            w=scanner.nextInt();
            switch(w)
            {
                case 1:
                    appEquipoFutsal.imprimirInformacionDelTorneo(partidos);
                    break;
                case 2:
                    appEquipoFutsal.estadisticasDeLosEquipos(equipos, partidos);
                    break;
                case 3:
                    appEquipoFutsal.jugadoresInscriptosPorEquipo(equipos);
                    break;
            }
        }

    }

}
