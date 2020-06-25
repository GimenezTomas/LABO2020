package appABM;

import persona.Persona;


import java.util.HashSet;
import java.util.Scanner;

public class SistemaABM {

    private HashSet<Animal> mascotas=new HashSet<>();
    //GETTERS && SETTERS

    public HashSet<Animal> getMascotas() {
        return mascotas;
    }

    public void setMascotas(HashSet<Animal> mascotas) {
        this.mascotas = mascotas;
    }

    //METODOS
    public void alta()
    {
        String nombreMascota="", tipo="", nombreDueño="", apellido="";
        int edad=0, dni=0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa el nombre de la mascota");
        nombreMascota=scanner.next();
        System.out.println("Ingresa el tipo de animal");
        tipo=scanner.next();
        System.out.println("Ingresa nombre, apellido, edad y dni. En ese orden");
        nombreDueño=scanner.next();
        apellido=scanner.next();
        edad=scanner.nextInt();
        dni=scanner.nextInt();

        Persona dueño = new Persona(nombreDueño, apellido, edad, dni);
        if(!tipo.equals("Pez") && !tipo.equals("Perro") && !tipo.equals("Gato") && !tipo.equals("Pajaro"))
        {
            System.out.println("Solo se puede ingresar 'Pez', 'Perro', 'Gato' o 'Pajaro'");
        }
        else
        {
            boolean nombreOK = true;
            for(Animal mascota: this.mascotas)
            {
                if(nombreMascota.equals(mascota.getNombre()))
                {
                    System.out.println("Ese nombre esta ocupado");
                    nombreOK=false;
                }
            }
            if (nombreOK)
            {
                if(tipo.equals("Pez"))
                {
                    this.mascotas.add(new Pez(nombreMascota, tipo, dueño));
                }
                else if(tipo.equals("Pajaro"))
                {
                    this.mascotas.add(new Pajaro(nombreMascota, tipo, dueño));
                }
                else if(tipo.equals("Perro"))
                {
                    this.mascotas.add(new Perro(nombreMascota, tipo, dueño));
                }
                else
                {
                    this.mascotas.add(new Gato(nombreMascota, tipo, dueño));
                }
                System.out.println("Felicidades! "+nombreMascota+" ingreso correctamente");
            }
        }
    }
    public void baja(String nombreMascota, int dniDueño)
    {
        boolean nombreOK=true;
        Animal animal=new Animal("fdsv", "evrw", new Persona("dce","dsa", 45, 45));
        for(Animal mascota: this.mascotas)
        {
            if(mascota.getNombre().equals(nombreMascota))
            {
                nombreOK=false;
                if (mascota.getDueño().getDocumento()==dniDueño)
                {
                    animal=mascota;
                    System.out.println(nombreMascota+" fue dado de baja");
                }
                else
                {
                    System.out.println(dniDueño+" no se encuentra en el sistema como titular");
                }
            }
        }
        if(nombreOK)
        {
            System.out.println(nombreMascota+" no se encuentra en el sistema");
        }
        else
        {
            this.mascotas.remove(animal);
        }
    }
    public static void main(String [] args)
    {
        SistemaABM sistemaABM= new SistemaABM();

        Animal mascota1=new Perro("Pupi", "Perro", new Persona("Juan", "Rodriguez", 20, 41000000));
        Animal mascota2=new Gato("Pipi", "Gato", new Persona("Pedro", "Rodriguez", 20, 43000000));
        Animal mascota3=new Pez("Mumi", "Pez", new Persona("Juan", "Terrazas", 20, 42000000));
        Animal mascota4=new Pajaro("Mimi", "Pajaro", new Persona("Juan", "Lorenzo", 20, 40000000));

        sistemaABM.getMascotas().add(mascota1);
        sistemaABM.getMascotas().add(mascota2);
        sistemaABM.getMascotas().add(mascota3);
        sistemaABM.getMascotas().add(mascota4);

        System.out.println("BIENVENIDO!");
        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i != 0 ; i=i) {
            System.out.println("(1) PARA DAR DE ALTA, (2) PARA DAR DE BAJA, (3) ALIMENTAR, (4) SALUDAR, (5) TIPO ANIMAL");
            i=scanner.nextInt();
            switch (i)
            {
                case 1:
                    sistemaABM.alta();
                    break;
                case 2:
                    System.out.println("Ingresa el nombre de la mascota y el dni del titular");
                    String name= "";
                    name=scanner.next();
                    int dni = 0;
                    dni=scanner.nextInt();
                    sistemaABM.baja(name, dni);
                    break;
                case 3:
                    System.out.println("Ingresa el nombre de la mascota ");
                    name=scanner.next();
                    for(Animal animal: sistemaABM.mascotas)
                    {
                        if(name.equals(animal.getNombre()))
                        {
                            animal.alimentar();
                        }
                    }
                    break;
                case 4:
                    System.out.println("Ingresa el nombre de la mascota y el dni del titular");
                    name=scanner.next();
                    dni=scanner.nextInt();
                    for(Animal animal: sistemaABM.mascotas)
                    {
                        if(name.equals(animal.getNombre()))
                        {
                            if(animal.getTipoAnimal().equals("Pez"))
                            {
                                if(dni!=animal.getDueño().getDocumento())
                                {
                                    sistemaABM.mascotas.remove(animal);
                                    System.out.println(name+" murio :(");
                                }
                            }
                            else
                            {
                                animal.saludar(dni);
                            }
                        }
                    }
                    break;
                case 5:
                    System.out.println("Ingresa el nombre de la mascota ");
                    name=scanner.next();
                    for(Animal animal: sistemaABM.mascotas)
                    {
                        if(name.equals(animal.getNombre()))
                        {
                            System.out.println(animal.getTipoAnimal());
                        }
                    }
                    break;
            }
        }
    }
}
