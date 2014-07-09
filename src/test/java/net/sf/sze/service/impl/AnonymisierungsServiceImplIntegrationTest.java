//AnonymisierungsServiceImplTest.java
//
// Licensed under the AGPL - http://www.gnu.org/licenses/agpl-3.0.txt
// (c) SZE-Development Team
package net.sf.sze.service.impl;

import javax.annotation.Resource;

import net.sf.sze.dbunit.AbstractSzeDbUnitTest;
import net.sf.sze.dbunit.dataset.Anonymisierung;
import net.sf.sze.service.api.AnonymisierungsService;

import org.dbunit.dataset.IDataSet;
import org.junit.Test;


/**
 * Testet die Klasse {@link AnonymisierungsServiceImpl}.
 *
 */
public class AnonymisierungsServiceImplIntegrationTest extends AbstractSzeDbUnitTest {


    @Resource
    private AnonymisierungsService anonymisierungsService;


    /**
     * Test method for
     * {@link net.sf.sze.service.impl.AnonymisierungsServiceImpl#replaceAllNamesWithVariables()}.
     * @throws Exception wenn was schief geht.
     */
    @Test
    public void testReplaceAllNamesWithVariables() throws Exception {
        super.generateRowBuilder();
        final IDataSet startDataSet = Anonymisierung.buildVariableInit();
        cleanlyInsert(startDataSet);

        anonymisierungsService.replaceAllNamesWithVariables();

        checkResult(Anonymisierung.buildVariableResult(startDataSet));

    }

    /**
     * Test method for
     * {@link net.sf.sze.service.impl.AnonymisierungsServiceImpl#anonymisierSchueler()}.
     * @throws Exception wenn was schief geht.
     */
    @Test
    public void testAnonymisierSchueler() throws Exception {
        cleanlyInsert(Anonymisierung.buildSchuelerInit());

        anonymisierungsService.anonymisierSchueler();

        checkResult(Anonymisierung.buildSchuelerResult());
    }

}
