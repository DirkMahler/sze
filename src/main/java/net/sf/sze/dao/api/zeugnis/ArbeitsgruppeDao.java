// ArbeitsgruppeDao.java
//
// (c) SZE-Development-Team

package net.sf.sze.dao.api.zeugnis;

import net.sf.sze.model.zeugnis.Arbeitsgruppe;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * DAO fürs {@link Arbeitsgruppe}.
 *
 */
public interface ArbeitsgruppeDao
        extends PagingAndSortingRepository<Arbeitsgruppe, Long> {
    // Noch keine speziellen Methoden.

}
