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
package org.nbgames.core.options;

import java.awt.CardLayout;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.SwingConstants;
import org.nbgames.core.InstalledGames;
import org.nbgames.core.SystemOptionsPanel;
import org.nbgames.core.api.options.OptionsCategory;
import org.nbgames.core.api.options.NbgOptionsPanel;
import org.nbgames.core.ui.PlayersPanel;
import org.openide.util.Lookup;
import se.trixon.almond.util.Dict;

/**
 *
 * @author Patrik Karlström
 */
public class OptionsContainerPanel extends javax.swing.JPanel {

    private CardLayout mCardLayout;
    private final InstalledGames mInstalledGames = InstalledGames.getInstance();
    private OptionsCategory mOptionsCategory;
    private PlayersPanel mPlayersPanel;
    private SystemOptionsPanel mSystemPanel;
    private final Map<OptionsCategory, CategoryTabbedPane> mCategoryTabbedPanes = new HashMap<>();
    private final ArrayList<NbgOptionsPanel> mCategoryOptionsPanels = new ArrayList<>();

    /**
     * Creates new form OptionsContainerPanel
     */
    public OptionsContainerPanel() {
        initComponents();
        init();
        initSubPanels();
    }

    public void activate(OptionsCategory optionsCategory, String tabName) {
        list.setSelectedValue(optionsCategory, true);
        mCategoryTabbedPanes.get(optionsCategory).setSelectedTab(tabName);
    }

    public void load() {
        mPlayersPanel.load();
        mSystemPanel.load();
        mCategoryOptionsPanels.forEach((optionsPanel) -> {
            try {
                optionsPanel.load();
            } catch (Exception e) {
                //
            }
        });
        mInstalledGames.getGameControllers().forEach((controller) -> {
            try {
                controller.getOptionsPanel().load();
            } catch (NullPointerException e) {
            }
        });
    }

    public void save() {
        mPlayersPanel.save();
        mSystemPanel.save();
        mCategoryOptionsPanels.forEach((optionsPanel) -> {
            try {
                optionsPanel.save();
            } catch (Exception e) {
                //
            }
        });
        mInstalledGames.getGameControllers().forEach((controller) -> {
            try {
                controller.getOptionsPanel().save();
            } catch (NullPointerException | AbstractMethodError e) {
                //FIXME Why is AbstractMethodError needed?
            }
        });
    }

    private void init() {
        mCardLayout = (CardLayout) (categoryPanel.getLayout());
        list.setCellRenderer(new OptionsCategoryRenderer());
        OptionsCategoryListModel listModel = new OptionsCategoryListModel();

        for (OptionsCategory optionsCategory : OptionsCategory.values()) {
            listModel.addElement(optionsCategory);
            mCategoryTabbedPanes.put(optionsCategory, new CategoryTabbedPane());
            categoryPanel.add(mCategoryTabbedPanes.get(optionsCategory), optionsCategory.getTitle());
            Collection<? extends NbgOptionsPanel> optionPanels = Lookup.getDefault().lookupAll(NbgOptionsPanel.class);
            optionPanels.stream().forEach((optionPanel) -> {
                if (optionPanel.isMaster() && optionPanel.getCategory() == optionsCategory) {
                    mCategoryOptionsPanels.add(optionPanel);
                    mCategoryTabbedPanes.get(optionsCategory).addTab(optionsCategory.getTitle(), optionPanel);
                    mCategoryTabbedPanes.get(optionsCategory).setTitle(optionsCategory.getTitle());
                }
            });
        }

        mPlayersPanel = new PlayersPanel();
        mSystemPanel = new SystemOptionsPanel();
        categoryPanel.add(mPlayersPanel, OptionsCategory.PLAYERS.getTitle());
        categoryPanel.add(mSystemPanel, Dict.SYSTEM.toString());

        list.setModel(listModel);
        list.setSelectedIndex(0);
    }

    private void initSubPanels() {
        mInstalledGames.getGameControllers().forEach((controller) -> {
            OptionsCategory optionsCategory = controller.getCategory().getOptionsCategory();
            if (controller.getOptionsPanel() != null) {
                mCategoryTabbedPanes.get(optionsCategory).addTab(controller.getName(), controller.getOptionsPanel());
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT
     * modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPane = new javax.swing.JScrollPane();
        list = new javax.swing.JList<>();
        mainPanel = new javax.swing.JPanel();
        categoryPanel = new javax.swing.JPanel();

        setPreferredSize(new java.awt.Dimension(700, 500));
        setLayout(new java.awt.BorderLayout());

        scrollPane.setPreferredSize(new java.awt.Dimension(200, 282));

        list.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        list.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listValueChanged(evt);
            }
        });
        scrollPane.setViewportView(list);

        add(scrollPane, java.awt.BorderLayout.LINE_START);

        categoryPanel.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(categoryPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(categoryPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE))
        );

        add(mainPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void listValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listValueChanged
        OptionsCategory optionsCategory = list.getSelectedValue();
        if (optionsCategory == null) {
            list.setSelectedValue(mOptionsCategory, true);
        } else {
            mOptionsCategory = optionsCategory;
            mCardLayout.show(categoryPanel, optionsCategory.getTitle());
        }
    }//GEN-LAST:event_listValueChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel categoryPanel;
    private javax.swing.JList<OptionsCategory> list;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JScrollPane scrollPane;
    // End of variables declaration//GEN-END:variables

    class OptionsCategoryListModel extends DefaultListModel<OptionsCategory> {

    }

    class OptionsCategoryRenderer extends JLabel implements ListCellRenderer {

        public OptionsCategoryRenderer() {
            setOpaque(true);
            setVerticalAlignment(SwingConstants.CENTER);
        }

        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            if (isSelected) {
                setBackground(list.getSelectionBackground());
                setForeground(list.getSelectionForeground());
            } else {
                setBackground(list.getBackground());
                setForeground(list.getForeground());
            }
            OptionsCategory category = (OptionsCategory) value;

            if (category != null) {
                setIcon(category.getImageIcon());
                setText(String.format("<html><h3>%s</h3></html>", category.getTitle()));
            } else {
                setText("");
            }
            setBorder(BorderFactory.createEmptyBorder(4, 8, 4, 8));

            return this;
        }
    }
}
