package interfazGrafica;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class appBoton {
    public static  void main(String [] args)
    {
        JFrame ventana = new JFrame();
        ventana.setLayout(null);
        ventana.setSize(500, 500);
        ventana.setVisible(true);

        JLabel p1 = new JLabel();
        p1.setText("HOLA");
        p1.setSize(500, 100);
        p1.setLocation(5,0);

        JLabel p2 = new JLabel();
        p2.setText("CHAU");
        p2.setSize(500, 100);
        p2.setLocation(5,125);

        JButton boton = new JButton("DUPLICAR");
        boton.setSize(200, 50);
        boton.setLocation(ventana.getWidth()/2-boton.getWidth()/2, 250);

        ventana.add(p1);
        ventana.add(p2);
        ventana.add(boton);
        boton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //super.mouseClicked(e);
                p1.setText(p1.getText()+" "+p1.getText());
                p2.setText(p2.getText() + " " + p2.getText());

            }
        });

    }
}
