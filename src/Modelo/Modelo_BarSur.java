package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Modelo_BarSur extends ConexionBD_BarSur {

    //INSERT's
    public void InsertPersona(Persona persona) {
        try {
            PreparedStatement st = this.getConexion().prepareStatement("insert into persona (dni_per, nombre_per, domicilio_per, funcion, titular) values (?,?,?,?,?)");
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
            PreparedStatement st = this.getConexion().prepareStatement("insert into bar (id_bar, nombre_bar, licencia_fis, domicilio_bar, fecha_aper, horario, dias_apertura) values (?,?,?,?,?,?,?)");
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
            PreparedStatement st = this.getConexion().prepareStatement("insert into existencias (id_art, nombre_art, cantidad, precio, bar_id) values (?,?,?,?,?)");
            st.setString(1, existencias.getIdArt().toString());
            st.setString(2, existencias.getNombreArt());
//          st.setString(3, existencias.getCantidad());
//          st.setString(4, existencias.getPrecio());
//          st.setString(5, existencias.getBarId());

            st.execute();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void InsertPedidos(Pedidos pedidos) {
        try {
            PreparedStatement st = this.getConexion().prepareStatement("insert into pedidos (num_ped, fecha, proveedor, nombre_art, cantidad, precio, id_bar, codigo_art) values (?,?,?,?,?,?,?,?)");
            st.setString(1, pedidos.getNumPed().toString());
            st.setString(2, pedidos.getFecha().toString());
            st.setString(3, pedidos.getProveedor());
            st.setString(4, pedidos.getNombreArt());
//           st.setString(5, pedidos.getCantidad());
//            st.setString(6, pedidos.getPrecio());
//            st.setString(7, pedidos.getIdBar());
//            st.setString(8, pedidos.getCodigoArt());
            st.execute();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void InsertarRecaudacion(RecaudacionPK recaudacion) {

    }

    public void InsertarTrabaja(TrabajaPK trabaja) {

    }

    //SELECT's
    public ArrayList<Persona> SelectPersona() {
        ArrayList<Persona> LPerso = new ArrayList<>();
        ResultSet result = null;
        try {
            PreparedStatement st = this.getConexion().prepareStatement("select * from personas");
            result = st.executeQuery();
            while (result.next()) {
                Persona per = new Persona();
                //          per.setDniPer(result.getInt("id"));
                per.setDomicilioPer(result.getString("Nif"));
                per.setNombrePers(result.getString("Nombre"));
                per.setFuncion(result.getString("Apellido"));
                //         per.setTitular(result.getString("Fecha_Nacimiento"));
                //         per.setTrabaja(result.getString(""));
                LPerso.add(per);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return LPerso;
    }

}
