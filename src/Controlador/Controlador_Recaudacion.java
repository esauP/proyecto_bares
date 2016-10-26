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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author esaup
 */
public class Controlador_Recaudacion implements ActionListener, MouseListener {

    VistaRecaudacion vista;
    Modelo_Recaudacion mod = new Modelo_Recaudacion();

    int id;
    String fecha;

    public Controlador_Recaudacion(VistaRecaudacion vista) {
        this.vista = vista;
    }

    public void Iniciar() {

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
        //Insertar articulo
        if (e.getSource() == this.vista.Boton_Insertar) {
            int idbar;
            double prec;

            prec = Double.parseDouble("" + this.vista.Txt_Recaudacion.getText());
            idbar = Integer.parseInt("" + this.vista.Txt_IdBar.getText());

            try {
                int result = mod.InsertaRecaudacion(idbar, prec);
                if (result == 1) {
                    JOptionPane.showMessageDialog(vista, "Ha ocurrido un error");
                } else {
                    JOptionPane.showMessageDialog(vista, "Todo correcto");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Controlador_Bar.class.getName()).log(Level.SEVERE, null, ex);
            }

            this.vista.Tabla_Recaudaciones.setModel(mod.CargaTablaRecaudaciones());

            this.vista.Txt_Fecha.setText("");
            this.vista.Txt_IdBar.setText("");
            this.vista.Txt_Recaudacion.setText("");

        }
        //Modificar articulo
        if (e.getSource() == this.vista.Boton_Modificar) {

            double prec;

            prec = Double.parseDouble("" + this.vista.Txt_Recaudacion.getText());
            int result;
            try {
                result = mod.ModificaRecaudacion(id, prec);
                if (result == 1) {
                    JOptionPane.showMessageDialog(vista, "Ha ocurrido un error");
                } else {
                    JOptionPane.showMessageDialog(vista, "Todo correcto");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Controlador_Bar.class.getName()).log(Level.SEVERE, null, ex);
            }

            this.vista.Tabla_Recaudaciones.setModel(mod.CargaTablaRecaudaciones());

            this.vista.Txt_Fecha.setText("");
            this.vista.Txt_IdBar.setText("");
            this.vista.Txt_Recaudacion.setText("");

        }
        //Borrar articulo
        if (e.getSource() == this.vista.Boton_Borrar) {

            try {
                int result = mod.BorrarRecaudacion(id, fecha);

                if (result == 1) {
                    JOptionPane.showMessageDialog(vista, "Ha ocurrido un error");
                } else {
                    JOptionPane.showMessageDialog(vista, "Todo correcto");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Controlador_Bar.class.getName()).log(Level.SEVERE, null, ex);
            }

            this.vista.Tabla_Recaudaciones.setModel(mod.CargaTablaRecaudaciones());
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.vista.Tabla_Recaudaciones && e.getButton() == 1) {

            String codbar, fec;
            int fila = this.vista.Tabla_Recaudaciones.rowAtPoint(e.getPoint());
            if (fila > -1) {
                codbar = String.valueOf(this.vista.Tabla_Recaudaciones.getValueAt(fila, 0));
                fecha = String.valueOf(this.vista.Tabla_Recaudaciones.getValueAt(fila, 2));
                id = Integer.parseInt(codbar);
            }

        }
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
