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
public class VistaInventario extends javax.swing.JPanel {

    /**
     * Creates new form VistaInventario
     */
    public VistaInventario() {
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
        Tabla_Inventario = new javax.swing.JTable();
        idArtLabel = new javax.swing.JLabel();
        nombreArtLabel = new javax.swing.JLabel();
        cantidadLabel = new javax.swing.JLabel();
        precioLabel = new javax.swing.JLabel();
        barIdLabel = new javax.swing.JLabel();
        Txt_IdArticulo = new javax.swing.JTextField();
        Txt_NombreArticulo = new javax.swing.JTextField();
        Txt_Cantidad = new javax.swing.JTextField();
        Txt_Precio = new javax.swing.JTextField();
        Txt_IdBar = new javax.swing.JTextField();
        Boton_Modificar = new javax.swing.JButton();
        Boton_Insertar = new javax.swing.JButton();
        Boton_Eliminar = new javax.swing.JButton();

        masterScrollPane.setViewportView(Tabla_Inventario);

        idArtLabel.setText("Id Art:");

        nombreArtLabel.setText("Nombre Art:");

        cantidadLabel.setText("Cantidad:");

        precioLabel.setText("Precio:");

        barIdLabel.setText("Bar Id:");

        Boton_Modificar.setText("Modificar");

        Boton_Insertar.setText("Insertar");

        Boton_Eliminar.setText("Borrar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Boton_Insertar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Boton_Eliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Boton_Modificar)
                        .addGap(77, 77, 77))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(idArtLabel)
                                    .addComponent(nombreArtLabel)
                                    .addComponent(cantidadLabel)
                                    .addComponent(precioLabel)
                                    .addComponent(barIdLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Txt_IdArticulo, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                                    .addComponent(Txt_NombreArticulo, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                                    .addComponent(Txt_Cantidad, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                                    .addComponent(Txt_Precio, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                                    .addComponent(Txt_IdBar, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)))
                            .addComponent(masterScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(masterScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idArtLabel)
                    .addComponent(Txt_IdArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(barIdLabel)
                    .addComponent(Txt_IdBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Boton_Modificar)
                    .addComponent(Boton_Eliminar)
                    .addComponent(Boton_Insertar))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Boton_Eliminar;
    private javax.swing.JButton Boton_Insertar;
    private javax.swing.JButton Boton_Modificar;
    private javax.swing.JTable Tabla_Inventario;
    public javax.swing.JTextField Txt_Cantidad;
    public javax.swing.JTextField Txt_IdArticulo;
    public javax.swing.JTextField Txt_IdBar;
    public javax.swing.JTextField Txt_NombreArticulo;
    public javax.swing.JTextField Txt_Precio;
    public javax.swing.JLabel barIdLabel;
    public javax.swing.JLabel cantidadLabel;
    public javax.swing.JLabel idArtLabel;
    public javax.swing.JScrollPane masterScrollPane;
    public javax.swing.JLabel nombreArtLabel;
    public javax.swing.JLabel precioLabel;
    // End of variables declaration//GEN-END:variables
}
