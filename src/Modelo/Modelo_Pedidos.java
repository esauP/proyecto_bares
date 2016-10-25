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
public class Modelo_Pedidos extends ConexionBD_BarNorte {

    public TableModel CargaTablaPedidos() {
        DefaultTableModel tabla = new DefaultTableModel();
        Object[] columName = null;
        Object[][] data = null;
        int registros = 0;
        try {
            //llamamos a la funcion almacenada en la base de datos
            CallableStatement pstm = this.getConexion().prepareCall("{?=call Total_Pedidos}");
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
            CallableStatement cstm = this.getConexion().prepareCall("{call Consulta_Pedidos}");
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
     * Metodo para insertar pedidos
     *
     * @param prove String nombre proveedor
     * @param nomart String nombre articulo
     * @param cant int cantidad
     * @param prec double precio
     * @param barid int identificador bar
     * @param codart int identifiador articulo
     * @return int 0 y 1, 0 correcto, 1 error
     */
    public int InsertaPedido(String prove, String nomart, int cant, double prec, int barid, int codart) {
        int resultado = 1;
        try {
            //creamos la consulta
            CallableStatement cStmt = this.getConexion().prepareCall("{?=call Inserta_Pedidos(?,?,?,?,?,?)}");
            //pasamos por parametro todos los valores a introducir
            cStmt.setString(2, prove);
            cStmt.setString(3, nomart);
            cStmt.setInt(4, cant);
            cStmt.setDouble(5, prec);
            cStmt.setInt(6, barid);
            cStmt.setInt(7, codart);
            cStmt.execute();//ejecutamos la consulta
            resultado = cStmt.getInt(1);//recogemos si ha tenido exito
            return resultado;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return resultado;
    }

    /**
     * Metodo para eliminar a un pedido segun su identificador
     *
     * @param num_ped int codigo para borrar el registro
     * @return int 0 y 1, 0 correcto, 1 error
     * @throws SQLException
     */
    public int BorrarArticulo(int num_ped) throws SQLException {
        int resultado = 1;
        try {
            //creamos la consulta
            CallableStatement cStmt = this.getConexion().prepareCall("{?=call Borra_Pedidos(?)}");
            //pasamos por parametro todos los valores a introducir
            cStmt.setInt(2, num_ped);
            cStmt.execute();//ejecutamos la consulta
            resultado = cStmt.getInt(1);//recogemos si ha tenido exito
            return resultado;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return resultado;

    }
}
