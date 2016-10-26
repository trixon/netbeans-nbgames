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
package org.nbgames.core.actions;

import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle;

/**
 *
 * @author Patrik Karlsson <patrik@trixon.se>
 */
public class OptionsCallbackAction {

    @ActionID(category = "Game",
            id = "org.nbgames.core.actions.OptionsAction")
    @ActionRegistration(displayName = "#CTL_GameOptionsAction")
    @ActionReferences({
        @ActionReference(path = "Shortcuts", name = "D-P")
    })
    @NbBundle.Messages("CTL_GameOptionsAction=Options")
    public static final String KEY = "OptionsCallbackAction";
}
