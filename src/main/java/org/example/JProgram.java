package org.example;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.io.File;
import java.io.IOException;

public class JProgram extends javax.swing.JFrame {
    private DataManipulation dataManipulation = new DataManipulation();
    public JProgram() throws IOException {
        initComponents();
        dataManipulation.createFiles();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel = new javax.swing.JPanel();
        jButtonImport = new javax.swing.JButton();
        jButtonGibbon = new javax.swing.JButton();
        jButtonGorill = new javax.swing.JButton();
        jScrollPane = new javax.swing.JScrollPane();
        jTreeMonkey = new javax.swing.JTree();
        jButtonExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jTreeMonkey.setModel(new DefaultTreeModel(new DefaultMutableTreeNode("Обезьяны")));
        jButtonImport.setText("Импорт файла");
        jButtonImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonImportActionPerformed(evt);
            }
        });

        jButtonGibbon.setText("Встретить гиббона");
        jButtonGibbon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGibbonActionPerformed(evt);
            }
        });

        jButtonGorill.setText("Встретить гориллу");
        jButtonGorill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGorillActionPerformed(evt);
            }
        });

        jTreeMonkey.setAutoscrolls(true);
        jScrollPane.setViewportView(jTreeMonkey);

        jButtonExit.setText("Выход");
        jButtonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButtonGibbon, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonImport, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonGorill, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonExit)
                        .addGap(113, 113, 113)))
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jButtonImport)
                .addGap(43, 43, 43)
                .addComponent(jButtonGibbon)
                .addGap(44, 44, 44)
                .addComponent(jButtonGorill)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonExit)
                .addGap(38, 38, 38))
            .addGroup(jPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExitActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonExitActionPerformed

    private void jButtonImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonImportActionPerformed
        JFileChooser chooser = new JFileChooser();
        String currentDir = System.getProperty("user.dir");
        chooser.setCurrentDirectory(new File(currentDir));
        chooser.setDialogTitle("Выберите файл");

        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            jTreeMonkey.setModel(new DefaultTreeModel(new DefaultMutableTreeNode("Обезьяны")));
            try {
                File file = chooser.getSelectedFile();
                dataManipulation.importData(String.valueOf(file));
                jTreeMonkey.setModel(new DefaultTreeModel(dataManipulation.addInfo2GUI()));
            }catch (Exception r){
                JOptionPane.showMessageDialog (null, "Ошибка чтения файла", "Oшибка", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButtonImportActionPerformed

    private void jButtonGibbonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGibbonActionPerformed
        if (dataManipulation.hasMonkey()) {
            try {
                dataManipulation.meetGibon();
                JOptionPane.showMessageDialog(null, "Кол-во сигарет в пачке не изменилось!", "Oшибка", JOptionPane.ERROR_MESSAGE);
            } catch (Exception r) {
                jTreeMonkey.setModel(new DefaultTreeModel(dataManipulation.addInfo2GUI()));
                JOptionPane.showMessageDialog(null, "Добавлена сигарета!", "ОК", JOptionPane.INFORMATION_MESSAGE);
            }
        }else JOptionPane.showMessageDialog(null, "Данные не загружены", "Oшибка", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_jButtonGibbonActionPerformed

    private void jButtonGorillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGorillActionPerformed
        if (dataManipulation.hasMonkey()) {
            try {
                dataManipulation.meetGorilla();
                JOptionPane.showMessageDialog(null, "Кол-во сигарет в пачке не изменилось!", "Oшибка", JOptionPane.ERROR_MESSAGE);
            } catch (Exception r) {
                jTreeMonkey.setModel(new DefaultTreeModel(dataManipulation.addInfo2GUI()));
                JOptionPane.showMessageDialog(null, "Забрали сигарету!", "ОК", JOptionPane.INFORMATION_MESSAGE);
            }
        }else JOptionPane.showMessageDialog(null, "Данные не загружены", "Oшибка", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_jButtonGorillActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonExit;
    private javax.swing.JButton jButtonGibbon;
    private javax.swing.JButton jButtonGorill;
    private javax.swing.JButton jButtonImport;
    private javax.swing.JPanel jPanel;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JTree jTreeMonkey;
    // End of variables declaration//GEN-END:variables
}
