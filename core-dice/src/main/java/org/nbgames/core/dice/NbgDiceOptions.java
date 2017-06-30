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
package org.nbgames.core.dice;

import java.util.prefs.Preferences;
import org.openide.util.NbPreferences;

/**
 *
 * @author Patrik Karlsson
 */
public class NbgDiceOptions {

    private static final boolean DEFAULT_REVERSE_DIRECTION = false;
    private static final String KEY_REVERSE_DIRECTION = "reverseDirection";
    private final Preferences mPreferences = NbPreferences.forModule(NbgDiceOptions.class);

    public static NbgDiceOptions getInstance() {
        return Holder.INSTANCE;
    }

    private NbgDiceOptions() {
    }

    public Preferences getPreferences() {
        return mPreferences;
    }

    public boolean isReverseDirection() {
        return mPreferences.getBoolean(KEY_REVERSE_DIRECTION, DEFAULT_REVERSE_DIRECTION);
    }

    public void setReverseDirection(boolean state) {
        mPreferences.putBoolean(KEY_REVERSE_DIRECTION, state);
    }

    private static class Holder {

        private static final NbgDiceOptions INSTANCE = new NbgDiceOptions();
    }
}
