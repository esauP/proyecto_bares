package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexionBD_BarSur {

    private String url = "\\BarSur.db3";
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
