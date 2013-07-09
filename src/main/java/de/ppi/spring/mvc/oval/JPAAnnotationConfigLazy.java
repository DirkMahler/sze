package de.ppi.spring.mvc.oval;

import java.lang.reflect.AccessibleObject;
import java.util.Collection;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import net.sf.oval.Check;
import net.sf.oval.configuration.annotation.JPAAnnotationsConfigurer;
import net.sf.oval.constraint.AssertValidCheck;
import net.sf.oval.constraint.NotNullCheck;
import net.sf.oval.integration.spring.BeanInjectingCheckInitializationListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.ppi.oval.validation.UniqueCheck;

/**
 * OVal configurer that interprets certain EJB3 JPA annotations.
 * <ul>
 * <li>javax.persistence.Basic(optional=false) =>
 * net.sf.oval.constraint.NotNullCheck
 * <li>javax.persistence.OneToOne(optional=false) =>
 * net.sf.oval.constraint.NotNullCheck, net.sf.oval.constraint.AssertValidCheck
 * <li>javax.persistence.ManyToOne(optional=false, fetch=FetchType.EAGER) =>
 * net.sf.oval.constraint.NotNullCheck, net.sf.oval.constraint.AssertValidCheck
 * <li>javax.persistence.ManyToMany(fetch=FetchType.EAGER) =>
 * net.sf.oval.constraint.AssertValidCheck
 * <li>javax.persistence.Column(nullable=false) =>
 * net.sf.oval.constraint.NotNullCheck
 * <li>javax.persistence.Column(length=5) => net.sf.oval.constraint.LengthCheck
 * <li>javax.persistence.Column(unique=true) =>
 * de.ppi.oval.validation.UniqueCheck
 * </ul>
 * 
 * @see JPAAnnotationsConfigurer
 */
public class JPAAnnotationConfigLazy extends JPAAnnotationsConfigurer {

    /**
     * The Logger for the controller.
     */
    private static final Logger LOG = LoggerFactory
            .getLogger(JPAAnnotationConfigLazy.class);

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initializeChecks(ManyToMany annotation,
            Collection<Check> checks) {
        if (annotation.fetch() == FetchType.EAGER) {
            checks.add(new AssertValidCheck());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initializeChecks(ManyToOne annotation,
            Collection<Check> checks) {
        if (!annotation.optional()) {
            checks.add(new NotNullCheck());
        }
        if (annotation.fetch() == FetchType.EAGER) {
            checks.add(new AssertValidCheck());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initializeChecks(OneToMany annotation,
            Collection<Check> checks) {
        if (annotation.fetch() == FetchType.EAGER) {
            checks.add(new AssertValidCheck());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initializeChecks(OneToOne annotation,
            Collection<Check> checks) {
        if (!annotation.optional()) {
            checks.add(new NotNullCheck());
        }
        if (annotation.fetch() == FetchType.EAGER) {
            checks.add(new AssertValidCheck());
        }
    }

    @Override
    protected void initializeChecks(Column annotation,
            Collection<Check> checks, AccessibleObject fieldOrMethod) {
        if (annotation.unique()
                && !(fieldOrMethod.isAnnotationPresent(Id.class) || fieldOrMethod
                        .isAnnotationPresent(Generated.class))) {
            boolean hasUniqueCheck = false;
            for (Check check : checks) {
                if (check instanceof UniqueCheck) {
                    hasUniqueCheck = true;
                    break;
                }
            }
            if (!hasUniqueCheck) {
                Check uniqueCheck = new UniqueCheck();
                BeanInjectingCheckInitializationListener.INSTANCE
                        .onCheckInitialized(uniqueCheck);
                checks.add(uniqueCheck);
                LOG.info("Adding a uniqueCheck to field >{}<!", fieldOrMethod);
            }
        }
        super.initializeChecks(annotation, checks, fieldOrMethod);
    }
}
