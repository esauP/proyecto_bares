/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author esaup
 */
public class Modelo_Inventario extends ConexionBD_BarNorte{
     public TableModel CargaTablaInventario() {
        DefaultTableModel tabla = new DefaultTableModel();
        Object[] columName = null;
        Object[][] data = null;
        int registros = 0;
        try {
            //llamamos a la funcion almacenada en la base de datos
            CallableStatement pstm = this.getConexion().prepareCall("{?=call Total_Existencias}");
            //detallamos que la variable de salida va a ser de tipo Integer
            pstm.registerOutParameter(1, Types.INTEGER);
            //ejecutamos la llamada a la funcion
            pstm.executeUpdate();
            //recuperamos el resultado y lo asignamos a una variable 
            registros = pstm.getInt(1);
        } catch (SQLException ex) {

        }

        try {
            //Preparas la llamada al procedimiento que te devuelve la consulta
            CallableStatement cstm = this.getConexion().prepareCall("{call Consulta_Existencias}");
            //Ejecutas el procedimiento
            ResultSet re = cstm.executeQuery();
            //Recoges los metadatos que te devuelve la consulta
            ResultSetMetaData rsp = re.getMetaData();

            int col = rsp.getColumnCount();
            columName = new String[col];

            for (int i = 1; i <= col; i++) {
                columName[i - 1] = rsp.getColumnName(i);
            }

            data = new String[registros][col];

            int j = 0;
            while (re.next()) {
                for (int h = 0; h < col; h++) {
                    data[j][h] = re.getString(columName[h].toString());

                }
                j++;
            }

        } catch (SQLException ex) {

        }

        tabla.setDataVector(data, columName);
        return tabla;
    }

    /**
     * Metodo para insertar personas en la bd
     *
     * @param nomart String nombre del ariculo
     * @param cant int cantidad
     * @param prec double precio
     * @param idbar int identificador del bar a añadir
     * @return int 0 y 1, 0 correcto, 1 error
     * @throws SQLException
     */
    public int InsertaArticulo(String nomart, int cant, double prec, int idbar) throws SQLException {
        int resultado = 1;
        try {
            //creamos la consulta
            CallableStatement cStmt = this.getConexion().prepareCall("{?=call Inserta_Existencias(?,?,?,?)}");
            //pasamos por parametro todos los valores a introducir
            cStmt.setString(2, nomart);
            cStmt.setInt(3, cant);
            cStmt.setDouble(4, prec);
            cStmt.setInt(5, idbar);
            cStmt.execute();//ejecutamos la consulta
            resultado = cStmt.getInt(1);//recogemos si ha tenido exito
            return resultado;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return resultado;
    }

    /**
     * Metodo para la modificacion de una persona dado su dni
     *
     * @param idart int identificador del articulo
     * @param idbar int identificador del bar
     * @param nombre String nombre del articulo
     * @param cant int cantidad
     * @param prec double precio
     * @return int 0 y 1, 0 correcto, 1 error
     * @throws SQLException
     */
    public int ModificaArticulo(int idart, int idbar, String nombre, int cant, double prec) throws SQLException {
        int resultado = 1;
        try {
            //creamos la consulta
            CallableStatement cStmt = this.getConexion().prepareCall("{?=call Actualiza_Existencias(?,?,?,?,?)}");
            //pasamos por parametro todos los valores a introducir
            cStmt.setInt(2, idart);
            cStmt.setInt(3, idbar);
            cStmt.setString(4, nombre);
            cStmt.setInt(5, cant);
            cStmt.setDouble(6, prec);
            cStmt.execute();//ejecutamos la consulta
            resultado = cStmt.getInt(1);//recogemos si ha tenido exito
            return resultado;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return resultado;
    }

    /**
     * Metodo para eliminar a una persona segun su identificador
     *
     * @param idart int codigo para borrar el registro
     * @return int 0 y 1, 0 correcto, 1 error
     * @throws SQLException
     */
    public int BorrarArticulo(int idart) throws SQLException {
        int resultado = 1;
        try {
            //creamos la consulta
            CallableStatement cStmt = this.getConexion().prepareCall("{?=call Borra_Existencias(?)}");
            //pasamos por parametro todos los valores a introducir
            cStmt.setInt(2, idart);
            cStmt.execute();//ejecutamos la consulta
            resultado = cStmt.getInt(1);//recogemos si ha tenido exito
            return resultado;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return resultado;

    }
}
