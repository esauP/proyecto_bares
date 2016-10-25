
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexionBD_BarNorte {
/**
 * Lista de atributos necesarios para realizar la conexion con la base de datos.
 */
    private static Connection conexion;
    private String user = "dam43";
    private String bd = user + "_BarNorte";
    private String pass = "salesianas";
    private String host = "79.148.236.236";
    private String server = "jdbc:mysql://" + host + "/" + bd;

    public ConexionBD_BarNorte() {

        try {
            System.out.println(bd);
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println(server);
            conexion = (Connection) DriverManager.getConnection(this.server, this.user, this.pass);
            //conector de la base de datos, por el cual pasamos los datos por parametros.
            System.out.println("Conexion a base de datos " + this.server + " ...OK");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }
/**
 * Metodo para llamar a la conexion desde las distintas partes de nuestro programa
 * @return una conexion a la base de datos. 
 */
    public Connection getConexion() {
        return this.conexion;
    }

}
