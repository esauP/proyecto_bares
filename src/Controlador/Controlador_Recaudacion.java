/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Modelo_Recaudacion;
import Vista.VistaRecaudacion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author esaup
 */
public class Controlador_Recaudacion implements ActionListener, MouseListener {
    
    VistaRecaudacion vista;
    Modelo_Recaudacion mod = new Modelo_Recaudacion();
    
    public Controlador_Recaudacion(VistaRecaudacion vista){
        this.vista = vista;
    }
    
    public void Iniciar(){
        
         this.vista.Boton_Insertar.addActionListener(this);
        this.vista.Boton_Modificar.addActionListener(this);
        this.vista.Boton_Borrar.addActionListener(this);
        this.vista.Tabla_Recaudaciones.addMouseListener(this);

        this.vista.Tabla_Recaudaciones.setModel(mod.CargaTablaRecaudaciones());
        this.vista.Tabla_Recaudaciones.getTableHeader().setReorderingAllowed(false);

        ((DefaultTableCellRenderer) this.vista.Tabla_Recaudaciones.getDefaultRenderer(String.c‌lass)).setHorizontal‌Alignment(JLabel.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
