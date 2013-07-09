package de.ppi.oval.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import net.sf.oval.configuration.annotation.Constraint;

/**
 * Checks that a field or or field in a context is unique. You set the context
 * as a list (comma, semicolon or space separated) of properties of your model.
 * 
 * Message
 * <ul>
 * <li>key: validation.unique</li>
 * <li>{context}: field name</li>
 * <li>{uk-context}: properties which define a context in which the column must
 * be unique</li>
 * </ul>
 * 
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Constraint(checkWith = UniqueCheck.class)
public @interface Unique {
    /**
     * The context of the unqiue-key.
     * 
     */
    String value() default "";

    /**
     * The message, default "validation.unique".
     * 
     */
    String message() default UniqueCheck.MESSAGE;

    /**
     * The primary-key column, normally "id".
     */
    String primaryKeyColumn() default "id";
}
