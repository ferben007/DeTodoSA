/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package detodosa;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ferben007
 */
public class PorRubro extends javax.swing.JInternalFrame {
private DefaultTableModel modelo = new DefaultTableModel() {
        public boolean isCellEditable(int filas, int columnas) {
            return false;
        }
    };
    /**
     * Creates new form PorRubro
     */
    public PorRubro() {
        initComponents();
        armarTabla();
        cargarItem();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jcRubro = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtProducto = new javax.swing.JTable();

        jLabel2.setText("Busqueda Por Rubro");

        jcRubro.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcRubroItemStateChanged(evt);
            }
        });
        jcRubro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcRubroActionPerformed(evt);
            }
        });

        jtProducto.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtProducto);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(jcRubro, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jcRubro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcRubroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcRubroActionPerformed
        // TODO add your handling code here:
   
    }//GEN-LAST:event_jcRubroActionPerformed

    private void jcRubroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcRubroItemStateChanged
        // TODO add your handling code here:
             
        Categoria sele =(Categoria) jcRubro.getSelectedItem();
        if(evt.getStateChange() == java.awt.event.ItemEvent.DESELECTED ){
            borraFila();
         for (Producto pr : MenuGeneral.listaProducto) {
                if (sele == pr.getRubro()) {
                    modelo.addRow(new Object[]{pr.getCodigo(), pr.getDescripcion(), pr.getPrecio(), pr.getStock(), pr.getRubro()});
                }
                }
        }
    }//GEN-LAST:event_jcRubroItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<Categoria> jcRubro;
    private javax.swing.JTable jtProducto;
    // End of variables declaration//GEN-END:variables
private void armarTabla() {
        modelo.addColumn("Codigo");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Precio");
        modelo.addColumn("Stock");
        modelo.addColumn("Rubro");
        jtProducto.setModel(modelo);
    }
private void cargarItem(){
    //jcRubro.addItem(Categoria.valueOf(""));
    jcRubro.addItem(Categoria.COMESTIBLES);
    jcRubro.addItem(Categoria.LIMPIEZA);
    jcRubro.addItem(Categoria.PERFUMERIA);
}
   private void borraFila() {
        int fila = jtProducto.getRowCount() - 1;
        for (int f = fila; f >= 0; f--) {
            modelo.removeRow(f);
        }
    }
}
