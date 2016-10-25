/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Modelo_Inventario;
import Vista.VistaInventario;
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
public class Controlador_Inventario implements ActionListener, MouseListener {

    VistaInventario vista;
    Modelo_Inventario mod = new Modelo_Inventario();

    int idart, idbar;

    public Controlador_Inventario(VistaInventario vista) {
        this.vista = vista;
    }

    public void Iniciar() {

        this.vista.Boton_Insertar.addActionListener(this);
        this.vista.Boton_Modificar.addActionListener(this);
        this.vista.Boton_Borrar.addActionListener(this);
        this.vista.Tabla_Inventario.addMouseListener(this);

        this.vista.Tabla_Inventario.setModel(mod.CargaTablaInventario());
        this.vista.Tabla_Inventario.getTableHeader().setReorderingAllowed(false);

        ((DefaultTableCellRenderer) this.vista.Tabla_Inventario.getDefaultRenderer(String.c‌lass)).setHorizontal‌Alignment(JLabel.CENTER);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //Insertar articulo
        if (e.getSource() == this.vista.Boton_Insertar) {
            String nomart;
            int idbar, cant;
            double prec;
            nomart = this.vista.Txt_NombreArticulo.getText();
            cant = Integer.parseInt(this.vista.Txt_Cantidad.getText());
            prec = Integer.parseInt(this.vista.Txt_Precio.getText());
            idbar = Integer.parseInt(this.vista.Txt_Idbar.getText());

            try {
                int result = mod.InsertaArticulo(nomart, cant, prec, idbar);
                if (result == 1) {
                    JOptionPane.showMessageDialog(vista, "Ha ocurrido un error");
                } else {
                    JOptionPane.showMessageDialog(vista, "Todo correcto");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Controlador_Bar.class.getName()).log(Level.SEVERE, null, ex);
            }

            this.vista.Tabla_Inventario.setModel(mod.CargaTablaInventario());

            this.vista.Txt_NombreArticulo.setText("");
            this.vista.Txt_Cantidad.setText("");
            this.vista.Txt_Idbar.setText("");
            this.vista.Txt_Precio.setText("");

        }
        //Modificar articulo
        if (e.getSource() == this.vista.Boton_Modificar) {
            String nomart;
            int cant;
            double prec;

            nomart = this.vista.Txt_NombreArticulo.getText();
            cant = Integer.parseInt(this.vista.Txt_Cantidad.getText());
            prec = Integer.parseInt(this.vista.Txt_Precio.getText());
            idbar = Integer.parseInt(this.vista.Txt_Idbar.getText());

            int result;
            try {
                result = mod.ModificaArticulo(idart, idbar, nomart, cant, prec);
                if (result == 1) {
                    JOptionPane.showMessageDialog(vista, "Ha ocurrido un error");
                } else {
                    JOptionPane.showMessageDialog(vista, "Todo correcto");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Controlador_Bar.class.getName()).log(Level.SEVERE, null, ex);
            }

            this.vista.Tabla_Inventario.setModel(mod.CargaTablaInventario());

            this.vista.Txt_NombreArticulo.setText("");
            this.vista.Txt_Cantidad.setText("");
            this.vista.Txt_Idbar.setText("");
            this.vista.Txt_Precio.setText("");

        }
        //Borrar articulo
        if (e.getSource() == this.vista.Boton_Borrar) {

            try {
                int result = mod.BorrarArticulo(idart);

                if (result == 1) {
                    JOptionPane.showMessageDialog(vista, "Ha ocurrido un error");
                } else {
                    JOptionPane.showMessageDialog(vista, "Todo correcto");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Controlador_Bar.class.getName()).log(Level.SEVERE, null, ex);
            }

            this.vista.Tabla_Inventario.setModel(mod.CargaTablaInventario());
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.vista.Tabla_Inventario && e.getButton() == 1) {

            String codart, codbar;
            int fila = this.vista.Tabla_Inventario.rowAtPoint(e.getPoint());
            if (fila > -1) {
                codbar = String.valueOf(this.vista.Tabla_Inventario.getValueAt(fila, 4));
                codart = String.valueOf(this.vista.Tabla_Inventario.getValueAt(fila, 0));
                idart = Integer.parseInt(codart);
                idbar = Integer.parseInt(codbar);
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
