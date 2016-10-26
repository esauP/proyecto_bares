/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Modelo_Pedidos;
import Vista.VistaPedidos;
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
public class Controlador_Pedidos implements ActionListener, MouseListener {

    VistaPedidos vista;
    Modelo_Pedidos mod = new Modelo_Pedidos();

    int num_Ped;

    int num_ped;

    public Controlador_Pedidos(VistaPedidos vista) {
        this.vista = vista;
    }

    public void Iniciar() {
        this.vista.Boton_Insertar.addActionListener(this);

        this.vista.Boton_Borrar.addActionListener(this);
        this.vista.Tabla_Pedidos.addMouseListener(this);

        this.vista.Tabla_Pedidos.setModel(mod.CargaTablaPedidos());
        this.vista.Tabla_Pedidos.getTableHeader().setReorderingAllowed(false);

        ((DefaultTableCellRenderer) this.vista.Tabla_Pedidos.getDefaultRenderer(String.c‌lass)).setHorizontal‌Alignment(JLabel.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Insertar pedido
        if (e.getSource() == this.vista.Boton_Insertar) {
            String prove, nomart;
            int cant, barid, codart;
            double prec;

            prove = "" + this.vista.Txt_Proveedor.getText();
            nomart = "" + this.vista.Txt_NombreArticulo.getText();
            barid = Integer.parseInt("" + this.vista.Txt_IdBar.getText());
            codart = Integer.parseInt("" + this.vista.Txt_CodigoProducto.getText());
            cant = Integer.parseInt("" + this.vista.Txt_Cantidad.getText());
            prec = Double.parseDouble("" + this.vista.Txt_Precio.getText());

            int result = mod.InsertaPedido(prove, nomart, cant, prec, barid, codart);
            if (result == 1) {
                JOptionPane.showMessageDialog(vista, "Ha ocurrido un error");
            } else {
                JOptionPane.showMessageDialog(vista, "Todo correcto");
            }

            this.vista.Tabla_Pedidos.setModel(mod.CargaTablaPedidos());

            this.vista.Txt_NombreArticulo.setText("");
            this.vista.Txt_Cantidad.setText("");
            this.vista.Txt_CodigoProducto.setText("");
            this.vista.Txt_IdBar.setText("");
            this.vista.Txt_Proveedor.setText("");
            this.vista.Txt_Precio.setText("");

        }

        //Borrar pedido
        if (e.getSource() == this.vista.Boton_Borrar) {

            try {
                int result = mod.BorrarPedido(num_Ped);

                if (result == 1) {
                    JOptionPane.showMessageDialog(vista, "Ha ocurrido un error");
                } else {
                    JOptionPane.showMessageDialog(vista, "Todo correcto");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Controlador_Bar.class.getName()).log(Level.SEVERE, null, ex);
            }

            this.vista.Tabla_Pedidos.setModel(mod.CargaTablaPedidos());
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.vista.Tabla_Pedidos && e.getButton() == 1) {

            String pedido;
            int fila = this.vista.Tabla_Pedidos.rowAtPoint(e.getPoint());
            if (fila > -1) {
                pedido = String.valueOf(this.vista.Tabla_Pedidos.getValueAt(fila, 0));
                num_Ped = Integer.parseInt(pedido);
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
