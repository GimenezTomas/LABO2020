package coincidenciasSpotify;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    private String nombre;
    private String ubicacion;
    private ArrayList<String> canciones = new ArrayList<>();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public ArrayList<String> getCanciones() {
        return canciones;
    }

    public void setCanciones(ArrayList<String> canciones) {
        this.canciones = canciones;
    }

    public void obtenerNombreYUbi(){
        System.out.println("ingresa el nombre del archivo");
        Scanner scanner = new Scanner(System.in);
        this.nombre = scanner.nextLine();
        System.out.println("ingresa la ubicacion del archivo");
        this.ubicacion = scanner.nextLine();
    }

    public void obtenerArray() throws FileNotFoundException {
        this.obtenerNombreYUbi();
        Scanner scanner = new Scanner(new File(this.ubicacion+this.nombre));

        while (scanner.hasNextLine()){
            this.canciones.add(scanner.nextLine());
        }
    }

    public String subString(String cancion){
        String subStr = "";

        if (cancion.contains(" - Remix")){
            subStr = cancion.substring(0 ,cancion.indexOf(" - Remix")-1);
        }else if (cancion.length()>3 && cancion.substring(cancion.length()-1).equals("x")){
            subStr = cancion.substring(0, cancion.length()-1);
        }else{
            subStr = cancion;
        }
        return subStr;
    }

    public void cancionesRepetidas() throws FileNotFoundException {
        this.obtenerArray();
        ArrayList<String> cancionesRepetidas = new ArrayList<>();
        for (int i = 0; i < canciones.size() ; i++) {
            String subStr = this.subString(canciones.get(i));
            boolean repetida = false;

            for (int j = i+1; j < canciones.size(); j++) {
                String subStr2 = this.subString(canciones.get(j));

                if(subStr.equals(subStr2)){
                    System.out.println(canciones.get(j)+" <- J I-> "+canciones.get(i));
                    canciones.remove(j);
                    repetida = true;
                    j--;
                }else{
                    if (subStr.length()>2 && subStr2.length()>2 && (subStr.length()-subStr2.length()<2 && subStr.length()-subStr2.length()> - 2)){
                        String f = subStr.substring(0, Math.min(subStr.length(), subStr2.length())-1);
                        if (f.equals(subStr2.substring(0, f.length()))){
                            System.out.println(canciones.get(j)+" <- J I-> "+canciones.get(i));
                            canciones.remove(j);
                            repetida = true;
                            j--;
                        }
                    }
                }
            }

            if (repetida){
                cancionesRepetidas.add(canciones.get(i));
            }
        }
        this.canciones = cancionesRepetidas;
    }

    public static void main(String [] args) throws FileNotFoundException {
        Main main = new Main();
        main.cancionesRepetidas();
        for (String cancion: main.canciones) {
            System.out.println(cancion);
        }
    }
}
