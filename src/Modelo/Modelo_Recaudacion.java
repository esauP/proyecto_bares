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
public class Modelo_Recaudacion extends ConexionBD_BarNorte {
      /**
     * Metodo para cargar la tabla de recaudaciones
     *
     * @return DefaultTable model con los datos cargados
     */
    public TableModel CargaTablaRecaudaciones() {
        DefaultTableModel tabla = new DefaultTableModel();
        Object[] columName = null;
        Object[][] data = null;
        int registros = 0;
        try {
            //llamamos a la funcion almacenada en la base de datos
            CallableStatement pstm = this.getConexion().prepareCall("{?=call Total_Recaudacion}");
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
            CallableStatement cstm = this.getConexion().prepareCall("{call Consulta_Recaudacion}");
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
     * Metodo para introducir una nueva recaudacion
     *
     * @param idbar int identificador del bar a introducir
     * @param tot double cantidad a introducir
     * @return int 0 y 1, 0 correcto, 1 error
     * @throws SQLException
     */
    public int InsertaRecaudacion(int idbar, double tot) throws SQLException {
        int resultado = 1;
        try {
            //creamos la consulta
            CallableStatement cStmt = this.getConexion().prepareCall("{?=call Inserta_Recaudacion(?,?)}");
            //pasamos por parametro todos los valores a introducir
            cStmt.setInt(2, idbar);
            cStmt.setDouble(3, tot);
            cStmt.execute();//ejecutamos la consulta
            resultado = cStmt.getInt(1);//recogemos si ha tenido exito
            return resultado;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return resultado;
    }

   /**
    * Metodo para modificar los registros de la tabla recaudacion
    * @param idbar int identificador del bar
    * @param tot double cantidad a modificar
    * @return int 0 y 1, 0 correcto, 1 error
    * @throws SQLException 
    */
    public int ModificaRecaudacion(int idbar, double tot) throws SQLException {
        int resultado = 1;
        try {
            //creamos la consulta
            CallableStatement cStmt = this.getConexion().prepareCall("{?=call Actualiza_Recaudacion(?,?)}");
            //pasamos por parametro todos los valores a introducir
            cStmt.setInt(2, idbar);
            cStmt.setDouble(3, tot);
            
            cStmt.execute();//ejecutamos la consulta
            resultado = cStmt.getInt(1);//recogemos si ha tenido exito
            return resultado;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return resultado;
    }

    /**
     * Metodo para eliminar una recaudacion segun su identificador
     *
     * @param idbar int codigo para borrar el registro
     * @param fecha String
     * @return int 0 y 1, 0 correcto, 1 error
     * @throws SQLException
     */
    public int BorrarRecaudacion(int idbar, String fecha) throws SQLException {
        int resultado = 1;
        try {
            //creamos la consulta
            CallableStatement cStmt = this.getConexion().prepareCall("{?=call Borrar_Recaudacion(?,?)}");
            //pasamos por parametro todos los valores a introducir
            cStmt.setInt(2, idbar);
            cStmt.setString(3, fecha);
            cStmt.execute();//ejecutamos la consulta
            resultado = cStmt.getInt(1);//recogemos si ha tenido exito
            return resultado;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return resultado;

    }
}
