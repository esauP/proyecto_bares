/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

/**
 *
 * @author esaup
 */
public class VistaPedidos extends javax.swing.JPanel {

    /**
     * Creates new form VistaPedidos
     */
    public VistaPedidos() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        masterScrollPane = new javax.swing.JScrollPane();
        Tabla_Pedidos = new javax.swing.JTable();
        numPedLabel = new javax.swing.JLabel();
        fechaLabel = new javax.swing.JLabel();
        proveedorLabel = new javax.swing.JLabel();
        nombreArtLabel = new javax.swing.JLabel();
        cantidadLabel = new javax.swing.JLabel();
        precioLabel = new javax.swing.JLabel();
        idBarLabel = new javax.swing.JLabel();
        codigoArtLabel = new javax.swing.JLabel();
        Txt_NumeroPedido = new javax.swing.JTextField();
        Txt_Fecha = new javax.swing.JTextField();
        Txt_Proveedor = new javax.swing.JTextField();
        Txt_NombreArticulo = new javax.swing.JTextField();
        Txt_Cantidad = new javax.swing.JTextField();
        Txt_Precio = new javax.swing.JTextField();
        Txt_IdBar = new javax.swing.JTextField();
        Txt_CodigoProducto = new javax.swing.JTextField();
        Boton_Modificar = new javax.swing.JButton();
        Boton_Insertar = new javax.swing.JButton();
        Boton_Borrar = new javax.swing.JButton();

        masterScrollPane.setViewportView(Tabla_Pedidos);

        numPedLabel.setText("Num Ped:");

        fechaLabel.setText("Fecha:");

        proveedorLabel.setText("Proveedor:");

        nombreArtLabel.setText("Nombre Art:");

        cantidadLabel.setText("Cantidad:");

        precioLabel.setText("Precio:");

        idBarLabel.setText("Id Bar:");

        codigoArtLabel.setText("Codigo Art:");

        Boton_Modificar.setText("Refresh");

        Boton_Insertar.setText("New");

        Boton_Borrar.setText("Delete");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Boton_Insertar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Boton_Borrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Boton_Modificar)
                        .addGap(63, 63, 63))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(numPedLabel)
                                    .addComponent(fechaLabel)
                                    .addComponent(proveedorLabel)
                                    .addComponent(nombreArtLabel)
                                    .addComponent(cantidadLabel)
                                    .addComponent(precioLabel)
                                    .addComponent(idBarLabel)
                                    .addComponent(codigoArtLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Txt_NumeroPedido, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                                    .addComponent(Txt_Fecha, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                                    .addComponent(Txt_Proveedor, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                                    .addComponent(Txt_NombreArticulo, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                                    .addComponent(Txt_Cantidad, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                                    .addComponent(Txt_Precio, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                                    .addComponent(Txt_IdBar, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                                    .addComponent(Txt_CodigoProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)))
                            .addComponent(masterScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(masterScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numPedLabel)
                    .addComponent(Txt_NumeroPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fechaLabel)
                    .addComponent(Txt_Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(proveedorLabel)
                    .addComponent(Txt_Proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreArtLabel)
                    .addComponent(Txt_NombreArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cantidadLabel)
                    .addComponent(Txt_Cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(precioLabel)
                    .addComponent(Txt_Precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idBarLabel)
                    .addComponent(Txt_IdBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codigoArtLabel)
                    .addComponent(Txt_CodigoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Boton_Modificar)
                    .addComponent(Boton_Borrar)
                    .addComponent(Boton_Insertar))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Boton_Borrar;
    private javax.swing.JButton Boton_Insertar;
    private javax.swing.JButton Boton_Modificar;
    private javax.swing.JTable Tabla_Pedidos;
    public javax.swing.JTextField Txt_Cantidad;
    public javax.swing.JTextField Txt_CodigoProducto;
    public javax.swing.JTextField Txt_Fecha;
    public javax.swing.JTextField Txt_IdBar;
    public javax.swing.JTextField Txt_NombreArticulo;
    public javax.swing.JTextField Txt_NumeroPedido;
    public javax.swing.JTextField Txt_Precio;
    public javax.swing.JTextField Txt_Proveedor;
    public javax.swing.JLabel cantidadLabel;
    public javax.swing.JLabel codigoArtLabel;
    public javax.swing.JLabel fechaLabel;
    public javax.swing.JLabel idBarLabel;
    public javax.swing.JScrollPane masterScrollPane;
    public javax.swing.JLabel nombreArtLabel;
    public javax.swing.JLabel numPedLabel;
    public javax.swing.JLabel precioLabel;
    public javax.swing.JLabel proveedorLabel;
    // End of variables declaration//GEN-END:variables
}
