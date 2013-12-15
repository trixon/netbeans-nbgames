package org.nbgames.numberguesser;

import java.awt.Dimension;
import java.util.Random;
import javax.swing.SpinnerNumberModel;
import org.nbgames.core.NbGames;
import org.openide.util.NbBundle;

/**
 *
 * @author Patrik Karlsson <patrik@trixon.se>
 */
@NbBundle.Messages({
    "CTL_StatusEquals=Congratulations!",
    "CTL_StatusHigh=To high...",
    "CTL_StatusLow=To low..."
})

public class GamePanel extends org.nbgames.core.game.GamePanel {

    GameController mGameController;
    private int mValue;
    private int mCounter;
    private Random mRandom = new Random();

    /**
     * Creates new form NumberGuesserGamePanel
     */
    public GamePanel() {
        initComponents();

        Dimension dimension = new Dimension(400, 300);

        setMinimumSize(dimension);
        setPreferredSize(dimension);
        setSize(dimension);
        setOpaque(false);
    }

    public GamePanel(GameController gameController) {
        this();

        mGameController = gameController;
    }

    void startNewGame() {
        NbGames.log("NumberGuesser: startNewGame");

        int min = (Integer) ((SpinnerNumberModel) valueSpinner.getModel()).getMinimum();
        int max = (Integer) ((SpinnerNumberModel) valueSpinner.getModel()).getMaximum();
        ((SpinnerNumberModel) valueSpinner.getModel()).setValue(min);

        String info = NbBundle.getMessage(GamePanel.class, "GamePanel.infoLabel.text", min, max);
        infoLabel.setText(info);
        valueSpinner.setEnabled(true);
        guessButton.setEnabled(true);
        statusLabel.setText(NbBundle.getMessage(this.getClass(), "GamePanel.statusLabel.text"));

        mValue = min + mRandom.nextInt(max - min + 1);
        mCounter=0;
        NbGames.log("NumberGuesser: value=" + mValue);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        valueSpinner = new javax.swing.JSpinner();
        guessButton = new javax.swing.JButton();
        statusLabel = new javax.swing.JLabel();
        infoLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(51, 255, 51));

        valueSpinner.setFont(new java.awt.Font("DejaVu Sans", 0, 48)); // NOI18N
        valueSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, 1000, 1));

        guessButton.setFont(new java.awt.Font("DejaVu Sans", 0, 48)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(guessButton, org.openide.util.NbBundle.getMessage(GamePanel.class, "GamePanel.guessButton.text")); // NOI18N
        guessButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guessButtonActionPerformed(evt);
            }
        });

        statusLabel.setFont(new java.awt.Font("DejaVu Sans", 0, 48)); // NOI18N
        statusLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        org.openide.awt.Mnemonics.setLocalizedText(statusLabel, org.openide.util.NbBundle.getMessage(GamePanel.class, "GamePanel.statusLabel.text")); // NOI18N

        infoLabel.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        infoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        org.openide.awt.Mnemonics.setLocalizedText(infoLabel, org.openide.util.NbBundle.getMessage(GamePanel.class, "GamePanel.infoLabel.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(guessButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(valueSpinner, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(infoLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(statusLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(infoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(valueSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(guessButton)
                .addGap(18, 18, 18)
                .addComponent(statusLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void guessButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guessButtonActionPerformed
        mCounter++;
        int value = ((SpinnerNumberModel) valueSpinner.getModel()).getNumber().intValue();
        String status = null;
        if (value == mValue) {
            status = Bundle.CTL_StatusEquals();
            valueSpinner.setEnabled(false);
            guessButton.setEnabled(false);
        } else if (value > mValue) {
            status = Bundle.CTL_StatusHigh();
        } else if (value < mValue) {
            status = Bundle.CTL_StatusLow();
        }
        statusLabel.setText(String.format("(%d) %s", mCounter, status));
    }//GEN-LAST:event_guessButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton guessButton;
    private javax.swing.JLabel infoLabel;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JSpinner valueSpinner;
    // End of variables declaration//GEN-END:variables
}
