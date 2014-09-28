// SchulhalbjahrServiceImpl.java
//
// Licensed under the AGPL - http://www.gnu.org/licenses/agpl-3.0.txt
// (c) SZE-Development-Team

package net.sf.sze.service.impl.zeugnisconfig;

import javax.annotation.Resource;

import net.sf.sze.dao.api.zeugnisconfig.SchulhalbjahrDao;
import net.sf.sze.model.zeugnisconfig.Schulhalbjahr;
import net.sf.sze.service.api.zeugnisconfig.SchulhalbjahrService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of {@link SchulhalbjahrService}.
 */
@Transactional(readOnly = true)
@Service
public class SchulhalbjahrServiceImpl implements SchulhalbjahrService {


    /** Das Dao für {@link Schulhalbjahr}. */
    @Resource
    private SchulhalbjahrDao schulhalbjahrDao;



    /**
     * {@inheritDoc}
     */
    @Override
    public Page<Schulhalbjahr> getSchulhalbjahr(Pageable page) {
        return schulhalbjahrDao.findAll(page);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = false)
    public Schulhalbjahr save(Schulhalbjahr schulhalbjahr) {
        return schulhalbjahrDao.save(schulhalbjahr);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schulhalbjahr read(Long schulhalbjahrId) {
        return schulhalbjahrDao.findOne(schulhalbjahrId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = false)
    public void delete(Long schulhalbjahrId) {
        final Schulhalbjahr oldSchulhalbjahr = schulhalbjahrDao.findOne(schulhalbjahrId);
        schulhalbjahrDao.delete(oldSchulhalbjahr);
    }
}
