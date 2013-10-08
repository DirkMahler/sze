// SchuelerDao.java
//
// Licensed under the AGPL - http://www.gnu.org/licenses/agpl-3.0.txt
// (c) SZE-Development-Team

package net.sf.sze.dao.api.stammdaten;

import net.sf.sze.model.stammdaten.Schueler;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * DAO fürs {@link Schueler}.
 *
 */
public interface SchuelerDao extends PagingAndSortingRepository<Schueler,
        Long> {
    // Noch keine speziellen Methoden.
}
