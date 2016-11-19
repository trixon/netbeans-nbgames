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
package org.nbgames.core.game;

import java.util.Random;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import org.nbgames.core.DictNbg;
import org.nbgames.core.Player;
import org.nbgames.core.PlayerManager;

/**
 *
 * @author Patrik Karlsson
 */
public class SelectPlayersPanel extends javax.swing.JPanel {

    private int mMaxNumOfPlayers = 8;
    private JComboBox<Player>[] mCombos;
    private DefaultComboBoxModel<Player>[] mModels;

    /**
     * Creates new form PlayersPanel
     */
    public SelectPlayersPanel() {
        initComponents();
        setMaxNumOfPlayers(mMaxNumOfPlayers);
    }

    public JLabel getLabel() {
        return numOfPlayersLabel;
    }

    public int getMaxNumOfPlayers() {
        return mMaxNumOfPlayers;
    }

    public void setMaxNumOfPlayers(int maxNumOfPlayers) {
        SwingUtilities.invokeLater(() -> {
            mMaxNumOfPlayers = maxNumOfPlayers;
            mCombos = new JComboBox[mMaxNumOfPlayers];
            mModels = new DefaultComboBoxModel[mMaxNumOfPlayers];
            JPanel parent;

            for (int i = 0; i < mMaxNumOfPlayers; i++) {
                mModels[i] = new DefaultComboBoxModel<>(PlayerManager.INSTANCE.getPlayersArray());
                mCombos[i] = new JComboBox<>(mModels[i]);
                parent = (i & 1) == 0 ? leftPanel : rightPanel;
                parent.add(mCombos[i]);
            }
            numberSpinner.setValue(6);
            numberSpinnerStateChanged(null);
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        numOfPlayersLabel = new javax.swing.JLabel();
        numberSpinner = new javax.swing.JSpinner();
        shuffleButton = new javax.swing.JButton();
        mainPanel = new javax.swing.JPanel();
        leftPanel = new javax.swing.JPanel();
        rightPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();

        setLayout(new java.awt.GridBagLayout());

        org.openide.awt.Mnemonics.setLocalizedText(numOfPlayersLabel, DictNbg.PLAYERS.toString());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        add(numOfPlayersLabel, gridBagConstraints);

        numberSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, 8, 1));
        numberSpinner.setMinimumSize(new java.awt.Dimension(64, 26));
        numberSpinner.setPreferredSize(new java.awt.Dimension(64, 26));
        numberSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                numberSpinnerStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        add(numberSpinner, gridBagConstraints);

        org.openide.awt.Mnemonics.setLocalizedText(shuffleButton, DictNbg.SHUFFLE.toString());
        shuffleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shuffleButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        add(shuffleButton, gridBagConstraints);

        mainPanel.setLayout(new java.awt.GridLayout());

        leftPanel.setLayout(new javax.swing.BoxLayout(leftPanel, javax.swing.BoxLayout.PAGE_AXIS));
        mainPanel.add(leftPanel);

        rightPanel.setLayout(new javax.swing.BoxLayout(rightPanel, javax.swing.BoxLayout.PAGE_AXIS));
        mainPanel.add(rightPanel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        add(mainPanel, gridBagConstraints);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.weighty = 1.0;
        add(jPanel1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void numberSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_numberSpinnerStateChanged
        int players = (Integer) numberSpinner.getValue();
        for (int i = 0; i < mMaxNumOfPlayers; i++) {
            mCombos[i].setEnabled(i < players);
        }
    }//GEN-LAST:event_numberSpinnerStateChanged

    private void shuffleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shuffleButtonActionPerformed
        int num = (Integer) numberSpinner.getValue();
        Random r = new Random();

        for (int i = 0; i < num; i++) {
            int swapWith = r.nextInt(num);
            int temp = mCombos[swapWith].getSelectedIndex();
            mCombos[swapWith].setSelectedIndex(mCombos[i].getSelectedIndex());
            mCombos[i].setSelectedIndex(temp);
        }
    }//GEN-LAST:event_shuffleButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel numOfPlayersLabel;
    private javax.swing.JSpinner numberSpinner;
    private javax.swing.JPanel rightPanel;
    private javax.swing.JButton shuffleButton;
    // End of variables declaration//GEN-END:variables
}
