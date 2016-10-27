package Modelo;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class Modelo_BarSur extends ConexionBD_BarSur {

    /**
     * **************************************************************************************************
     * **************************************************************************************************
     * INSERT's
     * **************************************************************************************************
     * **************************************************************************************************
     */
    public void InsertPersona(String dni, String nombre, String domicilio, Boolean titular) {
        try {
            PreparedStatement st = this.getConexion().prepareStatement("insert into persona "
                    + "(dni_per, nombre_per, domicilio_per, titular) "
                    + "values (" + dni + " , " + nombre + " , " + domicilio + " , " + titular + ")");
            st.execute();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void InsertBar(int idbar, String nombrebar, String licefiscal, String domiciliobar, String fechaapertura, String horario, String diasapertura) {
        try {
            PreparedStatement st = this.getConexion().prepareStatement("insert into bar "
                    + "(id_bar, nombre_bar, licencia_fis, domicilio_bar, fecha_aper, horario, dias_apertura) "
                    + "values (" + idbar + " , " + nombrebar + " , " + licefiscal + " , " + domiciliobar + " , " + fechaapertura + " , " + horario + " , " + diasapertura + ")");
            st.execute();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void InsertExistencias(int idart, String nombre, int cantidad, double precio, int idbar) {//INVENTARIO
        try {
            PreparedStatement st = this.getConexion().prepareStatement("insert into existencias"
                    + "(id_art, nombre_art, cantidad, precio, bar_id)"
                    + "values (" + idart + " , " + nombre + " , " + cantidad + " , " + precio + " , " + idbar + ")");
            st.execute();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void InsertPedidos(int numpedido, Date fecha, String proveedor, String nombreart, int cantidad, double precio, int idbar, int codigoart) {
        try {
            PreparedStatement st = this.getConexion().prepareStatement("insert into pedidos"
                    + "(num_ped, fecha, proveedor, nombre_art, cantidad, precio, id_bar, codigo_art)"
                    + "values (" + numpedido + " , " + fecha + " , " + proveedor + " , " + nombreart + " , " + cantidad + " , " + precio + " , " + idbar + " , " + codigoart + ")");
            st.execute();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void InsertRecaudacion(int bar, Date fecha, double recautotal) {
        try {
            PreparedStatement st = this.getConexion().prepareStatement("insert into recaudacion"
                    + "(bar, fecha, rectotal)"
                    + "values (" + bar + "," + fecha + "," + recautotal + ")");
            st.execute();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void InsertTrabaja(String dni, int codigobar, String funcion) {
        try {
            PreparedStatement st = this.getConexion().prepareStatement("insert into trabaja"
                    + "(dni, codigo_bar, funcion)"
                    + "values (" + dni + "," + codigobar + "," + funcion + ",)");
            st.execute();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    /**
     * **************************************************************************************************
     * **************************************************************************************************
     * ALTER's
     * **************************************************************************************************
     * **************************************************************************************************
     */
    public void AlterPersona(String dni, String nombre, String domicilio, Boolean titular) {
        try {
            //dni_per, nombre_per, domicilio_per, funcion, titular
            PreparedStatement st = this.getConexion().prepareStatement("UPDATE persona "
                    + "SET nombre_per = " + nombre
                    + " , domicilio_per = " + domicilio
                    + " , titular = " + titular
                    + " WHERE dni_per = " + dni);
            st.execute();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void AlterBares(int idbar, String nombrebar, String licefiscal, String domiciliobar, String fechaapertura, String horario, String diasapertura) {
        try {
            //id_bar, nombre_bar, licencia_fis, domicilio_bar, fecha_aper, horario, dias_apertura
            PreparedStatement st = this.getConexion().prepareStatement("UPDATE bar "
                    + "SET nombre_bar = " + nombrebar
                    + " , licencia_fis = " + licefiscal
                    + " , domicilio_bar = " + domiciliobar
                    + " , fecha_aper = " + fechaapertura
                    + " , horario = " + horario
                    + " , dias_apertura = " + diasapertura
                    + " WHERE id_bar = " + idbar);
            st.execute();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void AlterPedidos(int numpedido, Date fecha, String proveedor, String nombreart, int cantidad, double precio, int idbar, int codigoart) {
        try {
            //num_ped, fecha, proveedor, nombre_art, cantidad, precio, id_bar, codigo_art
            PreparedStatement st = this.getConexion().prepareStatement("UPDATE pedidos "
                    + "SET fecha = " + fecha
                    + " , proveedor = " + proveedor
                    + " , nombre_art = " + nombreart
                    + " , cantidad = " + cantidad
                    + " , precio = " + precio
                    + " , id_bar = " + idbar
                    + " , codigo_art = " + codigoart
                    + " WHERE num_ped = " + numpedido);
            st.execute();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void AlterExistencias(int idart, String nombre, int cantidad, double precio, int idbar) {
        try {
            PreparedStatement st = this.getConexion().prepareStatement("UPDATE existencias "
                    + "SET nombre_art = " + nombre
                    + " , cantidad = " + cantidad
                    + " , precio = " + precio
                    + " , bar_id = " + idbar
                    + " WHERE id_art = " + idart);
            st.execute();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void AlterTrabaja(String dni, int codigobar, String funcion) {
        try {
            PreparedStatement st = this.getConexion().prepareStatement("UPDATE trabaja "
                    + "SET funcion = " + funcion
                    + " WHERE dni = " + dni + " AND codigo_bar = " + codigobar);
            st.execute();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * **************************************************************************************************
     * **************************************************************************************************
     * SELECT's
     * **************************************************************************************************
     * **************************************************************************************************
     *
     */
    public DefaultTableModel getTablaBar() {
        DefaultTableModel tablaBar = new DefaultTableModel();
        try {
            tablaBar.addColumn("IdBar");
            tablaBar.addColumn("Nombre");
            tablaBar.addColumn("Licencia");
            tablaBar.addColumn("Domicilio");
            tablaBar.addColumn("Fecha Apertura");
            tablaBar.addColumn("Horario");
            tablaBar.addColumn("Dias Apertura");
            String[] data = new String[7];
            PreparedStatement st = this.getConexion().prepareStatement("SELECT id_bar, nombre_bar, licencia_fis, domicilio_bar, fecha_aper, horario, dias_apertura FROM bar");
            ResultSet res = st.executeQuery();
            while (res.next()) {
                data[0] = res.getString("id_bar");
                data[1] = res.getString("nombre_bar");
                data[2] = res.getString("licencia_fis");
                data[3] = res.getString("domicilio_bar");
                data[4] = res.getString("fecha_aper");
                data[5] = res.getString("horario");
                data[6] = res.getString("dias_apertura");
                tablaBar.addRow(data);
            }
            res.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return tablaBar;
    }

    public DefaultTableModel getTablaPersona() {
        DefaultTableModel tablaPersona = new DefaultTableModel();
        try {
            tablaPersona.addColumn("Nombre");
            tablaPersona.addColumn("Domicilio");
            tablaPersona.addColumn("Dni");
            tablaPersona.addColumn("Titular");
            String[] data = new String[4];
            PreparedStatement st = this.getConexion().prepareStatement("SELECT dni_per, nombre_per, domicilio_per, titular FROM persona");
            ResultSet res = st.executeQuery();
            while (res.next()) {
                data[0] = res.getString("dni_per");
                data[1] = res.getString("nombre_per");
                data[2] = res.getString("domicilio_per");
                data[3] = res.getString("titular");
                tablaPersona.addRow(data);
            }
            res.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return tablaPersona;
    }

    public DefaultTableModel getTablaExistencias() {//INVENTARIO
        DefaultTableModel tablaExist = new DefaultTableModel();
        try {
            tablaExist.addColumn("IdArt");
            tablaExist.addColumn("Nombre");
            tablaExist.addColumn("Cantidad");
            tablaExist.addColumn("Precio");
            tablaExist.addColumn("Bar");
            String[] data = new String[5];
            PreparedStatement st = this.getConexion().prepareStatement("SELECT id_art, nombre_art, cantidad, precio, bar_id FROM existencias");
            ResultSet res = st.executeQuery();
            while (res.next()) {
                data[0] = res.getString("id_art");
                data[1] = res.getString("nombre_art");
                data[2] = res.getString("cantidad");
                data[3] = res.getString("precio");
                data[4] = res.getString("bar_id");
                tablaExist.addRow(data);
            }
            res.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return tablaExist;
    }

    public DefaultTableModel getTablaPedidos() {
        DefaultTableModel tablaPedido = new DefaultTableModel();
        try {
            tablaPedido.addColumn("N Pedido");
            tablaPedido.addColumn("Fecha");
            tablaPedido.addColumn("Proveedor");
            tablaPedido.addColumn("Nombre Articulo");
            tablaPedido.addColumn("Cantidad");
            tablaPedido.addColumn("Precio");
            tablaPedido.addColumn("Bar");
            tablaPedido.addColumn("Cod Articulo");
            String[] data = new String[8];
            PreparedStatement st = this.getConexion().prepareStatement("SELECT num_ped, fecha, proveedor, nombre_art, cantidad, precio, id_bar, codigo_art FROM pedidos");
            ResultSet res = st.executeQuery();
            while (res.next()) {
                data[0] = res.getString("num_ped");
                data[1] = res.getString("fecha");
                data[2] = res.getString("proveedor");
                data[3] = res.getString("nombre_art");
                data[4] = res.getString("cantidad");
                data[5] = res.getString("precio");
                data[6] = res.getString("id_bar");
                data[7] = res.getString("codigo_art");
                tablaPedido.addRow(data);
            }
            res.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return tablaPedido;
    }

    public DefaultTableModel getTablaRecaudacion() {
        DefaultTableModel tablaRecau = new DefaultTableModel();
        try {
            tablaRecau.addColumn("Bar");
            tablaRecau.addColumn("Fecha");
            tablaRecau.addColumn("Recaudacion Total");
            String[] data = new String[3];
            PreparedStatement st = this.getConexion().prepareStatement("SELECT bar, fecha, rectotal FROM recaudacion");
            ResultSet res = st.executeQuery();
            while (res.next()) {
                data[0] = res.getString("bar");
                data[1] = res.getString("fecha");
                data[2] = res.getString("rectotal");

                tablaRecau.addRow(data);
            }
            res.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return tablaRecau;
    }

    public DefaultTableModel getTablaTrabaja() {
        DefaultTableModel tablaTraba = new DefaultTableModel();
        try {
            tablaTraba.addColumn("DNI");
            tablaTraba.addColumn("Bar");
            tablaTraba.addColumn("Funcion");
            String[] data = new String[3];
            PreparedStatement st = this.getConexion().prepareStatement("SELECT dni_persona, codigo_bar, funcion FROM trabaja");
            ResultSet res = st.executeQuery();
            while (res.next()) {
                data[0] = res.getString("dni_persona");
                data[1] = res.getString("codigo_bar");
                data[2] = res.getString("funcion");

                tablaTraba.addRow(data);
            }
            res.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return tablaTraba;
    }

    /**
     * **************************************************************************************************
     * **************************************************************************************************
     * DELETE's
     * **************************************************************************************************
     * **************************************************************************************************
     */
    public void DeletePersona(String dni) {
        try {
            PreparedStatement st = this.getConexion().prepareStatement("delete from persona where dni_per = " + dni);
            st.execute();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void DeleteBar(int idbar) {
        try {
            PreparedStatement st = this.getConexion().prepareStatement("delete from bar where id_bar = " + idbar);
            st.execute();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void DeleteExistencias(int idart) {
        try {
            PreparedStatement st = this.getConexion().prepareStatement("delete from existencias where id_art = " + idart);
            st.execute();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void DeletePedidos(int numpedido) {
        try {
            PreparedStatement st = this.getConexion().prepareStatement("delete from pedidos where num_ped = " + numpedido);
            st.execute();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void DeleteRecaudacion(int bar, String fecha) {
        try {
            PreparedStatement st = this.getConexion().prepareStatement("delete from recaudacion where bar = " + bar + " AND fecha = " + fecha);
            st.execute();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void DeleteTrabaja(String dni, int idbar) {
        try {
            PreparedStatement st = this.getConexion().prepareStatement("delete from trabaja where num_ped = " + dni + " AND id_bar = " + idbar);
            st.execute();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
