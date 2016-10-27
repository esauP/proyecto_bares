/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author esaup
 */
class ConexionBD_BarNorte {

    private static Connection conexion;
    private String user = "dam43";
    private String bd = user + "_BarNorte";
    private String password = "salesianas";
    private String host = "192.168.28.3";
    //ipinterna: 192.168.28.3   
    //ipexterna: 79.148.236.236
    private String server = "jdbc:mysql://" + host + "/" + bd;

    public ConexionBD_BarNorte() {

        /**
         * Asignamos los valores para los datos de conexion
         */
        try {
            System.out.println(bd);
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println(server);
            conexion = (Connection) DriverManager.getConnection(this.server, this.user, this.password);

            System.out.println("Conexion a base de datos " + this.server + " ...OK");
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }

    }

    public Connection getConexion() {
        return this.conexion;
    }
}
