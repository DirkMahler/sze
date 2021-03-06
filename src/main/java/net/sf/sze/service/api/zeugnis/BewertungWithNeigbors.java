//BewertungWithNeigbors.java
//
// Licensed under the AGPL - http://www.gnu.org/licenses/agpl-3.0.txt
// (c) SZE-Development Team
package net.sf.sze.service.api.zeugnis;

import java.util.List;

import de.ppi.fuwesta.spring.mvc.util.ResourceNotFoundException;
import net.sf.sze.model.zeugnis.Bewertung;


/**
 * Container-Klasse um zu einer Bewertung auch die BewertungsId des
 * Vorgängers  und des Nachfolgers liefern zu können.
 *
 */
public class BewertungWithNeigbors {
    private final Bewertung bewertung;
    private final Long prevBewertungsId;
    private final Long nextBewertungsId;

    /**
     * Initiates an object of type BewertungWithNeigbors.
     * @param bewertung die aktuelle Bewertung.
     * @param prevBewertungsId die Id der vorherigen Bewertung.
     * @param nextBewertungsId die Id der nächsten Bewertung.
     */
    public BewertungWithNeigbors(Bewertung bewertung,
            Long prevBewertungsId, Long nextBewertungsId) {
        super();
        this.bewertung = bewertung;
        this.prevBewertungsId = prevBewertungsId;
        this.nextBewertungsId = nextBewertungsId;
    }

    /**
     *
     * Initiates an object of type BewertungWithNeigbors.
     * @param bewertungen alle Bewertungen.
     * @param bewertungsId die Bewertung zu der die Nachbarn ermittelt werden sollen.
     */
    public BewertungWithNeigbors(List<Bewertung> bewertungen, Long bewertungsId) {
        Long prevId = null;
        Long nextId = null;
        Bewertung selectedBewertung = null;
        for (Bewertung currentBewertung : bewertungen) {
            if ((selectedBewertung != null) && (nextId == null)) {
                nextId = currentBewertung.getId();
            }

            if (bewertungsId.equals(currentBewertung.getId())) {
                selectedBewertung = currentBewertung;
            }

            if (selectedBewertung == null) {
                prevId = currentBewertung.getId();
            }
        }
        if (selectedBewertung == null) {
            throw new ResourceNotFoundException("Es wurde keine Bewertung zur Id "
                    + bewertungsId + " gefunden.");
        }
        this.bewertung = selectedBewertung;
        this.prevBewertungsId = prevId;
        this.nextBewertungsId = nextId;
    }

    /**
     * @return the bewertung
     */
    public Bewertung getBewertung() {
        return bewertung;
    }

    /**
     * @return the prevBewertungsId
     */
    public Long getPrevBewertungsId() {
        return prevBewertungsId;
    }

    /**
     * @return the nextBewertungsId
     */
    public Long getNextBewertungsId() {
        return nextBewertungsId;
    }




}
