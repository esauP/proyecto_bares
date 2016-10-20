/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author esaup
 */
public class ConexionBD_BarSur {

    private String url = "E:\\NetBeans\\Projects\\proyecto_bares\\biblioteca.db3";
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
}
