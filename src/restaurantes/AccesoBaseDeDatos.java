package restaurantes;

import java.sql.*;
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

    public void connect(String user, String password){

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

        consulta += " (idOcupaciones, Fecha, Mesa_idMesa) values (" + idOcupaciones + ", " + "\"" + fecha + "\"" + ", " + idMesa + ");";

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

    public static String mensaje = "";
}
