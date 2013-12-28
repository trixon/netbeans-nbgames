package org.nbgames.gunu;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import se.trixon.almond.dialogs.ColorChooserDialog;

final class OptionPanel extends javax.swing.JPanel implements DocumentListener {

    private final OptionPanelController mController;
    private final Options mOptions = Options.INSTANCE;

    OptionPanel(OptionPanelController controller) {
        mController = controller;
        initComponents();

        minFormattedTextField.getDocument().addDocumentListener(this);
        maxFormattedTextField.getDocument().addDocumentListener(this);
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        mController.changed();
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        mController.changed();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        mController.changed();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fromLabel = new javax.swing.JLabel();
        minFormattedTextField = new javax.swing.JFormattedTextField();
        toLabel = new javax.swing.JLabel();
        maxFormattedTextField = new javax.swing.JFormattedTextField();
        backgroundButton = new se.trixon.almond.swing.ColorChooserButton();

        org.openide.awt.Mnemonics.setLocalizedText(fromLabel, org.openide.util.NbBundle.getMessage(OptionPanel.class, "OptionPanel.fromLabel.text")); // NOI18N

        minFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        minFormattedTextField.setText("-1000"); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(toLabel, org.openide.util.NbBundle.getMessage(OptionPanel.class, "OptionPanel.toLabel.text")); // NOI18N

        maxFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        maxFormattedTextField.setText("1000"); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(backgroundButton, org.openide.util.NbBundle.getMessage(OptionPanel.class, "OptionPanel.backgroundButton.text")); // NOI18N
        backgroundButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backgroundButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fromLabel)
                    .addComponent(toLabel)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(maxFormattedTextField, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(minFormattedTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(backgroundButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 141, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(fromLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(minFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(toLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(maxFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(backgroundButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backgroundButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backgroundButtonActionPerformed
        backgroundButton.setColor(ColorChooserDialog.showDialog(backgroundButton.getColor()));
    }//GEN-LAST:event_backgroundButtonActionPerformed

    void load() {
        minFormattedTextField.setValue(mOptions.getMin());
        maxFormattedTextField.setValue(mOptions.getMax());
        backgroundButton.setColor(mOptions.getColorBackground());
    }

    void store() {
        mOptions.setMin((Long) minFormattedTextField.getValue());
        mOptions.setMax((Long) maxFormattedTextField.getValue());
        mOptions.setColorBackground(backgroundButton.getColor());
    }

    boolean valid() {
        long min;
        long max;

        min = (Long) minFormattedTextField.getValue();
        max = (Long) maxFormattedTextField.getValue();

        return max > min;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private se.trixon.almond.swing.ColorChooserButton backgroundButton;
    private javax.swing.JLabel fromLabel;
    private javax.swing.JFormattedTextField maxFormattedTextField;
    private javax.swing.JFormattedTextField minFormattedTextField;
    private javax.swing.JLabel toLabel;
    // End of variables declaration//GEN-END:variables
}
