/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Modelo_Bar;
import Vista.VistaBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author esaup
 */
public class Controlador_Bar implements ActionListener, MouseListener {

    VistaBar vista;
    Modelo_Bar mod = new Modelo_Bar();

    int id;

    public Controlador_Bar(VistaBar vista) {
        this.vista = vista;
    }

    public void Iniciar() {

        this.vista.Boton_Insertar.addActionListener(this);
        this.vista.Boton_Modificar.addActionListener(this);
        this.vista.Boton_Borrar.addActionListener(this);
        this.vista.Tabla_Bar.addMouseListener(this);

        this.vista.Tabla_Bar.setModel(mod.CargaTablaBar());
        this.vista.Tabla_Bar.getTableHeader().setReorderingAllowed(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Insertar Bar
        if (e.getSource() == this.vista.Boton_Insertar) {
            String nombar, licen, domic, hora, dias;

            nombar = this.vista.Txt_NombreBar.getText();
            licen = this.vista.Txt_Licencia.getText();
            domic = this.vista.Txt_DomicilioBar.getText();
            hora = this.vista.Txt_Horario.getText();
            dias = this.vista.Txt_DiasApertura.getText();

            try {
                int result = mod.InsertaBar(nombar, licen, domic, hora, dias);
                if (result == 1) {
                    JOptionPane.showMessageDialog(vista, "Ha ocurrido un error");
                } else {
                    JOptionPane.showMessageDialog(vista, "Todo correcto");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Controlador_Bar.class.getName()).log(Level.SEVERE, null, ex);
            }

            this.vista.Tabla_Bar.setModel(mod.CargaTablaBar());

            this.vista.Txt_NombreBar.setText("");
            this.vista.Txt_Licencia.setText("");
            this.vista.Txt_DomicilioBar.setText("");
            this.vista.Txt_Horario.setText("");
            this.vista.Txt_DiasApertura.setText("");

        }
        //Modificar bar
        if (e.getSource() == this.vista.Boton_Modificar) {
            String nombar, domic, hora, dias;

            nombar = this.vista.Txt_NombreBar.getText();
            domic = this.vista.Txt_DomicilioBar.getText();
            hora = this.vista.Txt_Horario.getText();
            dias = this.vista.Txt_DiasApertura.getText();

            int result;
            try {
                result = mod.ModificaBar(id, nombar, domic, hora, dias);
                if (result == 1) {
                    JOptionPane.showMessageDialog(vista, "Ha ocurrido un error");
                } else {
                    JOptionPane.showMessageDialog(vista, "Todo correcto");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Controlador_Bar.class.getName()).log(Level.SEVERE, null, ex);
            }

            this.vista.Tabla_Bar.setModel(mod.CargaTablaBar());

            this.vista.Txt_NombreBar.setText("");
            this.vista.Txt_Licencia.setText("");
            this.vista.Txt_DomicilioBar.setText("");
            this.vista.Txt_Horario.setText("");
            this.vista.Txt_DiasApertura.setText("");
        }
        //Borrar bar
        if (e.getSource() == this.vista.Boton_Borrar) {

            try {
                int result = mod.BorrarBar(id);

                if (result == 1) {
                    JOptionPane.showMessageDialog(vista, "Ha ocurrido un error");
                } else {
                    JOptionPane.showMessageDialog(vista, "Todo correcto");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Controlador_Bar.class.getName()).log(Level.SEVERE, null, ex);
            }

            this.vista.Tabla_Bar.setModel(mod.CargaTablaBar());
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.vista.Tabla_Bar && e.getButton() == 1) {

            String cod;
            int fila = this.vista.Tabla_Bar.rowAtPoint(e.getPoint());
            if (fila > -1) {
                cod = String.valueOf(this.vista.Tabla_Bar.getValueAt(fila, 0));
                id = Integer.parseInt(cod);
                System.out.println(cod);
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
