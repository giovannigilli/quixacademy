package it.quix.experis.quixacademy.core.validation;

import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import it.quix.framework.core.model.UserContext;
import it.quix.framework.core.validation.api.InvalidConstraint;
import it.quix.framework.core.validation.InvalidConstraintImpl;

import it.quix.experis.quixacademy.core.search.OggettiSearch;

/**
 * Validator for the OggettiSearch object.
 * Annotation validation is automatically performed.
 * To add custom validation insert code into customValidation method and fill an InvalidConstraint set.
 *
 * @author Quix CodeGenerator version 03.03.00-SNAPSHOT
 */
public class OggettiSearchValidator extends QuixacademyAbstractValidator<OggettiSearch> {

    private static Log log = LogFactory.getLog(OggettiSearchValidator.class);

    /**
     * Perform custom validation on a OggettiSearch object
     * 
     * @param userContext user context of the logged user
     * @param errors set of invalid constraint to fill with this method, if errors are present
     * @param propertyPath the path of the object in the objectGraph. It uses
     *            .notation like user.address[0]e
     * @param oggettiSearch object to validate
     * @param groups group name(s) targeted for validation (default to <code>[blank]</code> means all the validation will be done)
     */
    @Override
    protected void customValidation(UserContext userContext, Set<InvalidConstraint<?>> errors, String propertyPath, OggettiSearch oggettiSearch,
        String... groups) {
        if (log.isDebugEnabled()) {
            log.debug("Call customValidation method for class OggettiSearchValidator ");
        }

        // controllo i range, se non sono nulli, devono essere inseriti in modo corretto: oggettiSearch.getDataUltimaModificaFrom() PRIMA di
        // oggettiSearch.getDataUltimaModificaTo()
        if (oggettiSearch.getDataUltimaModificaFrom() != null && oggettiSearch.getDataUltimaModificaTo() != null) {
            if (oggettiSearch.getDataUltimaModificaFrom().after(oggettiSearch.getDataUltimaModificaTo())) {
                InvalidConstraint<OggettiSearch> ic1 =
                    new InvalidConstraintImpl<OggettiSearch>(OggettiSearch.class, "error.dateToBeforeDateFrom", propertyPath + "dataUltimaModificaFrom",
                        oggettiSearch, oggettiSearch.getDataUltimaModificaFrom());
                InvalidConstraint<OggettiSearch> ic2 =
                    new InvalidConstraintImpl<OggettiSearch>(OggettiSearch.class, "error.dateToBeforeDateFrom", propertyPath + "dataUltimaModificaTo",
                        oggettiSearch, oggettiSearch.getDataUltimaModificaTo());
                errors.add(ic1);
                errors.add(ic2);
            }
        }
        // insert here custom validations for OggettiSearch model
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