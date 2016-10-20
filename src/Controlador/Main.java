/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.Interfaz;
import Vista.VistaBar;
import Vista.VistaInventario;
import Vista.VistaPedidos;
import Vista.VistaPersona;
import Vista.VistaRecaudacion;
import Vista.VistaTrabaja;
import java.io.IOException;

/**
 *
 * @author esaup
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Interfaz vista = new Interfaz();
        VistaBar vistaBar = new VistaBar();
        VistaInventario vistaInv = new VistaInventario();
        VistaPedidos vistaPed = new VistaPedidos();
        VistaPersona vistaPer = new VistaPersona();
        VistaTrabaja vistaTra = new VistaTrabaja();
        VistaRecaudacion vistaRec = new VistaRecaudacion();

        new Controlador(vista, vistaBar, vistaInv, vistaPed, vistaPer, vistaTra, vistaRec).Iniciar();
    }

}
