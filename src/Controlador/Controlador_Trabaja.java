/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Modelo_Trabaja;
import Vista.VistaTrabaja;
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
public class Controlador_Trabaja implements ActionListener, MouseListener {

    VistaTrabaja vista;
    Modelo_Trabaja mod = new Modelo_Trabaja();

    String dnid;
    int codigo;

    public Controlador_Trabaja(VistaTrabaja vista) {
        this.vista = vista;
    }

    public void Iniciar() {

        this.vista.Boton_Insertar.addActionListener(this);
        this.vista.Boton_Modificar.addActionListener(this);
        this.vista.Boton_Borrar.addActionListener(this);
        this.vista.Tabla_Funciones.addMouseListener(this);

        this.vista.Tabla_Funciones.setModel(mod.CargaTablaTrabajador());
        this.vista.Tabla_Funciones.getTableHeader().setReorderingAllowed(false);

        ((DefaultTableCellRenderer) this.vista.Tabla_Funciones.getDefaultRenderer(String.c‌lass)).setHorizontal‌Alignment(JLabel.CENTER);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
//Insertar articulo
        if (e.getSource() == this.vista.Boton_Insertar) {
            String dni, func;
            int cod;

            dni = "" + this.vista.Txt_DniPersona.getText();
            func = this.vista.Txt_Funcion.getText();
            cod = Integer.parseInt("" + this.vista.Txt_IdBar.getText());

            try {
                int result = mod.InsertaTrabajador(dni, cod, func);
                if (result == 1) {
                    JOptionPane.showMessageDialog(vista, "Ha ocurrido un error");
                } else {
                    JOptionPane.showMessageDialog(vista, "Todo correcto");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Controlador_Bar.class.getName()).log(Level.SEVERE, null, ex);
            }

            this.vista.Tabla_Funciones.setModel(mod.CargaTablaTrabajador());

            this.vista.Txt_DniPersona.setText("");
            this.vista.Txt_Funcion.setText("");
            this.vista.Txt_IdBar.setText("");

        }
        //Modificar articulo
        if (e.getSource() == this.vista.Boton_Modificar) {
            String dni, func;
            int cod;

            dni = "" + this.vista.Txt_DniPersona.getText();
            func = this.vista.Txt_Funcion.getText();
            cod = Integer.parseInt(this.vista.Txt_IdBar.getText());

            int result;
            try {
                result = mod.ModificaTrabajador(dni, cod, func);
                if (result == 1) {
                    JOptionPane.showMessageDialog(vista, "Ha ocurrido un error");
                } else {
                    JOptionPane.showMessageDialog(vista, "Todo correcto");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Controlador_Bar.class.getName()).log(Level.SEVERE, null, ex);
            }

            this.vista.Tabla_Funciones.setModel(mod.CargaTablaTrabajador());

            this.vista.Txt_DniPersona.setText("");
            this.vista.Txt_Funcion.setText("");
            this.vista.Txt_IdBar.setText("");
        }
        //Borrar articulo
        if (e.getSource() == this.vista.Boton_Borrar) {

            try {
                int result = mod.BorrarTrabajador(dnid, codigo);

                if (result == 1) {
                    JOptionPane.showMessageDialog(vista, "Ha ocurrido un error");
                } else {
                    JOptionPane.showMessageDialog(vista, "Todo correcto");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Controlador_Bar.class.getName()).log(Level.SEVERE, null, ex);
            }

            this.vista.Tabla_Funciones.setModel(mod.CargaTablaTrabajador());
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.vista.Tabla_Funciones && e.getButton() == 1) {

            String codbar;
            int fila = this.vista.Tabla_Funciones.rowAtPoint(e.getPoint());
            if (fila > -1) {
                dnid = String.valueOf(this.vista.Tabla_Funciones.getValueAt(fila, 0));
                codbar = String.valueOf(this.vista.Tabla_Funciones.getValueAt(fila, 1));
                codigo = Integer.parseInt(codbar);
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
