package Veterinaria;

import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;

public class Veteriana {
    private HashSet<AnimalVeterinaria> animales=new HashSet<>();//cambiarlos segun el tipo de animal

    public HashSet<AnimalVeterinaria> getAnimales() {
        return animales;
    }

    public void setAnimales(HashSet<AnimalVeterinaria> animales) {
        this.animales = animales;
    }

    public void chequearVisitasAño(int id)
    {
        int contador=0, año=(new Date()).getYear();
        boolean ok=true;
        for(AnimalVeterinaria animal: this.animales)
        {
            if (animal.getId()==id || id==-50)
            {
                ok=false;
                contador=0;
                for (int i = 0; i < animal.getFechaVisita().size(); i++)
                {
                    if(animal.getFechaVisita().get(i).getYear()==año)
                    {
                        contador++;
                    }
                }
                if(id==-50)
                {
                    if (contador<animal.getVisitasPorAño())
                    {
                        System.out.println("A "+animal.getId()+" le faltan "+(animal.getVisitasPorAño()-contador) + " visitas");
                    }
                }
                else
                {
                    if (contador>=animal.getVisitasPorAño())
                    {
                        System.out.println("Su "+animal.getTipoAnimal()+" esta al dia");
                    }
                    else
                    {
                        System.out.println("A "+animal.getId()+" le faltan "+(4-contador) + " visitas");
                    }
                }
            }
        }
        if(ok) {
            System.out.println("No se encontro el animal");
        }
    }
    public void animalesConFaltaDeVisitas()
    {
        chequearVisitasAño(-50);
    }
    public void asistenciaPerfecta(int id)
    {
        int contador=0, contadorPerro=0, contadorGato=0, contadorTortuga=0;
        boolean ok=true, asisPerfecta=true;

        for(AnimalVeterinaria animal: this.animales)
        {
            asisPerfecta=true;
            if(id==animal.getId() || id==-50)
            {
                ok=false;
                int año=0;
                if(animal.getFechaVisita().size()==0)
                {
                    asisPerfecta=false;
                }
                else
                {
                    for (int i = 0; i < animal.getFechaVisita().size(); i++)
                    {
                        if(año!=animal.getFechaVisita().get(i).getYear()&& i!=0)
                        {
                            if(contador<animal.getVisitasPorAño())
                            {
                                asisPerfecta=false;
                                break;
                            }
                            else
                            {
                                año=animal.getFechaVisita().get(i).getYear();
                                contador=0;
                                // asisPerfecta=true;
                            }
                        }
                        else
                        {
                            año=animal.getFechaVisita().get(i).getYear();
                            contador++;
                        }
                    }
                }
            }
            if(asisPerfecta && ok==false)
            {
                if(id==-50)
                {
                    if(animal.getTipoAnimal()=="Perro")
                    {
                        contadorPerro++;
                    }
                    else if(animal.getTipoAnimal()=="Gato")
                    {
                        contadorGato++;
                    }
                    else
                    {
                        contadorTortuga++;
                    }
                }
            }
        }
        if(id!=-50 && asisPerfecta && !ok)
        {
            System.out.println("Tiene asistencia perfecta");
        }
        else if(id==-50)
        {
            if(contadorGato<contadorPerro && contadorPerro>contadorTortuga)
            {
                System.out.println("El animal con mejor promedio es el perro");
            }
            else if(contadorGato>contadorPerro&&contadorGato>contadorTortuga)
            {
                System.out.println("El animal con mejor promedio es el gato");
            }
            else
            {
                System.out.println("El animal con mejor promedio es la tortuga");
            }
        }
        else if (asisPerfecta==false)
        {
            System.out.println("No tiene asistencia perfecta");
        }
        else {
            System.out.println("No se encontro el animal");
        }
    }
    public void mejorAnimal()
    {
        asistenciaPerfecta(-50);
    }
    public void ingresarAnimal(String tipo)
    {
        if(tipo.equals("Gato"))
        {
            this.animales.add(new AnimalVeterinaria(tipo, 2));
            System.out.println("Su "+tipo+" fue agregado");
        }
        else if(tipo.equals("Tortuga"))
        {
            this.animales.add(new AnimalVeterinaria(tipo, 4));
            System.out.println("Su "+tipo+" fue agregado");
        }
        else if(tipo.equals("Perro"))
        {
            this.animales.add(new AnimalVeterinaria(tipo, 1));
            System.out.println("Su "+tipo+" fue agregado");
        }
        else
        {
            System.out.println("Solo se permiten Gatos, Perros y Tortugas");
        }
    }
    public static void main(String [] args)
    {
        Veteriana veteriana = new Veteriana();

        veteriana.animales.add(new AnimalVeterinaria("Perro",  4));
        veteriana.animales.add(new AnimalVeterinaria("Gato",  2));
        veteriana.animales.add(new AnimalVeterinaria("Tortuga",  1));
        veteriana.animales.add(new AnimalVeterinaria("Perro",  4));
        veteriana.animales.add(new AnimalVeterinaria("Gato",  2));
        veteriana.animales.add(new AnimalVeterinaria("Tortuga",  1));
        veteriana.animales.add(new AnimalVeterinaria("Perro",  4));

        for (AnimalVeterinaria animales:veteriana.getAnimales()) {
            for (int j = 0; j <4 ; j++) {
                animales.getFechaVisita().add(new Date());
            }
        }
        veteriana.animales.add(new AnimalVeterinaria("Gato",  2));
        veteriana.animales.add(new AnimalVeterinaria("Tortuga",  1));

        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i >0 ; i++) {
            System.out.println("(1) visitas del año, (2) animales con falta de visitas, (3) Asistencia perfecta, (4) tipo animal con mejor asistencia, (5) agregar animal y (0) salir");
            i=scanner.nextInt();
            switch(i)
            {
                case 1:
                    System.out.println("Ingresa el id de tu mascota");
                    int j=scanner.nextInt();
                    veteriana.chequearVisitasAño(j);
                    break;
                case 2:
                    veteriana.chequearVisitasAño(-50);
                    break;
                case 3:
                    System.out.println("Ingresa el id de tu mascota");
                    j=scanner.nextInt();
                    veteriana.asistenciaPerfecta(j);
                    break;
                case 4:
                    veteriana.asistenciaPerfecta(-50);
                    break;
                case 5:
                    System.out.println("Ingresa el tipo de animal");
                    String tipo=scanner.next();
                    veteriana.ingresarAnimal(tipo);
            }
        }
    }
}
