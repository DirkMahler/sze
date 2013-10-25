// ZeugnisErfassungsService.java
//
// Licensed under the AGPL - http://www.gnu.org/licenses/agpl-3.0.txt
// (c) SZE-Development-Team

package net.sf.sze.service.api;

import net.sf.sze.model.stammdaten.Klasse;
import net.sf.sze.model.zeugnis.Bewertung;
import net.sf.sze.model.zeugnis.Schulhalbjahr;
import net.sf.sze.model.zeugnis.Zeugnis;

import java.util.List;

/**
 * Service mit Diensten zum Erfassen von Zeugnisse.
 *
 */
public interface ZeugnisErfassungsService {

    /**
     * Liefert eine Liste mit allen auf aktive gesetzten Schulhalbjahren.
     * @return eine Liste mit allen auf aktive gesetzten Schulhalbjahren.
     */
    List<Schulhalbjahr> getActiveSchulhalbjahre();

    /**
     * Liefert eine Liste mit alle möglichen Klassen zu den aktiven Schulhalbjahren.
     * @param acticeSchulhalbjahre aktive Schulhalbjahren.
     * @return eine Liste mit alle möglichen Klassen zu den aktiven Schulhalbjahren.
     */
    List<Klasse> getActiveKlassen(List<Schulhalbjahr> acticeSchulhalbjahre);

    /**
     * Listet alle Zeugnisse zu der Klasse des selektierbaren Schulhalbjahres.
     *
     * @param halbjahrId die Id des Schulhalbjahres.
     * @param klassenId die Id der Klasse.
     * @return alle Zeugnisse zu der Klasse des Schulhalbjahres.
     */
    List<Zeugnis> getZeugnisse(long halbjahrId, long klassenId);


    /**
     * Teilt die Bewertungen auf die beiden Listen auf und sortiert diese.
     * @param bewertungen alle Bewertungen.
     * @param wpBewertungen Wahlpflichtbewertungen
     * @param otherBewertungen andere Bewertungen.
     */
    void splitBewertungslist(List<Bewertung> bewertungen,
            final List<Bewertung> wpBewertungen,
            final List<Bewertung> otherBewertungen);

    /**
     * Liefert die Bewertungen mit den Nachbarn.
     * @param bewertungsId die Bewertungs-Id
     * @return eine Bewertung mit den Ids des Nachbarbewertungen.
     */
    BewertungWithNeigbors getBewertungWithNeighbors(Long bewertungsId);

    /**
     * Liest ein Zeugnis.
     * @param halbjahrId die HalbjahrsId
     * @param klassenId die KlassenId
     * @param schuelerId die Id des Schülers
     */
    Zeugnis getZeugnis(Long halbjahrId, Long klassenId, Long schuelerId);


    /**
     * Sichert das Zeugnis, wobei Veränderungen auf der <b>Inverse-Side nicht
     * berücksichtigt</b> werden!
     *
     * @param zeugnis das zu speichernde Zeugnis.
     * @return das gespeicherte Zeugnis.
     *
     */
    Zeugnis save(Zeugnis zeugnis);
}
