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
package ro.nicubunu.cards;

import org.nbgames.core.card.CardDeckSupplier;
import org.openide.util.NbBundle;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author Patrik Karlström
 */
@ServiceProvider(service = CardDeckSupplier.class)
public class NicusWhite implements CardDeckSupplier {

    @Override
    public String getName() {
        return NbBundle.getMessage(this.getClass(), "CTL_NicusWhite");
    }

    @Override
    public String getPath() {
        return "ro/nicubunu/cards/white/";
    }
}
