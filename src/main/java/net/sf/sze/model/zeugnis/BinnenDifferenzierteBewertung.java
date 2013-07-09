// BinnenDifferenzierteBewertung.java
//
// (c) SZE-Development-Team

package net.sf.sze.model.zeugnis;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Bewertung mit drei verschiedenen Niveaus.
 *
 */
@Entity
@DiscriminatorValue("net.sf.sze.zeugnis.BinnenDifferenzierteBewertung")
public class BinnenDifferenzierteBewertung extends Bewertung {

    // TODO der NotNull-Constraint gilt nur für diese SubKlasse :-/
    // leistungsniveau(inList:['G','E','Z'], nullable:false)
    //TODO sollte DreiNiveauBewertung heißen.
    BinnenDifferenzierteBewertung() {
        super();
        init();
    }


    private void init() {
        setLeistungsniveau("G");
    }



    @Override
    public String toString() {
        return super.toString();
    }
}
