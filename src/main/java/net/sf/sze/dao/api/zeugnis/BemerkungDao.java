// BemerkungDao.java
//
// Licensed under the AGPL - http://www.gnu.org/licenses/agpl-3.0.txt
// (c) SZE-Development-Team

package net.sf.sze.dao.api.zeugnis;

import net.sf.sze.model.zeugnis.Bemerkung;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * DAO fürs {@link Bemerkung}.
 *
 */
public interface BemerkungDao extends PagingAndSortingRepository<Bemerkung,
        Long> {
    // Noch keine speziellen Methoden.
}
