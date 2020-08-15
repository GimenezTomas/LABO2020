package restaurantes;

import hotel.Reserva;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
import javax.swing.*;

public class Restaurante {
    private HashSet<Mesa> mesas = new HashSet<>();
    private HashSet<Plato> platos = new HashSet<>();
    private ArrayList<Pedido> pedidos = new ArrayList<>();
    //GETTERS && SETTERS

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public HashSet<Mesa> getMesas() {
        return mesas;
    }

    public void setMesas(HashSet<Mesa> mesas) {
        this.mesas = mesas;
    }

    public HashSet<Plato> getPlatos() {
        return platos;
    }

    public void setPlatos(HashSet<Plato> platos) {
        this.platos = platos;
    }

    public void incVecesPedido(HashMap<String, Integer> pedido){
        for(Plato plato: this.platos){
            for(Map.Entry<String, Integer> pedidoAux: pedido.entrySet())
            {
                if(plato.getNombre().equals(pedidoAux.getKey()) && pedidoAux.getValue()>0){
                    plato.setVecesPedido(plato.getVecesPedido()+pedidoAux.getValue());
                }
            }
        }
    }
    public void cleanPanel(JPanel panelIngresar, JLabel labelIngresar, JTextField textField){
        for (int i = 0; i < panelIngresar.getComponents().length ; i++) {
            if (panelIngresar.getComponent(i).getName() != null) {
                if (!panelIngresar.getComponent(i).getName().equals(labelIngresar.getName()) && !panelIngresar.getComponent(i).getName().equals(textField.getName())) {
                    panelIngresar.remove(panelIngresar.getComponent(i));
                    i--;
                }
                else
                {
                    panelIngresar.getComponent(i).setVisible(false);
                }
            }
            else
            {
                panelIngresar.remove(panelIngresar.getComponent(i));
                i--;
            }
        }
    }
    public void insertarPedido(Pedido pedido, Integer mesa){
        for(Mesa mesaAux: this.mesas)
        {
            if(mesaAux.getnMesa()==mesa)
            {
                mesaAux.getMesaPedidos().add(pedido);
            }
        }
        this.pedidos.add(pedido);
    }
    public void añadirPedido(JFrame ventana, JPanel panelMenu, JPanel panelFeedBack, JPanel panelIngresar, JButton boton10, JButton boton11, JTextField textField, JLabel labelIngresar, JLabel labelFeedBack) {

        JButton botonIngresar = new JButton("INGRESAR");
        botonIngresar.setBounds(ventana.getWidth()/2-boton10.getWidth()-10, boton10.getY()+30, boton10.getWidth(), boton10.getHeight());
        botonIngresar.setVisible(true);
        panelIngresar.add(botonIngresar);
        JTextField textFieldMesa = new JTextField();

        textFieldMesa.setText("placeholder");
        textFieldMesa.setSize(500,50);
        textFieldMesa.setLocation(ventana.getWidth()/2-textFieldMesa.getWidth()/2, ventana.getHeight()/2);
        textFieldMesa.setVisible(true);
        panelIngresar.add(textFieldMesa);

        JLabel labelMesa = new JLabel();
        labelMesa.setVisible(true);
        labelMesa.setSize(500, 50);
        labelMesa.setText("Ingrese la mesa deseada");
        labelMesa.setLocation(ventana.getWidth()/2-labelMesa.getWidth()/2, ventana.getHeight()/2-50);
        panelIngresar.add(labelMesa);

        /*boton10.setVisible(true);
        panelIngresar.add(boton10);*/

        panelIngresar.setVisible(true);
        ventana.add(panelIngresar);

        final HashSet<Plato> platosClon = (HashSet<Plato>) this.platos.clone();

        botonIngresar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //System.out.println("Sigo aca igual"); pregunta5
                int vueltas=0;
                HashMap<String, Integer> pedido = new HashMap<>();// nombre plato/cantidad

                final int mesa = Integer.parseInt(textFieldMesa.getText());
                if(!comprobarMesa(mesa)) {

                    ventana.remove(panelIngresar);
                    panelIngresar.setVisible(false);

                    labelFeedBack.setText("La mesa no existe o esta desocupada");
                    labelFeedBack.setVisible(true);
                    boton11.setText("SALIR");
                    boton11.setVisible(true);
                    panelFeedBack.add(boton11);

                    panelFeedBack.setVisible(true);
                    ventana.add(panelFeedBack);
                }
                else{
                    ArrayList<JSpinner> spinners = new ArrayList<>();
                    JButton botonSalir = new JButton("SALIR");
                    botonSalir.setBounds(ventana.getWidth()/2-boton10.getWidth()-10, boton10.getY()+30, boton10.getWidth(), boton10.getHeight());
                    botonSalir.setVisible(true);
                    panelIngresar.add(botonSalir);

                    JButton botonAgregar = new JButton("AÑADIR");
                    botonAgregar.setBounds(ventana.getWidth()/2+10, boton10.getY()+30, boton10.getWidth(), boton10.getHeight());
                    botonAgregar.setVisible(true);
                    panelIngresar.add(botonAgregar);
                    botonIngresar.setVisible(false);
                    //boton10.setVisible(false);
                    textFieldMesa.setVisible(false);
                    labelMesa.setVisible(false);
                    for (Plato platoAux: platosClon) {
                        vueltas++;
                        JLabel labelCantidad = new JLabel(platoAux.getNombre());
                        labelCantidad.setBounds(ventana.getWidth()/2-170, 80*vueltas, 500, 40);
                        labelCantidad.setVisible(true);
                        labelCantidad.setName("label"+platoAux.getNombre());
                        panelIngresar.add(labelCantidad);
                        JSpinner spinnerPlato = new JSpinner();
                        spinnerPlato.setBounds(ventana.getWidth()/2, 80*vueltas, 250, 40);
                        spinnerPlato.setVisible(true);
                        spinnerPlato.setName("spinner"+platoAux.getNombre());
                        spinnerPlato.setModel(new SpinnerNumberModel(0, 0, null, 1));
                        panelIngresar.add(spinnerPlato);
                        spinners.add(spinnerPlato);

                    }
                    botonSalir.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            ventana.remove(panelIngresar);
                            panelIngresar.setVisible(false);
                            cleanPanel(panelIngresar, labelIngresar, textField);
                            ventana.add(panelMenu);
                            panelMenu.setVisible(true);
                        }
                    });
                    botonAgregar.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            ventana.remove(panelIngresar);
                            panelIngresar.setVisible(false);

                            labelFeedBack.setVisible(true);
                            labelFeedBack.setText("El pedido se realizo correctamente");
                            boton11.setVisible(true);
                            panelFeedBack.add(boton11);

                            panelFeedBack.setVisible(true);
                            ventana.add(panelFeedBack);

                            boolean existePedido=false;
                            for(JSpinner spinner: spinners){
                                String valorSpinner = spinner.getValue()+"";
                                int valorSpinnerInt = Integer.parseInt(valorSpinner);
                                if (valorSpinnerInt > 0){
                                    pedido.put(spinner.getName().substring(7), valorSpinnerInt);
                                    existePedido=true;
                                }
                            }
                            if (existePedido){
                                incVecesPedido(pedido);
                                Pedido pedido1 = new Pedido(pedido);
                                insertarPedido(pedido1, mesa);
                                boton11.setText("SALIR");

                                ventana.remove(panelIngresar);
                                panelIngresar.setVisible(false);

                                cleanPanel(panelIngresar, labelIngresar, textField);
                            }
                        }
                    });
                }
            }
        });
    }

    public boolean comprobarMesa(int mesa) {
        for (Mesa mesaAux : this.mesas) {
            if (mesaAux.getnMesa() == mesa && !mesaAux.isOcupada()) {
                return false;
            }
        }
        return true;
    }

    public String comprobarPlato(String plato)/*Arreglar para no tener que poner /*todo dos veces*/ {
        Scanner scanner = new Scanner(System.in);
        while (0 == 0) {
            int contador = this.platos.size();
            for (Plato plato1 : this.platos) {
                if (plato.equals(plato1.getNombre()) == false) {
                    contador--;
                } else {
                    break;//ver si funciona
                }
            }
            if (contador == 0) {
                System.out.println("El plato elegido no se ecuentra disponible, reingreselo.");
                plato = scanner.nextLine();
            } else {
                break;
            }
        }
        return plato;
    }

    public String platoMasPedido() {
        int contador = 0;
        String platoGanador = "";
        for (Plato plato : this.getPlatos()) {
            if (plato.getVecesPedido() >= contador) {
                contador = plato.getVecesPedido();
                platoGanador = plato.getNombre();
            }

        }
        return (platoGanador + " veces pedido: " + contador);
    }

    public String platoMenosPedido() {
        int contador = 0;
        String platoGanador = "";
        for (Plato plato : this.getPlatos()) {
            if (contador==0){
                platoGanador=plato.getNombre();
                contador=plato.getVecesPedido();
            }
            else if (plato.getVecesPedido() <= contador) {
                contador = plato.getVecesPedido();
                platoGanador = plato.getNombre();
            }
        }
        return (platoGanador + " veces pedido: " + contador);
    }

    public String mesaMasOcupada() {
        int contador = 0, mesaGanadora = 0;
        for (Mesa mesa : this.getMesas()) {
            if (mesa.getnOcupaciones() >= contador) {
                contador = mesa.getnOcupaciones();
                mesaGanadora = mesa.getnMesa();
            }

        }
        for (Mesa me : this.mesas) {
            System.out.println("mesa "+me.getnMesa()+" ocupaciones "+me.getnOcupaciones());
        }
        return ("La mesa más pedida es la "+mesaGanadora + ", veces pedida: " + contador);
    }

    public void entregarPedido(JFrame ventana,JPanel panelMenu, JPanel panelFeedBack, JPanel panelIngresar, JButton boton10, JButton boton11, JTextField textField, JLabel labelIngresar, JLabel labelFeedBack) {
        JButton boton = new JButton("AGREGAR");
        boton.setBounds(ventana.getWidth()/2+10, boton10.getY()+30, boton10.getWidth(), boton10.getHeight());
        boton.setVisible(true);
        panelIngresar.add(boton);

        JButton botonOut = new JButton("SALIR");
        botonOut.setBounds(ventana.getWidth()/2-boton10.getWidth()-10, boton10.getY()+30, boton10.getWidth(), boton10.getHeight());
        botonOut.setVisible(true);
        panelIngresar.add(botonOut);

        labelIngresar.setText("Selecciona el pedido a entregar");
        labelIngresar.setLocation(ventana.getWidth()/2-labelIngresar.getWidth()/2, 20);
        labelIngresar.setVisible(true);

        JComboBox menuPedidos = new JComboBox();
        menuPedidos.setName("comboboxMenu");
        menuPedidos.setBounds(ventana.getWidth()/2-150, 120,300,100);

        for(Pedido pedidoAux : this.pedidos){
            if(!pedidoAux.isEntregado()){
                menuPedidos.addItem("PEDIDO N°"+pedidoAux.getnPedido());
            }
        }

        menuPedidos.setVisible(true);

        panelIngresar.add(menuPedidos);
        panelIngresar.setVisible(true);

        ventana.add(panelIngresar);

        final ArrayList<Pedido> pedidos = (ArrayList<Pedido>) this.pedidos.clone();
        botonOut.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ventana.remove(panelIngresar);
                panelIngresar.setVisible(false);
                cleanPanel(panelIngresar, labelIngresar, textField);
                ventana.add(panelMenu);
                panelMenu.setVisible(true);
            }
        });
        boton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                for (Pedido pedido : pedidos) {
                    if (pedido.getnPedido() == Integer.parseInt(menuPedidos.getSelectedItem().toString().substring(9))) {
                        pedido.setEntregado(true);
                        break;
                    }
                }
                ventana.remove(panelIngresar);
                panelIngresar.setVisible(false);

                labelFeedBack.setVisible(true);
                labelFeedBack.setText("El pedido se entrego correctamente");
                boton11.setVisible(true);
                panelFeedBack.add(boton11);

                panelFeedBack.setVisible(true);
                ventana.add(panelFeedBack);
                cleanPanel(panelIngresar, labelIngresar, textField);

            }
        });
    }

    public String proximoPedido() {
        String pedidoProx = "NO HAY PEDIDOS PENDIENTES";
        for (int i = 0; i <this.pedidos.size() ; i++) {
            if(!this.pedidos.get(i).isEntregado()){
                pedidoProx = ""+this.pedidos.get(i).getnPedido();
                break;
            }
        }
        return pedidoProx;
    }
    public void ocuparMesa(JFrame ventana, JPanel panelFeedBack, JPanel panelIngresar, JButton boton10, JButton boton11, JTextField textField, JLabel labelIngresar, JLabel labelFeedBack, boolean ocupar) {
        cleanPanel(panelIngresar, labelIngresar, textField);

        final HashSet<Mesa> mesasClon = (HashSet<Mesa>) this.mesas.clone();

        JButton botonIngresar = new JButton("INGRESAR");
        botonIngresar.setBounds(ventana.getWidth()/2-boton10.getWidth()-10, boton10.getY()+30, boton10.getWidth(), boton10.getHeight());
        botonIngresar.setVisible(true);
        panelIngresar.add(botonIngresar);

        JTextField textFieldMesa = new JTextField();
        textFieldMesa.setSize(500,50);
        textFieldMesa.setLocation(ventana.getWidth()/2-textFieldMesa.getWidth()/2, ventana.getHeight()/2);
        textFieldMesa.setVisible(true);
        panelIngresar.add(textFieldMesa);

        JLabel labelMesa = new JLabel();
        labelMesa.setVisible(true);
        labelMesa.setSize(500, 50);
        labelMesa.setText("Ingrese la mesa deseada");
        labelMesa.setLocation(ventana.getWidth()/2-labelMesa.getWidth()/2, ventana.getHeight()/2-50);
        panelIngresar.add(labelMesa);

        panelIngresar.setVisible(true);
        ventana.add(panelIngresar);

        botonIngresar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int vueltas=0;
                boolean ok=true;
                HashMap<String, Integer> pedido = new HashMap<>();// nombre plato/cantidad

                final int mesa = Integer.parseInt(textFieldMesa.getText());
                for (Mesa mesaAux : mesasClon) {
                    if (mesaAux.getnMesa() == mesa ) {
                        System.out.println("OCUPAR");
                        if ((ocupar && !mesaAux.isOcupada()) || !ocupar)
                        {
                            ok = false;
                            mesaAux.setOcupada(ocupar);
                        }
                        break;
                    }
                }

                ventana.remove(panelIngresar);
                panelIngresar.setVisible(false);

                if(ok && ocupar)
                {
                    labelFeedBack.setText("La mesa esta ocupada o no se encuentra");
                }
                else if(!ok && !ocupar){
                    labelFeedBack.setText("La mesa se desocupo");
                }
                else if(!ok && ocupar){
                    labelFeedBack.setText("La mesa se ocupo");
                }
                else{
                     labelFeedBack.setText("La mesa no existe o esta ocupada");
                 }

                labelFeedBack.setVisible(true);
                boton11.setText("SALIR");
                boton11.setVisible(true);
                panelFeedBack.add(boton11);

                panelFeedBack.setVisible(true);
                ventana.add(panelFeedBack);
            }
        });
    }
    public static void main(String[] args) {
        Restaurante restaurante = new Restaurante();

        restaurante.getPlatos().add(new Plato("Milanesa con puré de papas", 0));
        restaurante.getPlatos().add(new Plato("Ravioles rellenos con carne", 0));
        restaurante.getPlatos().add(new Plato("Pizza a la Piedra", 0));
        restaurante.getPlatos().add(new Plato("Polenta con salsa Fileto", 0));
        restaurante.getPlatos().add(new Plato("Arroz primavera", 0));

        Mesa mesa1 = new Mesa();
        Mesa mesa2 = new Mesa();
        Mesa mesa3 = new Mesa();
        Mesa mesa4 = new Mesa();
        Mesa mesa5 = new Mesa();
        Mesa mesa6 = new Mesa();

        restaurante.getMesas().add(mesa1);
        restaurante.getMesas().add(mesa2);
        restaurante.getMesas().add(mesa3);
        restaurante.getMesas().add(mesa4);
        restaurante.getMesas().add(mesa5);
        restaurante.getMesas().add(mesa6);

        mesa1.setOcupada(true);
        /*VENTANA*/
        JFrame ventana = new JFrame("RESTAURANTE");
        ventana.setSize(1350, 700);
        ventana.setLayout(null);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*PANELES*/
        JPanel panelMenu = new JPanel();
        panelMenu.setName("menu");
        panelMenu.setSize(1350, 700);
        panelMenu.setLayout(null);
        panelMenu.setVisible(true);
        ventana.add(panelMenu);

        JPanel panelIngresar = new JPanel();
        panelIngresar.setSize(1400, 700);
        panelIngresar.setLayout(null);
        panelIngresar.setVisible(false);
        panelIngresar.setName("ingresar");

        JPanel panelFeedBack = new JPanel();
        panelFeedBack.setSize(1400, 700);
        panelFeedBack.setLayout(null);
        panelFeedBack.setVisible(false);
        panelFeedBack.setName("feedback");

        /*LABELs*/

        JLabel nombreSistema = new JLabel();
        nombreSistema.setText("Sistema Restaurante");
        nombreSistema.setSize(150, 50);
        nombreSistema.setLocation(ventana.getWidth() / 2 - nombreSistema.getWidth() / 2, 100);
        panelMenu.add(nombreSistema);

        JLabel labelIngresar = new JLabel();
        labelIngresar.setSize(500, 50);
        labelIngresar.setLocation(ventana.getWidth() / 2 - labelIngresar.getWidth() / 2, ventana.getHeight() / 2 - 50);
        labelIngresar.setVisible(false);
        labelIngresar.setName("labelIngresar");
        panelIngresar.add(labelIngresar);

        JLabel labelFeedBack = new JLabel();
        labelFeedBack.setSize(500, 50);
        labelFeedBack.setLocation(ventana.getWidth() / 2 - labelFeedBack.getWidth() / 2, ventana.getHeight() / 2 - 50);
        labelFeedBack.setVisible(false);
        panelFeedBack.add(labelFeedBack);

        /*TEXTFIELDS*/

        JTextField textField = new JTextField();
        textField.setSize(500, 50);
        textField.setLocation(ventana.getWidth() / 2 - textField.getWidth() / 2, ventana.getHeight() / 2);
        textField.setVisible(false);
        textField.setName("textFieldIngresar");
        panelIngresar.add(textField);

        /*BOTONES*/

        JButton boton1 = new JButton("INGRESE LA MESA A OCUPAR");
        boton1.setLocation(150, 200);
        boton1.setSize(200, 50);
        boton1.setName("IngresarMesa");
        boton1.setVisible(true);
        panelMenu.add(boton1);

        JButton boton2 = new JButton("INGRESE LA MESA A DESOCUPAR");
        boton2.setSize(200, 50);
        boton2.setLocation((1200 / 2 - boton2.getWidth() / 2) + 100, 200);
        boton2.setName("DesocuparMesa");
        boton2.setVisible(true);
        panelMenu.add(boton2);

        JButton boton3 = new JButton("HACER UN PEDIDO");
        boton3.setSize(200, 50);
        boton3.setLocation(1250 - boton3.getWidth(), 200);
        boton3.setVisible(true);
        boton3.setName("HacerPedido");
        panelMenu.add(boton3);

        JButton boton4 = new JButton("PLATO MAS PEDIDO");
        boton4.setSize(200, 50);
        boton4.setLocation(150, 50 + boton1.getHeight() + boton1.getY());
        boton4.setVisible(true);
        boton4.setName("MasPedido");
        panelMenu.add(boton4);

        JButton boton5 = new JButton("PLATO MENOS PEDIDO");
        boton5.setSize(200, 50);
        boton5.setLocation((1200 / 2 - boton2.getWidth() / 2) + 100, 50 + boton2.getHeight() + boton2.getY());
        boton5.setVisible(true);
        boton5.setName("MenosPedido");
        panelMenu.add(boton5);

        JButton boton6 = new JButton("MESA MAS OCUPADA");
        boton6.setSize(200, 50);
        boton6.setLocation(1250 - boton3.getWidth(), 50 + boton3.getHeight() + boton3.getY());
        boton6.setVisible(true);
        boton6.setName("MesaMasPedida");
        panelMenu.add(boton6);

        JButton boton7 = new JButton("ENTREGAR PEDIDO");
        boton7.setSize(200, 50);
        boton7.setLocation(150, 50 + boton4.getHeight() + boton4.getY());
        boton7.setVisible(true);
        boton7.setName("EntregarPedido");
        panelMenu.add(boton7);

        JButton boton8 = new JButton("PROXIMO PEDIDO");
        boton8.setSize(200, 50);
        boton8.setLocation((1200 / 2 - boton2.getWidth() / 2) + 100, 50 + boton5.getHeight() + boton5.getY());
        boton8.setVisible(true);
        panelMenu.add(boton8);

        JButton boton9 = new JButton("VACIAR PEDIDOS-OCUPACIONES");
        boton9.setSize(200, 50);
        boton9.setLocation(1250 - boton3.getWidth(), 50 + boton6.getHeight() + boton6.getY());
        boton9.setVisible(true);
        panelMenu.add(boton9);

        JButton boton10 = new JButton("INGRESAR");
        boton10.setSize(200, 50);
        boton10.setLocation(ventana.getWidth() / 2 - boton10.getWidth() / 2, ventana.getHeight() / 2 + textField.getHeight() + 50);
        boton10.setVisible(false);

        JButton boton11 = new JButton();
        boton11.setSize(200, 50);
        boton11.setLocation(ventana.getWidth() / 2 - boton10.getWidth() / 2, ventana.getHeight() / 2 + textField.getHeight() + 50);
        boton11.setVisible(false);

        /* FUNCION OCUPAR*/
        boton1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                restaurante.ocuparMesa(ventana, panelFeedBack, panelIngresar, boton10, boton11, textField, labelIngresar, labelFeedBack, true);

                ventana.remove(panelMenu);
                panelMenu.setVisible(false);

                boton11.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        ventana.remove(panelFeedBack);
                        panelFeedBack.setVisible(false);
                        panelFeedBack.remove(boton11);
                        ventana.add(panelMenu);
                        panelMenu.setVisible(true);
                    }
                });
            }
        });
        /*FUNCION DESOCUPAR*/
        boton2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                restaurante.ocuparMesa(ventana, panelFeedBack, panelIngresar, boton10, boton11, textField, labelIngresar, labelFeedBack, false);

                ventana.remove(panelMenu);
                panelMenu.setVisible(false);

                boton11.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        ventana.remove(panelFeedBack);
                        panelFeedBack.setVisible(false);
                        panelFeedBack.remove(boton11);
                        ventana.add(panelMenu);
                        panelMenu.setVisible(true);
                    }
                });
            }
        });
        /*PEDIR*/
        boton3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                restaurante.cleanPanel(panelIngresar, labelIngresar, textField);

                ventana.remove(panelMenu);
                panelMenu.setVisible(false);

                restaurante.añadirPedido(ventana, panelMenu, panelFeedBack, panelIngresar, boton10, boton11, textField, labelIngresar, labelFeedBack);
                //System.out.println("SALI"); pregunta5
                boton11.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        ventana.remove(panelFeedBack);
                        panelFeedBack.setVisible(false);
                        panelFeedBack.remove(boton11);
                        ventana.add(panelMenu);
                        panelMenu.setVisible(true);
                    }
                });
            }
        });
        boton4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ventana.remove(panelMenu);
                panelMenu.setVisible(false);

                labelFeedBack.setText(restaurante.platoMasPedido());
                labelIngresar.setVisible(true);
                boton11.setVisible(true);
                panelFeedBack.add(boton11);

                panelFeedBack.setVisible(true);
                ventana.add(panelFeedBack);

                boton11.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        ventana.remove(panelFeedBack);
                        panelFeedBack.setVisible(false);
                        panelFeedBack.remove(boton11);
                        ventana.add(panelMenu);
                        panelMenu.setVisible(true);
                    }
                });
            }
        });
        boton5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ventana.remove(panelMenu);
                panelMenu.setVisible(false);

                labelFeedBack.setText(restaurante.platoMenosPedido());
                labelIngresar.setVisible(true);
                boton11.setText("SALIR");
                boton11.setVisible(true);
                panelFeedBack.add(boton11);

                panelFeedBack.setVisible(true);
                ventana.add(panelFeedBack);

                boton11.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        ventana.remove(panelFeedBack);
                        panelFeedBack.setVisible(false);
                        panelFeedBack.remove(boton11);
                        ventana.add(panelMenu);
                        panelMenu.setVisible(true);
                    }
                });
            }
        });
        boton6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ventana.remove(panelMenu);
                panelMenu.setVisible(false);

                labelFeedBack.setText(restaurante.mesaMasOcupada());
                labelIngresar.setVisible(true);
                boton11.setText("SALIR");
                boton11.setVisible(true);
                panelFeedBack.add(boton11);

                panelFeedBack.setVisible(true);
                ventana.add(panelFeedBack);

                boton11.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        ventana.remove(panelFeedBack);
                        panelFeedBack.setVisible(false);
                        panelFeedBack.remove(boton11);
                        ventana.add(panelMenu);
                        panelMenu.setVisible(true);
                    }
                });
            }
        });
        boton7.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                restaurante.cleanPanel(panelIngresar, labelIngresar, textField);

                ventana.remove(panelMenu);
                panelMenu.setVisible(false);

                restaurante.entregarPedido(ventana, panelMenu,panelFeedBack, panelIngresar, boton10, boton11, textField, labelIngresar, labelFeedBack);

                boton11.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        ventana.remove(panelFeedBack);
                        panelFeedBack.setVisible(false);
                        panelFeedBack.remove(boton11);
                        ventana.add(panelMenu);
                        panelMenu.setVisible(true);
                    }
                });
            }
        });
        boton8.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                ventana.remove(panelMenu);
                panelMenu.setVisible(false);

                labelFeedBack.setText("EL proximo pedido es: "+ restaurante.proximoPedido());
                panelFeedBack.add(boton11);
                labelFeedBack.setVisible(true);
                boton11.setText("SALIR");
                boton11.setVisible(true);

                panelFeedBack.setVisible(true);
                ventana.add(panelFeedBack);

                boton11.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        ventana.remove(panelFeedBack);
                        panelFeedBack.setVisible(false);
                        panelFeedBack.remove(boton11);
                        ventana.add(panelMenu);
                        panelMenu.setVisible(true);
                    }
                });
            }
        });
        boton9.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                for(Plato plato:restaurante.getPlatos())
                {
                    plato.setVecesPedido(0);
                }
                for(Mesa mesaaux:restaurante.getMesas())
                {
                    mesaaux.setnOcupaciones(0);
                }
                ventana.remove(panelMenu);
                panelMenu.setVisible(false);

                labelFeedBack.setText("Se vacio correctamente");
                panelFeedBack.add(boton11);
                labelFeedBack.setVisible(true);
                boton11.setText("SALIR");
                boton11.setVisible(true);

                panelFeedBack.setVisible(true);
                ventana.add(panelFeedBack);

                boton11.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        ventana.remove(panelFeedBack);
                        panelFeedBack.setVisible(false);
                        panelFeedBack.remove(boton11);
                        ventana.add(panelMenu);
                        panelMenu.setVisible(true);
                    }
                });
            }
        });
    }
}

