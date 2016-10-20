/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ModeloBar;
import Vista.*;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author esaup
 */
public class Controlador {

    //se crean los objetos vistas
    Interfaz vista;
    VistaBar vistaBar;
    VistaInventario vistaInv;
    VistaPedidos vistaPed;
    VistaPersona vistaPer;
    VistaTrabaja vistaTra;
    VistaRecaudacion vistaRec;

    //se pasan por parametro en el constructor para iniciar sus componentes
    public Controlador(Interfaz vista, VistaBar vistaBar, VistaInventario vistaInv, VistaPedidos vistaPed, VistaPersona vistaPer, VistaTrabaja vistaTra, VistaRecaudacion vistaRec) {
        this.vista = vista;
        this.vistaBar = vistaBar;
        this.vistaInv = vistaInv;
        this.vistaPed = vistaPed;
        this.vistaPer = vistaPer;
        this.vistaTra = vistaTra;
        this.vistaRec = vistaRec;

        //se añaden las diferentes vistas a una interfaz comun mendiante un panel con pestañas
        this.vista.PanelPestania.addTab("Bares", vistaBar);
        this.vista.PanelPestania.addTab("Inventarios", vistaInv);
        this.vista.PanelPestania.addTab("Pedidos", vistaPed);
        this.vista.PanelPestania.addTab("Personal", vistaPer);
        this.vista.PanelPestania.addTab("Funcion", vistaTra);
        this.vista.PanelPestania.addTab("Recuadaciones", vistaRec);

    }

    public void Iniciar() {

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            SwingUtilities.updateComponentTreeUI(vista);
            vista.setVisible(true);
        } catch (UnsupportedLookAndFeelException ex) {
        } catch (ClassNotFoundException ex) {
        } catch (InstantiationException ex) {
        } catch (IllegalAccessException ex) {
        }
        //Colocamos la ventana en el centro de la pantalla
        this.vista.setLocationRelativeTo(null);
    }

}
