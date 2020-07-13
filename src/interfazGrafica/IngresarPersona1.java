package interfazGrafica;

import persona.Persona;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class IngresarPersona1 {
    private ArrayList<Persona> personas = new ArrayList<>();

    public static  void main(String [] args)
    {
        JFrame ventana = new JFrame();
        ventana.setLayout(null);
        ventana.setSize(1000, 1000);
        ventana.setVisible(true);

        JLabel p1 = new JLabel();
        p1.setText("Ingrese el nombre");
        p1.setSize(500, 25);
        p1.setLocation(200,0);

        JLabel p2 = new JLabel();
        p2.setText("Ingrese el apellido");
        p2.setSize(500, 25);
        p2.setLocation(200,125);

        JLabel p3 = new JLabel();
        p3.setText("Ingrese el dni");
        p3.setSize(500, 25);
        p3.setLocation(200,250);

        JLabel p4 = new JLabel();
        p4.setText("Ingrese la edad");
        p4.setSize(500, 25);
        p4.setLocation(200, 375);

        JButton boton = new JButton("INGRESAR");
        boton.setSize(200, 50);
        boton.setLocation(ventana.getWidth()/2-boton.getWidth()/2, 500);

        JTextField nombre=new JTextField();
        nombre.setLocation(200, p1.getY()+p1.getHeight()+10);
        nombre.setSize(500, 25);

        JTextField apellido=new JTextField();
        apellido.setSize(500, 30);
        apellido.setLocation(200, p2.getY()+p2.getHeight()+10);

        JTextField dni=new JTextField();
        dni.setLocation(200, p3.getY()+p3.getHeight()+10);
        dni.setSize(500, 30);

        JTextField edad=new JTextField();
        edad.setLocation(200, p4.getY()+p4.getHeight()+10);
        edad.setSize(500, 30);

        JLabel ok = new JLabel();
        ok.setSize(200, 50);
        ok.setLocation(200,boton.getY()+boton.getHeight()+50);

        ventana.add(p1);
        ventana.add(p2);
        ventana.add(p3);
        ventana.add(p4);

        ventana.add(boton);

        ventana.add(nombre);
        ventana.add(apellido);
        ventana.add(dni);
        ventana.add(edad);

        ventana.add(ok);

        IngresarPersona1 ingresarPersona1=new IngresarPersona1();

        boton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int personasSize=ingresarPersona1.personas.size();
                ingresarPersona1.personas.add(new Persona(nombre.getText(), apellido.getText(), Integer.parseInt(edad.getText()), Integer.parseInt(dni.getText())));
                nombre.setText(" ");
                apellido.setText(" ");
                edad.setText(" ");
                dni.setText(" ");
                if(personasSize==ingresarPersona1.personas.size()-1)
                {
                    ok.setText("Se ingreso correctamente");
                }
                else
                {
                    ok.setText("No se pudo ingresar");
                }
            }
        });

    }
}
