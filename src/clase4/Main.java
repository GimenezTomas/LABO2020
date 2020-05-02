package clase4;
import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        Scanner ingreso=new Scanner (System.in);
        //APP01
        Aplicacion01 persona01=new Aplicacion01();
        persona01.pedirApellid();
        persona01.pedirNombre();
        persona01.pedirOcupacion();
        persona01.pedirEdad();
        System.out.println("Apellido: "+persona01.getApellido());
        System.out.println("Nombre: "+persona01.getNombre());
        System.out.println("Ocupacion: "+persona01.getOcupacion());
        System.out.println("Edad: "+persona01.getEdad());
        //APP02
        Aplicacion02 producto01= new Aplicacion02();
        producto01.pedirMarca();
        producto01.pedirNombre();
        producto01.pedirUnidades();
        producto01.pedirPrecio();
        Aplicacion02 producto02= new Aplicacion02();
        producto02.pedirMarca();
        producto02.pedirNombre();
        producto02.pedirPrecio();
        producto02.pedirUnidades();
        producto01.canastA.add(producto01);
        producto01.canastA.add(producto02);
        float importeTotal=0;
        producto01.canastA.size();
        for(int i=0; i < producto01.canastA.size(); i++)
        {
            importeTotal= importeTotal + producto01.canastA.get(i).getPrecio()* producto01.canastA.get(i).getUnidades();
        }
        System.out.println("Importe total: "+importeTotal);
    }
}

