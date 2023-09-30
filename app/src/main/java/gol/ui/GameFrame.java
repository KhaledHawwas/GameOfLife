package gol.ui;

import gol.GameOfLife;
import gol.Vars;

import java.awt.*;
import java.awt.event.MouseAdapter;

public class GameFrame extends javax.swing.JFrame {

    private final SettingDialog settingDialog = new SettingDialog();

    public GameFrame() {
        initComponents();//created bt Netbeans
        update();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pauseBTN = new javax.swing.JButton();
        // Variables declaration - do not modify//GEN-BEGIN:variables
        javax.swing.JButton clearBTN = new javax.swing.JButton();
        javax.swing.JButton refreshBTN = new javax.swing.JButton();
        javax.swing.JButton settingBTN = new javax.swing.JButton();
        gamePanel = new GamePanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Game of Life");
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        pauseBTN.setFont(new java.awt.Font("Leelawadee UI", Font.PLAIN, 11)); // NOI18N
        pauseBTN.setText("pause");
        pauseBTN.addActionListener(evt -> pauseBTNActionPerformed(evt));

        clearBTN.setFont(new java.awt.Font("Leelawadee UI", Font.PLAIN, 11)); // NOI18N
        clearBTN.setText("clear");
        clearBTN.addActionListener(evt -> clearBTNActionPerformed(evt));

        refreshBTN.setFont(new java.awt.Font("Leelawadee UI", Font.PLAIN, 11)); // NOI18N
        refreshBTN.setText("refresh");
        refreshBTN.setToolTipText("");
        refreshBTN.addActionListener(evt -> refreshBTNActionPerformed(evt));

        settingBTN.setFont(new java.awt.Font("Leelawadee UI", Font.PLAIN, 11)); // NOI18N
        settingBTN.setText("setting");
        settingBTN.setToolTipText("");
        settingBTN.addActionListener(evt -> settingBTNActionPerformed(evt));

        gamePanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gamePanelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout gamePanelLayout = new javax.swing.GroupLayout(gamePanel);
        gamePanel.setLayout(gamePanelLayout);
        gamePanelLayout.setHorizontalGroup(
            gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        gamePanelLayout.setVerticalGroup(
            gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(gamePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(pauseBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clearBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(refreshBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(settingBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pauseBTN)
                    .addComponent(clearBTN)
                    .addComponent(refreshBTN)
                    .addComponent(settingBTN))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gamePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pauseBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pauseBTNActionPerformed
        if(GameOfLife.isRunning)
            GameOfLife.pause();
        else
            GameOfLife.resume();
    }//GEN-LAST:event_pauseBTNActionPerformed

    private void clearBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBTNActionPerformed
        GameOfLife.game.clear();
        update();
    }//GEN-LAST:event_clearBTNActionPerformed

    private void refreshBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBTNActionPerformed
        GameOfLife.game.restart(Vars.defaultRatio);
        update();
    }//GEN-LAST:event_refreshBTNActionPerformed

    private void settingBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingBTNActionPerformed
        settingDialog.setVisible(true);
    }//GEN-LAST:event_settingBTNActionPerformed

    private void gamePanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gamePanelMouseClicked
        gamePanel.click(evt.getX(), evt.getY());
        GameOfLife.pause();
        update();
    }//GEN-LAST:event_gamePanelMouseClicked

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        gamePanelMouseClicked(evt);
    }//GEN-LAST:event_formMouseClicked
    public void update() {
        this.repaint();
        pauseBTN.setText((GameOfLife.isRunning ? "pause" : "run"));
    }

    private GamePanel gamePanel;
    private javax.swing.JButton pauseBTN;
    // End of variables declaration//GEN-END:variables
}
