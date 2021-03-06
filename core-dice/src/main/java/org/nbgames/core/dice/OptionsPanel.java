/* 
 * Copyright 2018 Patrik Karlström.
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
package org.nbgames.core.dice;

import org.nbgames.core.api.options.OptionsCategory;
import org.nbgames.core.api.options.NbgOptionsPanel;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author Patrik Karlström
 */
@ServiceProvider(service = NbgOptionsPanel.class)
public class OptionsPanel extends NbgOptionsPanel {

    private final NbgDiceOptions mOptions = NbgDiceOptions.getInstance();

    /**
     * Creates new form OptionsPanel
     */
    public OptionsPanel() {
        initComponents();
    }

    @Override
    public OptionsCategory getCategory() {
        return OptionsCategory.DICE;
    }

    @Override
    public boolean isMaster() {
        return true;
    }

    @Override
    public void load() {
        reverseScrollDirectionCheckBox.setSelected(mOptions.isReverseDirection());
    }

    @Override
    public void save() {
        mOptions.setReverseDirection(reverseScrollDirectionCheckBox.isSelected());
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT
     * modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        reverseScrollDirectionCheckBox = new javax.swing.JCheckBox();

        reverseScrollDirectionCheckBox.setText(org.openide.util.NbBundle.getMessage(OptionsPanel.class, "OptionsPanel.reverseScrollDirectionCheckBox.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(reverseScrollDirectionCheckBox)
                .addContainerGap(187, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(reverseScrollDirectionCheckBox)
                .addContainerGap(263, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox reverseScrollDirectionCheckBox;
    // End of variables declaration//GEN-END:variables
}
