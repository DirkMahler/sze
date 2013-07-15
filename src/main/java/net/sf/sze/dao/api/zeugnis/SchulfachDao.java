// SchulfachDao.java
//
// (c) SZE-Development-Team

package net.sf.sze.dao.api.zeugnis;

import net.sf.sze.model.zeugnis.Schulfach;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * DAO fürs {@link Schulfach}.
 *
 */
public interface SchulfachDao extends PagingAndSortingRepository<Schulfach,
        Long> {
    // Noch keine speziellen Methoden.
}