package ro.nicubunu.cards;

import org.nbgames.core.card.CardBackSupplier;
import org.openide.util.NbBundle;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author Patrik Karlsson <patrik@trixon.se>
 */
@ServiceProvider(service = CardBackSupplier.class)
public class NicusBack10 implements CardBackSupplier {

    @Override
    public String getName() {
        return NbBundle.getMessage(this.getClass(), "CTL_Back10");
    }

    @Override
    public String getPath() {
        return "ro/nicubunu/cards/backs/back10.png";
    }
}