package ro.nicubunu.cards;

import org.nbgames.core.card.CardDeckSupplier;
import org.openide.util.NbBundle;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author Patrik Karlsson <patrik@trixon.se>
 */
@ServiceProvider(service = CardDeckSupplier.class)
public class NicusOrnamental implements CardDeckSupplier {

    @Override
    public String getName() {
        return NbBundle.getMessage(this.getClass(), "CTL_NicusOrnamental");
    }

    @Override
    public String getPath() {
        return "ro/nicubunu/cards/ornamental/";
    }
}
