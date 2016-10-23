package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author esaup
 */
public class ConexionBD_BarSur {

    private String url = ".\\biblioteca.db3";
    private Connection connect;

    public ConexionBD_BarSur() {
        try {
            Class.forName("org.sqlite.JDBC");
            connect = DriverManager.getConnection("jdbc:sqlite:" + url);

            System.out.println("Conectado");
        } catch (SQLException se) {
            se.printStackTrace();
            System.out.println("No se ha realizado la conexion");
        } catch (ClassNotFoundException ce) {
            ce.printStackTrace();
            System.out.println("No se encuentra el conector");
        }
    }

    public Connection getConexion() {
        return this.connect;
    }

    public void InsertPersona(Persona persona) {
        try {
            PreparedStatement st = connect.prepareStatement("insert into persona (dni_per, nombre_per, domicilio_per, funcion, titular) values (?,?,?,?,?)");
            st.setString(1, persona.getDniPer());
            st.setString(2, persona.getNombrePers());
            st.setString(3, persona.getDomicilioPer());
            st.setString(4, persona.getFuncion());
            st.execute();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void InsertBar(Bar bar) {
        try {
            PreparedStatement st = connect.prepareStatement("insert into bar (id_bar, nombre_bar, licencia_fis, domicilio_bar, fecha_aper, horario, dias_apertura) values (?,?,?,?,?,?,?)");
            st.setString(1, bar.getIdBar().toString());
            st.setString(2, bar.getNombreBar());
            st.setString(3, bar.getLicenciaFis());
            st.setString(4, bar.getDomicilioBar());
            st.setString(5, bar.getFechaAper().toString());
            st.setString(6, bar.getHorario());
            st.setString(7, bar.getDiasApertura());
            st.execute();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void InsertExistencias(Existencias existencias) {//INVENTARIO
        try {
            PreparedStatement st = connect.prepareStatement("insert into existencias (id_art, nombre_art, cantidad, precio, bar_id) values (?,?,?,?,?)");
            st.setString(1, existencias.getIdArt().toString());
            st.setString(2, existencias.getNombreArt());
//            st.setString(3, existencias.getCantidad());
//           st.setString(4, existencias.getPrecio());
//          st.setString(5, existencias.getBarId());

            st.execute();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void InsertBar(Pedidos pedidos) {
        try {
            PreparedStatement st = connect.prepareStatement("insert into pedidos (num_ped, fecha, proveedor, nombre_art, cantidad, precio, id_bar, codigo_art) values (?,?,?,?,?,?,?,?)");
            st.setString(1, pedidos.getNumPed().toString());
            st.setString(2, pedidos.getFecha().toString());
            st.setString(3, pedidos.getProveedor());
            st.setString(4, pedidos.getNombreArt());
//            st.setString(5, pedidos.getCantidad());
//            st.setString(6, pedidos.getPrecio());
//            st.setString(7, pedidos.getIdBar());
//            st.setString(8, pedidos.getCodigoArt());
            st.execute();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    //No hay clase recaudacion :S
    //public void InsertRecaudacion(Recaudacion recaudacion) {    }
    public void InsertTrabaja(Trabaja trabaja) {//no entiendo las clases Trabaja y TrabajaPK
        try {
            PreparedStatement st = connect.prepareStatement("insert into trabaja (id_bar, id_emple, funcion) values (?,?,?)");

            /*st.setString(1, trabaja.get());
             st.setString(2, trabaja.get());
             st.setString(3, trabaja.get());
             st.execute();*/
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

}
