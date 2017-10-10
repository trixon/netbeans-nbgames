/* 
 * Copyright 2017 Patrik Karlsson.
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
import org.nbgames.core.ui.home.HomeProvider;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle;

/**
 *
 * @author Patrik Karlsson
 */
@ActionID(
        category = "Game", id = "org.nbgames.core.actions.HomeAction"
)
@ActionRegistration(
        displayName = "#CTL_HomeAction"
)
@ActionReference(path = "Shortcuts", name = "D-H")
@NbBundle.Messages("CTL_HomeAction=Home")
public final class HomeAction extends NbGameAction {

    @Override
    public void actionPerformed(ActionEvent e) {
        getTopComponent().show(HomeProvider.getInstance());
    }
}
