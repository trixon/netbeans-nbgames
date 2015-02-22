/* 
 * Copyright 2015 Patrik Karlsson.
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
package org.nbgames.core.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;
import org.openide.awt.Actions;
import org.openide.awt.Mnemonics;
import org.openide.filesystems.FileUtil;
import se.trixon.almond.dictionary.Dict;

/**
 *
 * @author Patrik Karlsson <patrik@trixon.se>
 */
@ActionID(
        category = "System",
        id = "org.nbgames.core.actions.SystemMenuAction"
)
@ActionRegistration(
        iconBase = "org/nbgames/core/res/format-justify-fill.png",
        displayName = "#CTL_SystemMenuAction"
)
@ActionReferences({
    @ActionReference(path = "Toolbars/System", position = 9999)
})
public final class SystemMenuAction implements ActionListener {

    private final JPopupMenu mPopup = new JPopupMenu();

    public SystemMenuAction() {

        JMenu menu;
        mPopup.add(new JMenuItem(String.valueOf(System.currentTimeMillis())));

        menu = FileUtil.getConfigObject("Menu/File/Dice.shadow", JMenu.class);
        try {
            mPopup.add(menu);
        } catch (Exception e) {
        }

        mPopup.add(new JSeparator());

        add(mPopup, "System", "org.netbeans.modules.autoupdate.ui.actions.PluginManagerAction");
        add(mPopup, "Window", "org.netbeans.modules.options.OptionsWindowAction");
        add(mPopup, "Window", "org.netbeans.core.windows.actions.ToolbarsListAction");
        mPopup.add(new JSeparator());

        menu = new JMenu(Dict.HELP.getString());
        add(menu, "Help", "org.netbeans.core.actions.AboutAction");
        mPopup.add(menu);
        mPopup.add(new JSeparator());

        add(mPopup, "File", "se.trixon.almond.actions.QuitAction");
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JButton button = (JButton) actionEvent.getSource();
        mPopup.show(button, button.getWidth() - mPopup.getWidth(), button.getHeight());

        int x = button.getLocationOnScreen().x + button.getWidth() - mPopup.getWidth();
        int y = button.getLocationOnScreen().y + button.getHeight();

        mPopup.setLocation(x, y);
    }

    private void add(JComponent parentMenu, String category, String id) {
        Action a = Actions.forID(category, id);
        JMenuItem menu = new JMenuItem(a);
        Mnemonics.setLocalizedText(menu, a.getValue(Action.NAME).toString());
        parentMenu.add(menu);
    }
}
