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
public class Modelo_Persona extends ConexionBD_BarNorte {

    /**
     * Metodo para cargar la tabla de los registros de personas
     *
     * @return DefaultTableModel
     */
    public DefaultTableModel CargaTablaPersona() {
        DefaultTableModel tabla = new DefaultTableModel();
        Object[] columName = null;
        Object[][] data = null;
        int registros = 0;
        try {
            //llamamos a la funcion almacenada en la base de datos
            CallableStatement pstm = this.getConexion().prepareCall("{?=call Total_Persona}");
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
            CallableStatement cstm = this.getConexion().prepareCall("{call Consulta_Persona}");
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
                    if (j==col) {
                        if (re.getString(columName[h].toString()) == "0") {
                            data[j][h] = "Empleado";
                        }
                        if (re.getString(columName[h].toString()) == "1") {
                            data[j][h] = "Dueño";
                        }
                    }
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
     * @param nombre String
     * @param dni String
     * @param domicilio String
     * @param titular int
     * @return int 0 y 1, 0 correcto, 1 error
     * @throws SQLException
     */
    public int InsertaPersona(String nombre, String dni, String domicilio, int titular) throws SQLException {
        int resultado = 1;
        try {
            //creamos la consulta
            CallableStatement cStmt = this.getConexion().prepareCall("{?=call Inserta_Persona(?,?,?,?)}");
            //pasamos por parametro todos los valores a introducir
            cStmt.setString(2, nombre);
            cStmt.setString(3, domicilio);
            cStmt.setString(4, dni);
            cStmt.setInt(5, titular);
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
     * @param dnic String clave primaria para modificar persona
     * @param nombre String
     * @param domicilio String
     * @return int 0 y 1, 0 correcto, 1 error
     * @throws SQLException
     */
    public int ModificaPersona(String dnic, String nombre, String domicilio) throws SQLException {
        int resultado = 1;
        try {
            //creamos la consulta
            CallableStatement cStmt = this.getConexion().prepareCall("{?=call Actualiza_persona(?,?,?)}");
            //pasamos por parametro todos los valores a introducir
            cStmt.setString(2, dnic);
            cStmt.setString(3, nombre);
            cStmt.setString(4, domicilio);
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
     * @param dnic String para borrar el registro
     * @return int 0 y 1, 0 correcto, 1 error
     * @throws SQLException
     */
    public int BorrarPersona(String dnic) throws SQLException {
        int resultado = 1;
        try {
            //creamos la consulta
            CallableStatement cStmt = this.getConexion().prepareCall("{?=call Borrar_Persona(?)}");
            //pasamos por parametro todos los valores a introducir
            cStmt.setString(2, dnic);
            cStmt.execute();//ejecutamos la consulta
            resultado = cStmt.getInt(1);//recogemos si ha tenido exito
            return resultado;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return resultado;

    }

}
