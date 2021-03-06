// BemerkungsBausteinServiceImpl.java
//
// Licensed under the AGPL - http://www.gnu.org/licenses/agpl-3.0.txt
// (c) SZE-Development-Team

package net.sf.sze.service.impl.zeugnisconfig;

import javax.annotation.Resource;

import net.sf.sze.dao.api.zeugnisconfig.BemerkungsBausteinDao;
import net.sf.sze.model.zeugnisconfig.BemerkungsBaustein;
import net.sf.sze.service.api.zeugnisconfig.BemerkungsBausteinService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of {@link BemerkungsBausteinService}.
 */
@Transactional(readOnly = true)
@Service
public class BemerkungsBausteinServiceImpl implements BemerkungsBausteinService {


    /** Das Dao für {@link BemerkungsBaustein}. */
    @Resource
    private BemerkungsBausteinDao bemerkungsBausteinDao;



    /**
     * {@inheritDoc}
     */
    @Override
    public Page<BemerkungsBaustein> getBemerkungsBaustein(Pageable page) {
        return bemerkungsBausteinDao.findAll(page);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = false)
    public BemerkungsBaustein save(BemerkungsBaustein bemerkungsBaustein) {
        return bemerkungsBausteinDao.save(bemerkungsBaustein);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BemerkungsBaustein read(Long bemerkungsBausteinId) {
        return bemerkungsBausteinDao.findOne(bemerkungsBausteinId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = false)
    public void delete(Long bemerkungsBausteinId) {
        final BemerkungsBaustein oldBemerkungsBaustein = bemerkungsBausteinDao.
                findOne(bemerkungsBausteinId);
        bemerkungsBausteinDao.delete(oldBemerkungsBaustein);
    }
}
