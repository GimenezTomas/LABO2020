package restaurantes;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

public class AccesoBaseDeDatos {
    private Connection connection;
    private  String nombreBase;
    private HashSet<String> nombreTablas;

    public AccesoBaseDeDatos( String nombreBase, HashSet<String> nombreTablas){
        this.nombreBase = nombreBase;
        this.nombreTablas = nombreTablas;
    }

    public void connect(String user, String password) throws SQLException {

        String url = "jdbc:mysql://localhost:3306/"+this.nombreBase;

        try{
            connection = DriverManager.getConnection(url, user, password);

            if(connection != null){
                System.out.println("Se conecto correctamente a la base");
            }
            else{
                System.out.println("La conexion con la base de datos fallo");
            }

        }catch (SQLException ex){
            ex.printStackTrace();
            //si no anda puede pero tampoco tira error puede ser por la zona horaria poner en mysql SET GLOBAL time_zone = '-3:00';
        }
    }
/*\*/
    public void updateMesa(int id, boolean estado){
        String consulta = "UPDATE mesa SET ocupada="+estado+" WHERE idMesa="+id+";";

        try{
            PreparedStatement sentenciaSQL = connection.prepareStatement(consulta);
            int result = sentenciaSQL.executeUpdate();

            if(result > 0){
                mensaje = "El estado de la mesa se actualizo correctamente";
            }else{
                mensaje = "ERROR al actualizar la mesa";
            }

            sentenciaSQL.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    public void ingresarPlato_has_Pedido(int idPedido, String nombrePlato, int cantidadPlato){
        String consulta = "INSERT INTO plato_has_pedido (Plato_nombre, Pedido_idPedido, cantidad) VALUES("+"\""+nombrePlato+"\", "+idPedido+", "+cantidadPlato+");";
        try{
            PreparedStatement sentenciaSQL = connection.prepareStatement(consulta);
            int result = sentenciaSQL.executeUpdate();

            if(result > 0){
                mensaje = "El estado de la mesa se actualizo correctamente";
            }else{
                mensaje = "ERROR al actualizar la mesa";
            }

            sentenciaSQL.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    public void ingresarPedido(HashMap<String, Object> values){
        System.out.println("dale perri");
        String consulta = "INSERT INTO pedido";
        int id = Integer.parseInt(values.get("id").toString());
        int idOcupacion = Integer.parseInt(values.get("idOcupacion").toString());
        boolean entregado = false;
        String fecha = values.get("fecha").toString();

        consulta += " (idPedido, entregado, fecha, Restaurante_nombre, Ocupaciones_idOcupaciones) values ("+ id + ", " + entregado + ", "+"\""+fecha+"\""+", "+"\""+this.nombreBase+"\"" +", "+idOcupacion +");";

        try{
            PreparedStatement sentenciaSQL = connection.prepareStatement(consulta);
            int result = sentenciaSQL.executeUpdate();

            if(result > 0){
                mensaje = "El nuevo pedido se registro correctamente";
            }else{
                mensaje = "ERROR al registrar el pedido";
            }

            sentenciaSQL.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    public void ingresarOcupacion(HashMap<String, Object> values) {
        String consulta = "INSERT INTO Ocupaciones";
        String fecha = values.get("fecha").toString();
        int idMesa = Integer.parseInt(values.get("idMesa").toString());
        int idOcupaciones = Integer.parseInt(values.get("idOcupacion").toString());

        consulta += " (idOcupaciones, Fecha, Mesa_idMesa, restaurante_nombre) values (" + idOcupaciones + ", " + "\"" + fecha + "\"" + ", " + idMesa +", "+"\""+this.nombreBase+"\""+");";
        System.out.println(consulta);
        try {
            PreparedStatement sentenciaSQL = connection.prepareStatement(consulta);
            int result = sentenciaSQL.executeUpdate();

            if (result > 0) {
                mensaje = "La nueva ocupacion se registro correctamente";
            } else {
                mensaje = "ERROR al registrar la ocupacion";
            }

            sentenciaSQL.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void ingresarMesa(HashMap<String, Object> values){
        String consulta = "INSERT INTO mesa";
        int id = Integer.parseInt(values.get("idMesa").toString());

        consulta += " (idMesa, ocupada, Restaurante_nombre) values ("+ id + ", " + false + ", "+"\""+this.nombreBase+"\"" + ");";

        try{
            PreparedStatement sentenciaSQL = connection.prepareStatement(consulta);
            int result = sentenciaSQL.executeUpdate();

            if(result > 0){
                mensaje = "La nueva mesa se registro correctamente";
            }else{
                mensaje = "ERROR al registrar la mesa";
            }

            sentenciaSQL.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }

    }
    public void ingresarPlato (HashMap<String, Object> values){

        String consulta = "INSERT INTO plato";
        String nombre = "\"" + values.get("nombre").toString() + "\"";
        float precio = Float.parseFloat(values.get("precio").toString());

        consulta += " (nombre, precio, Restaurante_nombre) values ("+ nombre + ", " + precio + ", "+"\""+this.nombreBase+"\"" + ");";
        //System.out.println(consulta);
        try{
            PreparedStatement sentenciaSQL = connection.prepareStatement(consulta);
            int result = sentenciaSQL.executeUpdate();

            if(result > 0){
                mensaje = "El nuevo plato se registro correctamente";
            }else{
                mensaje = "ERROR al registrar el plato";
            }

            sentenciaSQL.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    public void recuperarDatosMesa(String nombreTabla, HashSet<Mesa> mesas){
        int id = 0;
        boolean ocupada;

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + nombreTabla + " WHERE Restaurante_nombre = "+"\""+this.nombreBase+"\"" +";");
            while (resultSet.next()) {
                id = resultSet.getInt("idMesa");
                ocupada = resultSet.getBoolean("ocupada");
                System.out.println(id + " " + ocupada);
                mesas.add(new Mesa(id, ocupada));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void recuperarDatosPedidos(String nombreTabla, ArrayList<Pedido> pedidos){
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + nombreTabla + " WHERE Restaurante_nombre="+"\""+this.nombreBase+"\"" );
            while (resultSet.next()) {
                int idPedido = resultSet.getInt("idPedido");
                boolean entregado = resultSet.getBoolean("ocupada");
                String fecha = resultSet.getString("fecha");
                int nOcupacion = resultSet.getInt("Ocupaciones_idOcupaciones");
                ResultSet resultSet1 = statement.executeQuery("SELECT * FROM plato_has_pedido WHERE Pedido_idPedido="+idPedido);
                HashMap<String , Integer> platos = new HashMap<>();
                while (resultSet1.next()){
                    platos.put(resultSet1.getString("Plato_nombre"), resultSet1.getInt("cantidad"));
                }
                pedidos.add(new Pedido(platos, nOcupacion, idPedido, fecha, entregado));
                System.out.println(idPedido + " " + entregado + " "+ fecha + " " +nOcupacion);
                //seguir hay que hacer lo mismo con ocupacion para sacar los platos
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void recuperarDatosPlato(String nombreTabla, HashSet<Plato> platos){
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + nombreTabla + " WHERE Restaurante_nombre="+"\""+this.nombreBase+"\"" );
            while (resultSet.next()) {
                String nombre = resultSet.getString("nombre");
                float precio = resultSet.getFloat("precio");
                System.out.println(nombre + " " + precio);
                platos.add(new Plato(nombre, precio));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void recuperarDatosOcupacion(String nombreTabla, ArrayList<Ocupacion> ocupaciones){
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + nombreTabla + " WHERE Restaurante_nombre="+"\""+this.nombreBase+"\"" );
            while (resultSet.next()) {
                int idOcupaciones = resultSet.getInt("idOcupaciones");
                String fecha = resultSet.getString("fecha");
                int mesa = resultSet.getInt("Mesa_idMesa");
                System.out.println(idOcupaciones + " " + fecha + " " + mesa);
                ocupaciones.add(new Ocupacion(mesa, fecha, idOcupaciones));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void login(String nombreTabla, String nombreUsuario, String contraseña){
    String consulta = "SELECT * FROM "+nombreTabla+" WHERE idUsuarios = "+"\""+nombreUsuario+"\" AND password = "+"\""+contraseña+"\";";
        System.out.println(consulta);
    try{
        PreparedStatement sentenciaSQL = connection.prepareStatement(consulta);
        int result = sentenciaSQL.executeUpdate();

        if(result > 0){
            mensaje = "El estado de la mesa se actualizo correctamente";
        }else{
            mensaje = "ERROR al actualizar la mesa";
        }

        sentenciaSQL.close();
    }catch(SQLException ex){
        ex.printStackTrace();
    }
    }
    public static String mensaje = "";
}
