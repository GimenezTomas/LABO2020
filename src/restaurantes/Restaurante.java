package restaurantes;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.*;

public class Restaurante {
    private HashSet<Mesa> mesas = new HashSet<>();
    private HashSet<Plato> platos = new HashSet<>();
    private ArrayList<Pedido> pedidos = new ArrayList<>();
    private String nombre;
    private AccesoBaseDeDatos acceso;
    private ArrayList<Ocupacion> ocupaciones = new ArrayList<>();
    public static SimpleDateFormat dateFormatSQL = new SimpleDateFormat("yyyy-MM-dd");

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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //CONSTRUCTOR

    public Restaurante (String nombre){
        HashSet<String> tablas = new HashSet<>();
        tablas.add("mesa");
        tablas.add("pedido");
        tablas.add("plato");
        tablas.add("restaurante");
        tablas.add("plato_has_pedido");
        this.acceso = new AccesoBaseDeDatos("restaurante", tablas);
        this.nombre = nombre;
        acceso.connect("root", "Alumno:TomasGimenez2002");
    }

    public void cleanPanel(JPanel panelIngresar/*, JLabel labelIngresar, JTextField textField*/, Component components[]){
        for (int i = 0; i < panelIngresar.getComponents().length ; i++) {
            if (panelIngresar.getComponent(i).getName() != null) {
                boolean check=true;
                for (Component componente : components){
                    if (panelIngresar.getComponent(i).getName().equals(componente.getName())) {
                        check = false;
                    }
                }
                if(check){
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

        panelIngresar.setVisible(true);
        ventana.add(panelIngresar);

        final HashSet<Plato> platosClon = (HashSet<Plato>) this.platos.clone();
        final ArrayList<Pedido> pedidoCopia = this.pedidos;
        final ArrayList<Ocupacion> ocupacionesCopia = this.ocupaciones;

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
                            cleanPanel(panelIngresar, new Component[]{labelIngresar, textField});
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
                                for (int i = 0; i <=ocupacionesCopia.size()-1 ; i++) {
                                    if (ocupacionesCopia.get(i).getnMesa() == mesa) {
                                        Pedido pedido1 = new Pedido(pedido, ocupacionesCopia.get(i).getnOcupacion());
                                        pedidoCopia.add(pedido1);
                                        HashMap<String, Object> newPedido = new HashMap<>();
                                        newPedido.put("id", pedido1.getnPedido());
                                        newPedido.put("fecha", pedido1.getFecha());
                                        newPedido.put("idOcupacion", pedido1.getnOcupacion());
                                        acceso.ingresarPedido(newPedido);
                                        for(Map.Entry<String, Integer> plato: pedido1.getPlatos().entrySet()){
                                            acceso.ingresarPlato_has_Pedido(pedido1.getnPedido(), plato.getKey(), plato.getValue());
                                        }
                                    }
                                }
                                boton11.setText("SALIR");

                                ventana.remove(panelIngresar);
                                panelIngresar.setVisible(false);

                                cleanPanel(panelIngresar, new Component[]{labelIngresar, textField});
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

    public void platoMasPedido(JFrame ventana,JPanel panelMenu,JPanel panelIngresar,JButton boton11, JLabel labelFeedBack, boolean masMenos) {

        JButton botonAgr= new JButton("INGRESAR");
        botonAgr.setBounds(ventana.getWidth()/2+10, boton11.getY(), boton11.getWidth(), boton11.getHeight());
        botonAgr.setVisible(true);
        panelIngresar.add(botonAgr);

        JButton botonSalir = new JButton("SALIR");
        botonSalir.setBounds(ventana.getWidth()/2-boton11.getWidth()-10, boton11.getY(), boton11.getWidth(), boton11.getHeight());
        botonSalir.setVisible(true);
        panelIngresar.add(botonSalir);

        JComboBox fechas = new JComboBox();
        fechas.setName("comboboxFechas");
        fechas.setBounds(ventana.getWidth()/2-150, 120,300,100);
        fechas.addItem(dateFormatSQL.format(new Date()));


        for(Pedido pedido: this.pedidos){
            boolean check = true;
            for (int i = 0; i <fechas.getItemCount() ; i++) {
                if (fechas.getItemAt(i)==pedido.getFecha()){
                    check=false;
                }
            }
            if (check){
                fechas.addItem(pedido.getFecha());
            }
        }

        fechas.setVisible(true);
        panelIngresar.add(fechas);
        panelIngresar.setVisible(true);
        ventana.add(panelIngresar);

        botonSalir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ventana.remove(panelIngresar);
                panelIngresar.setVisible(false);

                panelIngresar.removeAll();
                ventana.add(panelMenu);
                panelMenu.setVisible(true);
            }
        });
        botonAgr.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                final HashMap<String, Integer> platosAux = new HashMap<>();
                for (Plato plato : platos){
                    platosAux.put(plato.getNombre(), 0);
                }
                for(Pedido pedido: pedidos){
                    if (pedido.getFecha().equals(fechas.getSelectedItem())){
                        for(Map.Entry<String, Integer> plato: pedido.getPlatos().entrySet())
                        {
                            platosAux.put(plato.getKey(), platosAux.get(plato.getKey())+plato.getValue());
                        }
                    }
                }
                String platoGanador  = "";
                int contador = 0;
                for(Map.Entry<String, Integer> plato: platosAux.entrySet()){
                    if (masMenos) {
                        if (plato.getValue() >= contador) {
                            platoGanador = plato.getKey();
                            contador = plato.getValue();
                        }
                    }
                    else
                    {
                        if (plato.getValue() <= contador || contador == 0){
                            platoGanador = plato.getKey();
                            contador = plato.getValue();
                        }
                    }
                }
                if (masMenos) {
                    labelFeedBack.setText("El pedido mas solicitado fue " + platoGanador + ", pedidos: " + contador);
                }
                else {
                    labelFeedBack.setText("El pedido menos solicitado fue " + platoGanador + ", pedidos: " + contador);
                }
                labelFeedBack.setVisible(true);
                boton11.setVisible(true);

                panelIngresar.removeAll();
                panelIngresar.add(botonSalir);
                panelIngresar.add(labelFeedBack);
            }
        });
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
                cleanPanel(panelIngresar, new Component[]{labelIngresar, textField});
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
                cleanPanel(panelIngresar, new Component[]{labelIngresar, textField});
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

    public void agregarPlato(String nombre, Float precio){
        this.platos.add(new Plato(nombre, precio));
        HashMap<String, Object> platoNuevo = new HashMap<>();
        platoNuevo.put("nombre", nombre);
        platoNuevo.put("precio", precio);
        platoNuevo.put("Restaurante_nombre", this.nombre);
        acceso.ingresarPlato(platoNuevo);
        System.out.println(AccesoBaseDeDatos.mensaje);
    }
    public void ocuparMesa(JFrame ventana, JPanel panelFeedBack, JPanel panelIngresar, JButton boton10, JButton boton11, JTextField textField, JLabel labelIngresar, JLabel labelFeedBack, boolean ocupar) {
        cleanPanel(panelIngresar, new Component[]{labelIngresar, textField});

        final HashSet<Mesa> mesasClon = (HashSet<Mesa>) this.mesas.clone();
        final ArrayList<Ocupacion> ocupacionesClon = this.ocupaciones;//probar si cambia el valor

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
                    acceso.updateMesa(mesa, false);
                }
                else if(!ok && ocupar){
                    labelFeedBack.setText("La mesa se ocupo");
                    ocupacionesClon.add(new Ocupacion(mesa));
                    HashMap<String, Object> newOcupacion = new HashMap<>();
                    newOcupacion.put("idOcupacion", ocupacionesClon.get(ocupacionesClon.size()-1).getnOcupacion());
                    newOcupacion.put("idMesa", mesa);
                    newOcupacion.put("fecha", ocupacionesClon.get(ocupacionesClon.size()-1).getFecha());
                    acceso.ingresarOcupacion(newOcupacion);
                    acceso.updateMesa(mesa, true);
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

    public void mesaMasOcupada(JFrame ventana, JPanel panelMenu,JPanel panelIngresar, JPanel panelFeedBack,JButton boton11, String textoBoton1, JLabel labelFeedBack, JLabel labelIngresar, JTextField textField){

        JButton botonAgr= new JButton(textoBoton1);
        botonAgr.setBounds(ventana.getWidth()/2+10, boton11.getY(), boton11.getWidth(), boton11.getHeight());
        botonAgr.setVisible(true);
        panelIngresar.add(botonAgr);

        JButton botonSalir = new JButton("SALIR");
        botonSalir.setBounds(ventana.getWidth()/2-boton11.getWidth()-10, boton11.getY(), boton11.getWidth(), boton11.getHeight());
        botonSalir.setVisible(true);
        panelIngresar.add(botonSalir);

        JComboBox fechas = new JComboBox();
        fechas.setName("comboboxFechas");
        fechas.setBounds(ventana.getWidth()/2-150, 120,300,100);
        fechas.addItem(dateFormatSQL.format(new Date()));


        for(Pedido pedido: this.pedidos){
            boolean check = true;
            for (int i = 0; i <fechas.getItemCount() ; i++) {
                if (fechas.getItemAt(i)==pedido.getFecha()){
                    check=false;
                }
            }
            if (check){
                fechas.addItem(pedido.getFecha());
            }
        }
        fechas.setVisible(true);
        panelIngresar.add(fechas);
        panelIngresar.setVisible(true);
        ventana.add(panelIngresar);

        final ArrayList<Pedido> pedidos = (ArrayList<Pedido>) this.pedidos.clone();
        final HashSet<Mesa> mesasClon = (HashSet<Mesa>) this.mesas.clone();
        botonSalir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ventana.remove(panelIngresar);
                panelIngresar.setVisible(false);

                cleanPanel(panelIngresar, new Component[]{labelIngresar});
                ventana.add(panelMenu);
                panelMenu.setVisible(true);
            }
        });
        botonAgr.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                HashMap<Integer, Integer> mesas = new HashMap<>();

                for(Mesa mesa : mesasClon){
                    mesas.put(mesa.getnMesa(), 0);
                }
                for (Ocupacion ocupacion: ocupaciones){
                    if (ocupacion.getFecha().equals(fechas.getSelectedItem())){
                        mesas.put(ocupacion.getnMesa(), mesas.get(ocupacion.getnMesa())+1);
                    }
                }

                int mesaGanadora = 1, contador = 0;

                for(Map.Entry<Integer, Integer> mesa: mesas.entrySet()){
                    if (mesa.getValue()>contador){
                        contador = mesa.getValue();
                        mesaGanadora = mesa.getKey();
                    }
                }

                panelIngresar.removeAll();
                labelIngresar.setText("La mesa más ocupada es "+mesaGanadora+" con "+contador+" ocupaciones");
                labelIngresar.setVisible(true);
                botonSalir.setVisible(true);
                panelIngresar.add(botonSalir);
                panelIngresar.add(labelIngresar);
            }
        });
    }
    public void agregarMesa(Mesa mesa){
        this.mesas.add(mesa);
        HashMap<String, Object> mesaNueva = new HashMap<>();
        mesaNueva.put("idMesa", mesa.getnMesa());
        acceso.ingresarMesa(mesaNueva);
        acceso.ingresarMesa(mesaNueva);
    }
    public static void main(String[] args) {
        Restaurante restaurante = new Restaurante("La cantina");

        restaurante.agregarPlato("Milanesa con puré de papas", 0.0f);
        restaurante.agregarPlato("Ravioles rellenos con carne", 0f);
        restaurante.agregarPlato("Pizza a la Piedra", 0f);
        restaurante.agregarPlato("Polenta con salsa Fileto", 0f);
        restaurante.agregarPlato("Arroz primavera", 0f);

        for (int i = 0; i < 6; i++) {
            restaurante.agregarMesa(new Mesa());
        }

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
        nombreSistema.setText(restaurante.getNombre());
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
        labelFeedBack.setName("labelFeedBack");
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

        JButton boton10 = new JButton("INGRESAR");
        boton10.setSize(200, 50);
        boton10.setLocation(ventana.getWidth() / 2 - boton10.getWidth() / 2, ventana.getHeight() / 2 + textField.getHeight() + 50);
        boton10.setVisible(false);

        JButton boton11 = new JButton();
        boton11.setSize(200, 50);
        boton11.setLocation(ventana.getWidth() / 2 - boton10.getWidth() / 2, ventana.getHeight() / 2 + textField.getHeight() + 50);
        boton11.setVisible(false);
        boton11.setName("boton11");

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
                restaurante.cleanPanel(panelIngresar, new Component[]{labelIngresar, textField});

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
                restaurante.cleanPanel(panelIngresar, new Component[]{labelIngresar, textField});
                restaurante.cleanPanel(panelFeedBack, new Component[]{labelFeedBack, boton11});
                ventana.remove(panelMenu);
                panelMenu.setVisible(false);

                restaurante.platoMasPedido(ventana, panelMenu, panelIngresar, boton11, labelFeedBack, true);

            }
        });
        boton5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ventana.remove(panelMenu);
                panelMenu.setVisible(false);

                restaurante.platoMasPedido(ventana, panelMenu, panelIngresar, boton11, labelFeedBack, false);

            }
        });
        boton6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                restaurante.mesaMasOcupada(ventana, panelMenu,panelIngresar, panelMenu, boton11, "INGRESAR", labelFeedBack, labelIngresar, textField);

                ventana.remove(panelMenu);
                panelMenu.setVisible(false);
            }
        });
        boton7.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                restaurante.cleanPanel(panelIngresar, new Component[]{labelIngresar, textField});

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
    }
}
