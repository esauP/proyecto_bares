/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Modelo_Persona;
import Vista.VistaPersona;
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
public class Controlador_Persona implements ActionListener, MouseListener {

    VistaPersona vista;
    Modelo_Persona mod = new Modelo_Persona();

    String dnic;

    public Controlador_Persona(VistaPersona vista) {
        this.vista = vista;
    }

    public void Iniciar() {
        this.vista.Boton_Insertar.addActionListener(this);
        this.vista.Boton_Modificar.addActionListener(this);
        this.vista.Boton_Borrar.addActionListener(this);
        this.vista.Tabla_Personas.addMouseListener(this);
        this.vista.Combo_titular.addActionListener(this);

        this.vista.Tabla_Personas.setModel(mod.CargaTablaPersona());
        this.vista.Tabla_Personas.getTableHeader().setReorderingAllowed(false);

        ((DefaultTableCellRenderer) this.vista.Tabla_Personas.getDefaultRenderer(String.c‌lass)).setHorizontal‌Alignment(JLabel.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vista.Boton_Insertar) {
            String nombar, dni, domic;
            int titular;
            nombar = this.vista.Txt_NombrePersona.getText();
            dni = "" + this.vista.Txt_DniPersona.getText();
            domic = this.vista.Txt_DomicilioPersona.getText();

            if (this.vista.Combo_titular.getSelectedItem().equals("Dueño")) {
                titular = 1;
            } else {
                titular = 0;
            }

            try {
                int result = mod.InsertaPersona(nombar, dni, domic, titular);
                if (result == 1) {
                    JOptionPane.showMessageDialog(vista, "Ha ocurrido un error");
                } else {
                    JOptionPane.showMessageDialog(vista, "Todo correcto");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Controlador_Bar.class.getName()).log(Level.SEVERE, null, ex);
            }

            this.vista.Tabla_Personas.setModel(mod.CargaTablaPersona());

            this.vista.Txt_NombrePersona.setText("");
            this.vista.Txt_DniPersona.setText("");
            this.vista.Txt_DomicilioPersona.setText("");

        }
        //Modificar bar
        if (e.getSource() == this.vista.Boton_Modificar) {
            String nombar, domic, dni;

            nombar = this.vista.Txt_NombrePersona.getText();
            domic = this.vista.Txt_DomicilioPersona.getText();
            dni = "" + this.vista.Txt_DniPersona.getText();

            int result;
            try {
                result = mod.ModificaPersona(dnic, nombar, domic);
                if (result == 1) {
                    JOptionPane.showMessageDialog(vista, "Ha ocurrido un error");
                } else {
                    JOptionPane.showMessageDialog(vista, "Todo correcto");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Controlador_Bar.class.getName()).log(Level.SEVERE, null, ex);
            }

            this.vista.Tabla_Personas.setModel(mod.CargaTablaPersona());

            this.vista.Txt_NombrePersona.setText("");
            this.vista.Txt_DniPersona.setText("");
            this.vista.Txt_DomicilioPersona.setText("");

        }
        //Borrar bar
        if (e.getSource() == this.vista.Boton_Borrar) {

            try {
                int result = mod.BorrarPersona(dnic);

                if (result == 1) {
                    JOptionPane.showMessageDialog(vista, "Ha ocurrido un error");
                } else {
                    JOptionPane.showMessageDialog(vista, "Todo correcto");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Controlador_Bar.class.getName()).log(Level.SEVERE, null, ex);
            }

            this.vista.Tabla_Personas.setModel(mod.CargaTablaPersona());
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.vista.Tabla_Personas && e.getButton() == 1) {

            int fila = this.vista.Tabla_Personas.rowAtPoint(e.getPoint());
            if (fila > -1) {
                dnic = String.valueOf(this.vista.Tabla_Personas.getValueAt(fila, 2));

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
