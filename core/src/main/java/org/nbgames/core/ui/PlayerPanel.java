/* 
 * Copyright 2016 Patrik Karlsson.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.nbgames.core.ui;

import javax.swing.JPanel;
import org.nbgames.core.api.Player;
import org.nbgames.core.api.Player.Handedness;

/**
 *
 * @author Patrik Karlsson
 */
public class PlayerPanel extends JPanel {

    private Player mPlayer = new Player();

    /**
     * Creates new PlayerPanel
     */
    public PlayerPanel() {
        initComponents();
    }

    public Player getPlayer() {
        Handedness handedness = rightRadioButton.isSelected() ? Handedness.RIGHT : Handedness.LEFT;
        return new Player(mPlayer.getId(), nameTextField.getText(), handedness);
    }

    public void setPlayer(Player player) {
        mPlayer = player;
        nameTextField.setText(player.getName());

        if (player.getHandedness() == Player.Handedness.LEFT) {
            leftRadioButton.doClick();
        } else {
            rightRadioButton.doClick();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        nameLabel = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        handednessPanel = new javax.swing.JPanel();
        leftRadioButton = new javax.swing.JRadioButton();
        rightRadioButton = new javax.swing.JRadioButton();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(16, 16, 16, 16));

        org.openide.awt.Mnemonics.setLocalizedText(nameLabel, org.openide.util.NbBundle.getMessage(PlayerPanel.class, "PlayerPanel.nameLabel.text")); // NOI18N

        handednessPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(PlayerPanel.class, "PlayerPanel.handednessPanel.border.title"))); // NOI18N
        handednessPanel.setLayout(new java.awt.GridLayout(1, 0));

        buttonGroup1.add(leftRadioButton);
        leftRadioButton.setFont(leftRadioButton.getFont().deriveFont((float)36));
        org.openide.awt.Mnemonics.setLocalizedText(leftRadioButton, "☛"); // NOI18N
        leftRadioButton.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        leftRadioButton.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        handednessPanel.add(leftRadioButton);

        buttonGroup1.add(rightRadioButton);
        rightRadioButton.setFont(rightRadioButton.getFont().deriveFont((float)36));
        rightRadioButton.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(rightRadioButton, "☚"); // NOI18N
        handednessPanel.add(rightRadioButton);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(nameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(nameLabel)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(handednessPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(nameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(handednessPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel handednessPanel;
    private javax.swing.JRadioButton leftRadioButton;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JRadioButton rightRadioButton;
    // End of variables declaration//GEN-END:variables
}
