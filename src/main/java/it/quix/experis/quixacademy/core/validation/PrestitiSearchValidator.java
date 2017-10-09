package it.quix.experis.quixacademy.core.validation;

import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import it.quix.framework.core.model.UserContext;
import it.quix.framework.core.validation.api.InvalidConstraint;
import it.quix.framework.core.validation.InvalidConstraintImpl;

import it.quix.experis.quixacademy.core.search.PrestitiSearch;

/**
 * Validator for the PrestitiSearch object.
 * Annotation validation is automatically performed.
 * To add custom validation insert code into customValidation method and fill an InvalidConstraint set.
 *
 * @author Quix CodeGenerator version 03.03.00-SNAPSHOT
 */
public class PrestitiSearchValidator extends QuixacademyAbstractValidator<PrestitiSearch> {

    private static Log log = LogFactory.getLog(PrestitiSearchValidator.class);

    /**
     * Perform custom validation on a PrestitiSearch object
     * 
     * @param userContext user context of the logged user
     * @param errors set of invalid constraint to fill with this method, if errors are present
     * @param propertyPath the path of the object in the objectGraph. It uses
     *            .notation like user.address[0]e
     * @param prestitiSearch object to validate
     * @param groups group name(s) targeted for validation (default to <code>[blank]</code> means all the validation will be done)
     */
    @Override
    protected void customValidation(UserContext userContext, Set<InvalidConstraint<?>> errors, String propertyPath, PrestitiSearch prestitiSearch,
        String... groups) {
        if (log.isDebugEnabled()) {
            log.debug("Call customValidation method for class PrestitiSearchValidator ");
        }

        // controllo i range, se non sono nulli, devono essere inseriti in modo corretto: prestitiSearch.getDataPrestitoFrom() PRIMA di
        // prestitiSearch.getDataPrestitoTo()
        if (prestitiSearch.getDataPrestitoFrom() != null && prestitiSearch.getDataPrestitoTo() != null) {
            if (prestitiSearch.getDataPrestitoFrom().after(prestitiSearch.getDataPrestitoTo())) {
                InvalidConstraint<PrestitiSearch> ic1 =
                    new InvalidConstraintImpl<PrestitiSearch>(PrestitiSearch.class, "error.dateToBeforeDateFrom", propertyPath + "dataPrestitoFrom",
                        prestitiSearch, prestitiSearch.getDataPrestitoFrom());
                InvalidConstraint<PrestitiSearch> ic2 =
                    new InvalidConstraintImpl<PrestitiSearch>(PrestitiSearch.class, "error.dateToBeforeDateFrom", propertyPath + "dataPrestitoTo",
                        prestitiSearch, prestitiSearch.getDataPrestitoTo());
                errors.add(ic1);
                errors.add(ic2);
            }
        }
        // controllo i range, se non sono nulli, devono essere inseriti in modo corretto: prestitiSearch.getScadenzaPrestitoFrom() PRIMA di
        // prestitiSearch.getScadenzaPrestitoTo()
        if (prestitiSearch.getScadenzaPrestitoFrom() != null && prestitiSearch.getScadenzaPrestitoTo() != null) {
            if (prestitiSearch.getScadenzaPrestitoFrom().after(prestitiSearch.getScadenzaPrestitoTo())) {
                InvalidConstraint<PrestitiSearch> ic1 =
                    new InvalidConstraintImpl<PrestitiSearch>(PrestitiSearch.class, "error.dateToBeforeDateFrom", propertyPath + "scadenzaPrestitoFrom",
                        prestitiSearch, prestitiSearch.getScadenzaPrestitoFrom());
                InvalidConstraint<PrestitiSearch> ic2 =
                    new InvalidConstraintImpl<PrestitiSearch>(PrestitiSearch.class, "error.dateToBeforeDateFrom", propertyPath + "scadenzaPrestitoTo",
                        prestitiSearch, prestitiSearch.getScadenzaPrestitoTo());
                errors.add(ic1);
                errors.add(ic2);
            }
        }
        // insert here custom validations for PrestitiSearch model
        // after a validation check fail create a new InvalidContraint of the validated type
        // and instantiate an InvalidContraintImpl of the validated type with the error information, es:
        // InvalidConstraint<Type> ic = new InvalidConstraintImpl<Type>(Type.class, message, propertyPath, rootBean, value);
        // where:
        // [message] is the name of a bundle which contains the appropriate error message
        // [propertyPath] is the path from the root bean to the property which generated the error
        // [rootBean] is the root bean being validated
        // [value] is the value of the property which generated the error
        // in the end, add the new invalid constraint to the errors array, es:
        // errors.add(ic);
    }

}