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
public class VistaPersona extends javax.swing.JPanel {

    /**
     * Creates new form VistaPersona
     */
    public VistaPersona() {
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

        nombrePersLabel = new javax.swing.JLabel();
        domicilioPerLabel = new javax.swing.JLabel();
        dniPerLabel = new javax.swing.JLabel();
        funcionLabel = new javax.swing.JLabel();
        titularLabel = new javax.swing.JLabel();
        Txt_NombrePersona = new javax.swing.JTextField();
        Txt_DomicilioPersona = new javax.swing.JTextField();
        Txt_DniPersona = new javax.swing.JTextField();
        Txt_Funcion = new javax.swing.JTextField();
        Txt_Titular = new javax.swing.JTextField();
        Boton_Modificar = new javax.swing.JButton();
        Boton_Insertar = new javax.swing.JButton();
        Boton_Borrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla_Personas = new javax.swing.JTable();

        nombrePersLabel.setText("Nombre Pers:");

        domicilioPerLabel.setText("Domicilio Per:");

        dniPerLabel.setText("Dni Per:");

        funcionLabel.setText("Funcion:");

        titularLabel.setText("Titular:");

        Boton_Modificar.setText("Modificar");

        Boton_Insertar.setText("Insertar");

        Boton_Borrar.setText("Borrar");

        Tabla_Personas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(Tabla_Personas);

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
                                    .addComponent(nombrePersLabel)
                                    .addComponent(domicilioPerLabel)
                                    .addComponent(dniPerLabel)
                                    .addComponent(funcionLabel)
                                    .addComponent(titularLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Txt_NombrePersona, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                                    .addComponent(Txt_DomicilioPersona, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                                    .addComponent(Txt_DniPersona, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                                    .addComponent(Txt_Funcion, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                                    .addComponent(Txt_Titular, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombrePersLabel)
                    .addComponent(Txt_NombrePersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(domicilioPerLabel)
                    .addComponent(Txt_DomicilioPersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dniPerLabel)
                    .addComponent(Txt_DniPersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(funcionLabel)
                    .addComponent(Txt_Funcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titularLabel)
                    .addComponent(Txt_Titular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Boton_Modificar)
                    .addComponent(Boton_Borrar)
                    .addComponent(Boton_Insertar))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton Boton_Borrar;
    public javax.swing.JButton Boton_Insertar;
    public javax.swing.JButton Boton_Modificar;
    public javax.swing.JTable Tabla_Personas;
    public javax.swing.JTextField Txt_DniPersona;
    public javax.swing.JTextField Txt_DomicilioPersona;
    public javax.swing.JTextField Txt_Funcion;
    public javax.swing.JTextField Txt_NombrePersona;
    public javax.swing.JTextField Txt_Titular;
    public javax.swing.JLabel dniPerLabel;
    public javax.swing.JLabel domicilioPerLabel;
    public javax.swing.JLabel funcionLabel;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel nombrePersLabel;
    public javax.swing.JLabel titularLabel;
    // End of variables declaration//GEN-END:variables
}
