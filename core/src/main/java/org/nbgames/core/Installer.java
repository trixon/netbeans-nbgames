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
package org.nbgames.core;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import org.nbgames.core.api.NbGames;
import org.openide.modules.ModuleInstall;
import org.openide.util.NbPreferences;
import se.trixon.almond.nbp.swing.NoTabsTabDisplayerUI;
import se.trixon.almond.util.AlmondOptions;
import se.trixon.almond.util.icons.IconColor;

/**
 *
 * @author Patrik Karlström
 */
public class Installer extends ModuleInstall {

    public Installer() {
        IconColor.initSwing();
        AlmondOptions.getInstance().setPreferences(NbPreferences.forModule(Installer.class));
    }

    @Override
    public void restored() {
        SwingUtilities.invokeLater(() -> {
            UIManager.put("EditorTabDisplayerUI", NoTabsTabDisplayerUI.ID);
            UIManager.put("NbMainWindow.showCustomBackground", Boolean.TRUE);
            System.setProperty("netbeans.winsys.status_line.path", "");
        });

        NbGames.outln(NbGames.LOG_TITLE, "nbGames Platform loaded");
    }
}
