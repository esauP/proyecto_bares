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

/**
 *
 * @author esaup
 */
public class Modelo_Bar extends ConexionBD_BarNorte {

    public DefaultTableModel CargaTablaBar() {
        DefaultTableModel tabla = new DefaultTableModel();
        Object[] columName = null;
        Object[][] data = null;
        int registros = 0;
        try {
            //llamamos a la funcion almacenada en la base de datos
            CallableStatement pstm = this.getConexion().prepareCall("{?=call Total_Bar}");
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
            CallableStatement cstm = this.getConexion().prepareCall("{call Consulta_Bar}");
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

    public int InsertaBar(String nombar, String licen, String domic, String hora, String dias) throws SQLException {
        int resultado = 1;
        try {
            //creamos la consulta
            CallableStatement cStmt = this.getConexion().prepareCall("{?=call Inserta_Bar(?,?,?,?,?)}");
            //pasamos por parametro todos los valores a introducir
            cStmt.setString(2, nombar);
            cStmt.setString(3, licen);
            cStmt.setString(4, domic);
            cStmt.setString(5, hora);
            cStmt.setString(6, dias);
            cStmt.execute();//ejecutamos la consulta
            resultado = cStmt.getInt(1);//recogemos si ha tenido exito
            return resultado;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return resultado;
    }

    public int ModificaBar(int id, String nombar, String domic, String hora, String dias) throws SQLException {
        int resultado = 1;
        try {
            //creamos la consulta
            CallableStatement cStmt = this.getConexion().prepareCall("{?=call Actualiza_Bar(?,?,?,?,?)}");
            //pasamos por parametro todos los valores a introducir
            cStmt.setInt(2, id);
            cStmt.setString(3, nombar);
            cStmt.setString(4, domic);
            cStmt.setString(5, hora);
            cStmt.setString(6, dias);

            cStmt.execute();//ejecutamos la consulta
            resultado = cStmt.getInt(1);//recogemos si ha tenido exito
            return resultado;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return resultado;
    }

    public int BorrarBar(int id) throws SQLException {
        int resultado = 1;
        try {
            //creamos la consulta
            CallableStatement cStmt = this.getConexion().prepareCall("{?=call Borrar_Bar(?)}");
            //pasamos por parametro todos los valores a introducir
            cStmt.setInt(2, id);
            cStmt.execute();//ejecutamos la consulta
            resultado = cStmt.getInt(1);//recogemos si ha tenido exito
            return resultado;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return resultado;

    }

}
