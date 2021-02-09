package interfazGrafica.login;
import restaurantes.AccesoBaseDeDatos;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.*;

public class Login {
    private JFrame ventana;
    private JPanel panelIngresar;
    private AccesoBaseDeDatos acceso;
    public static String message;

    public AccesoBaseDeDatos getAcceso() {
        return acceso;
    }

    public void setAcceso(AccesoBaseDeDatos acceso) {
        this.acceso = acceso;
    }

    public JFrame getVentana() {
        return ventana;
    }

    public void setVentana(JFrame ventana) {
        this.ventana = ventana;
    }

    public JPanel getPanelIngresar() {
        return panelIngresar;
    }

    public void setPanelIngresar(JPanel panelIngresar) {
        this.panelIngresar = panelIngresar;
    }

    public Login(int width, int height, String title) {
        this.ventana = new JFrame(title);
        this.ventana.setSize(width, height);
        this.ventana.setVisible(true);
        this.ventana.setLayout(null);

        HashSet<String> tablas = new HashSet<>();
        tablas.add("usuarios");
        this.acceso = new AccesoBaseDeDatos("restaurante", tablas);

        try{
            acceso.connect("root", "Alumno:TomasGimenez2002");
            message = "Se conencto correctamente a la base";
        }catch (Exception ex){
            message=""+ex.getStackTrace();
            ex.printStackTrace();
        }

        this.setPanelIngresar(new JPanel());
        this.getPanelIngresar().setSize(600, 600);
        this.getPanelIngresar().setLayout(null);
        this.getVentana().add(this.getPanelIngresar());

        JLabel labelUsuario = new JLabel("Usuario");
        labelUsuario.setBounds(300-150, 50, 300, 50);
        labelUsuario.setName("labelUsuario");
        labelUsuario.setVisible(true);
        this.getPanelIngresar().add(labelUsuario);

        JTextField campoUsuario = new JTextField();
        campoUsuario.setName("campoUsuario");
        campoUsuario.setBounds(150, 120, 300, 50);
        campoUsuario.setVisible(true);
        this.getPanelIngresar().add(campoUsuario);

        JLabel labelContraseña = new JLabel("Contraseña");
        labelContraseña.setBounds(300-150, 190, 300, 50);
        labelContraseña.setName("labelContraseña");
        labelContraseña.setVisible(true);
        this.getPanelIngresar().add(labelContraseña);

        JPasswordField campoContraseña = new JPasswordField();
        campoContraseña.setName("campoContraseña");
        campoContraseña.setBounds(150, 260, 300, 50);
        campoContraseña.setVisible(true);
        this.getPanelIngresar().add(campoContraseña);

        JButton botonSubmit = new JButton("INGRESAR");
        botonSubmit.setBounds(300-50, 330, 100, 50);
        botonSubmit.setVisible(true);
        botonSubmit.setName("botonSubmit");
        this.getPanelIngresar().add(botonSubmit);

        JLabel labelBase = new JLabel(message);
        labelBase.setBounds(50, 500, 550, 100);
        labelBase.setVisible(true);
        this.getPanelIngresar().add(labelBase);

        botonSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                iniciarSesion(campoUsuario.getText(),campoContraseña.getText());
            }
        });
    }

    public void iniciarSesion(String nombre, String contraseña){
        acceso.login("usuarios", nombre, contraseña);
    }
    public static void main(String [] args){
        Login login = new Login(600,600, "Iniciar Sesion");

    }
}
