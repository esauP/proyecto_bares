package Controlador;

import Vista.Interfaz;
import Vista.VistaBar;
import Vista.VistaInventario;
import Vista.VistaPedidos;
import Vista.VistaPersona;
import Vista.VistaRecaudacion;
import Vista.VistaTrabaja;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Interfaz vista = new Interfaz();
        VistaBar vistaBar = new VistaBar();
        VistaInventario vistaInv = new VistaInventario();
        VistaPedidos vistaPed = new VistaPedidos();
        VistaPersona vistaPer = new VistaPersona();
        VistaTrabaja vistaTra = new VistaTrabaja();
        VistaRecaudacion vistaRec = new VistaRecaudacion();

        new Controlador_Bar(vistaBar).Iniciar();
        new Controlador_Persona(vistaPer).Iniciar();
        new Controlador_Inventario(vistaInv).Iniciar();
        new Controlador_Pedidos(vistaPed).Iniciar();
        new Controlador_Recaudacion(vistaRec).Iniciar();
        new Controlador_Trabaja(vistaTra).Iniciar();

        new Controlador(vista, vistaBar, vistaInv, vistaPed, vistaPer, vistaTra, vistaRec).Iniciar();
    }

}
