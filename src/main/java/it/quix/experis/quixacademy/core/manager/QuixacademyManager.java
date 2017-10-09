package it.quix.experis.quixacademy.core.manager;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import it.quix.framework.core.exception.DAOCreateException;
import it.quix.framework.core.exception.DAODeleteException;
import it.quix.framework.core.exception.DAOFinderException;
import it.quix.framework.core.exception.DAOStoreException;
import it.quix.framework.core.validation.exception.ValidationException;
import it.quix.framework.core.manager.UserContextHolder;
import it.quix.experis.quixacademy.core.model.QuixacademyUserContext;

import it.quix.experis.quixacademy.core.validation.ValidatorFactory;
import it.quix.experis.quixacademy.core.dao.DAOFactory;
import it.quix.experis.quixacademy.core.model.Oggetti;
import it.quix.experis.quixacademy.core.search.OggettiSearch;
import it.quix.experis.quixacademy.core.model.Prestiti;
import it.quix.experis.quixacademy.core.search.PrestitiSearch;
import it.quix.experis.quixacademy.core.model.Soggetti;
import it.quix.experis.quixacademy.core.search.SoggettiSearch;

import it.quix.framework.core.handler.SysAttributeHandler;

/**
 * Interface of the application manager.<br>
 * This class exposes all the application object management APIs.
 * 
 * @author Quix CodeGenerator version 03.03.00-SNAPSHOT
 */
public class QuixacademyManager {

    private static Log log = LogFactory.getLog(QuixacademyManager.class);

    @Resource(name = "daoFactory")
    private DAOFactory daoFactory;

    @Resource(name = "validatorFactory")
    private ValidatorFactory validatorFactory;

    @Resource(name = "sysAttributeHandler")
    private SysAttributeHandler sysAttributeHandler;

    /**
     * Returns the list of Oggetti that satisfy conditions passed in
     * oggettiSearch parameter
     * 
     * @param oggettiSearch search model that contains the filters to use
     * @return returns the list of oggetti that satisfy conditions
     * @see OggettiSearch
     * @see Oggetti
     */
    @Transactional(readOnly = true)
    public List<Oggetti> getOggettiList(OggettiSearch oggettiSearch) {
        List<Oggetti> list = daoFactory.getOggettiDAO().getList(oggettiSearch);
        return list;
    }

    @Transactional(readOnly = true)
    public List<Oggetti> getOggettiListBySoggetti(String proprietario_username) {
        List<Oggetti> list = daoFactory.getOggettiDAO().getOggettiListByProprietario(proprietario_username);
        return list;
    }

    /**
     * Returns the number of Oggetti that satisfy conditions passed in
     * oggettiSearch parameter
     * 
     * @param oggettiSearch search model that contains the filters to use
     * @return the number of Oggetti found
     * @see OggettiSearch
     * @see Oggetti
     */
    @Transactional(readOnly = true)
    public Long countOggetti(OggettiSearch oggettiSearch) {
        return daoFactory.getOggettiDAO().count(oggettiSearch);
    }

    /**
     * retrieve from persistence system the required Oggetti record
     * 
     * @param oggettiId the key to retrieve the oggetti
     * @return the requested Oggetti record
     * @throws QuixacademyException if an unexpected exception occurs or no record
     *             is found
     * @see Oggetti
     */
    @Transactional(readOnly = true, rollbackFor = { QuixacademyException.class })
    public Oggetti getOggetti(Integer id) throws DAOFinderException {
        Oggetti oggetti = null;
        oggetti = daoFactory.getOggettiDAO().get(id);
        return oggetti;
    }

    /**
     * persist the passed Oggetti object to database, previous validation
     * 
     * @param oggetti the object to save
     * @return the persisted object
     * @throws QuixacademyException if an unexpected exception occurs during
     *             operation
     * @throws ValidationException if input data doesn't satisfy validation
     * @see Oggetti
     */
    @Transactional(rollbackFor = { QuixacademyException.class, ValidationException.class })
    public Oggetti saveOggetti(Oggetti oggetti) throws QuixacademyException, ValidationException {
        return saveOggetti(oggetti, true);
    }

    /**
     * persist the passed Oggetti object to database
     * 
     * @param oggetti the object to save
     * @param validate false skip model validation
     * @return the persisted object
     * @throws QuixacademyException if an unexpected exception occurs during
     *             operation
     * @throws ValidationException if input data doesn't satisfy validation
     * @see Oggetti
     */
    @Transactional(rollbackFor = { QuixacademyException.class, ValidationException.class })
    public Oggetti saveOggetti(Oggetti oggetti, boolean validate) throws QuixacademyException, ValidationException {
        if (validate) {
            validateOggetti(oggetti);
        }
        if (oggetti.getId() == null) {
            createOggetti(oggetti, validate);
        } else {
            updateOggetti(oggetti, validate);
        }
        return oggetti;
    }

    /**
     * create the passed Oggetti object to database, previous validation
     * 
     * @param oggetti the object to create
     * @return the created object
     * @throws QuixacademyException if an unexpected exception occurs during
     *             operation
     * @throws ValidationException if input data doesn't satisfy validation
     * @see Oggetti
     */
    @Transactional(rollbackFor = { QuixacademyException.class, ValidationException.class })
    public Oggetti createOggetti(Oggetti oggetti) throws QuixacademyException, ValidationException {
        return createOggetti(oggetti, true);
    }

    /**
     * create the passed Oggetti object to database
     * 
     * @param oggetti the object to create
     * @param validate false skip model validation
     * @return the created object
     * @throws QuixacademyException if an unexpected exception occurs during
     *             operation
     * @throws ValidationException if input data doesn't satisfy validation
     * @see Oggetti
     */
    @Transactional(rollbackFor = { QuixacademyException.class, ValidationException.class })
    public Oggetti createOggetti(Oggetti oggetti, boolean validate) throws QuixacademyException, ValidationException {
        if (validate) {
            validateOggetti(oggetti);
        }
        try {
            daoFactory.getOggettiDAO().create(oggetti);
            return oggetti;
        } catch (DAOCreateException ex) {
            throw new QuixacademyException(ex, oggetti);
        }
    }

    /**
     * update the passed Oggetti object to database, previous validation
     * 
     * @param oggetti the object to update
     * @return the updated object
     * @throws QuixacademyException if an unexpected exception occurs during
     *             operation
     * @throws ValidationException if input data doesn't satisfy validation
     * @see Oggetti
     */
    @Transactional(rollbackFor = { QuixacademyException.class, ValidationException.class })
    public Oggetti updateOggetti(Oggetti oggetti) throws QuixacademyException, ValidationException {
        return updateOggetti(oggetti, true);
    }

    /**
     * update the passed Oggetti object to database
     * 
     * @param oggetti the object to update
     * @param validate false skip model validation
     * @return the updated object
     * @throws QuixacademyException if an unexpected exception occurs during
     *             operation
     * @throws ValidationException if input data doesn't satisfy validation
     * @see Oggetti
     */
    @Transactional(rollbackFor = { QuixacademyException.class, ValidationException.class })
    public Oggetti updateOggetti(Oggetti oggetti, boolean validate) throws QuixacademyException, ValidationException {
        if (validate) {
            validateOggetti(oggetti);
        }
        try {

            daoFactory.getOggettiDAO().update(oggetti);

            return oggetti;
        } catch (DAOStoreException ex) {
            throw new QuixacademyException(ex, oggetti);
        }
    }

    /**
     * delete the Oggetti object from the database
     * 
     * @param oggetti the object to delete
     * @throws QuixacademyException if an unexpected exception occurs during
     *             operation
     * @see Oggetti
     */
    @Transactional(rollbackFor = { QuixacademyException.class })
    public void deleteOggetti(Integer id) throws QuixacademyException {
        try {
            daoFactory.getOggettiDAO().delete(id);
        } catch (DAODeleteException e) {
            throw new QuixacademyException("Error on delete Oggetti", e);
        }
    }

    /**
     * performs the validation of the selected Oggetti
     *
     * @param oggetti the object to be validated
     * @param groups group name(s) targeted for validation (default to <code>[blank]</code> means all the validation will be done)
     * @throws ValidationException if validation error occurs
     * @see Oggetti
     * @see it.quix.experis.quixacademy.core.validation.OggettiValidator
     */
    @Transactional(readOnly = true, rollbackFor = { ValidationException.class })
    public void validateOggetti(Oggetti oggetti, String... groups) throws ValidationException {
        QuixacademyUserContext userContext = (QuixacademyUserContext) UserContextHolder.getUserContext();
        validatorFactory.getOggettiValidator().validate(userContext, oggetti, groups);
    }

    /**
     * performs the validation of the selected search model OggettiSearch
     *
     * @param oggettiSearch the search model to be validated
     * @param groups group name(s) targeted for validation (default to <code>[blank]</code> means all the validation will be done)
     * @throws ValidationException if validation error occurs
     * @see OggettiSearch
     * @see it.quix.experis.quixacademy.core.validation.OggettiValidator
     */
    @Transactional(readOnly = true, rollbackFor = { ValidationException.class })
    public void validateOggettiSearch(OggettiSearch oggettiSearch, String... groups) throws ValidationException {
        QuixacademyUserContext userContext = (QuixacademyUserContext) UserContextHolder.getUserContext();
        validatorFactory.getOggettiSearchValidator().validate(userContext, oggettiSearch, groups);
    }

    /**
     * Returns the list of Prestiti that satisfy conditions passed in
     * prestitiSearch parameter
     * 
     * @param prestitiSearch search model that contains the filters to use
     * @return returns the list of prestiti that satisfy conditions
     * @see PrestitiSearch
     * @see Prestiti
     */
    @Transactional(readOnly = true)
    public List<Prestiti> getPrestitiList(PrestitiSearch prestitiSearch) {
        List<Prestiti> list = daoFactory.getPrestitiDAO().getList(prestitiSearch);
        return list;
    }

    @Transactional(readOnly = true)
    public List<Prestiti> getPrestitiListBySoggetti(String beneficiario_username) {
        List<Prestiti> list = daoFactory.getPrestitiDAO().getPrestitiListByBeneficiario(beneficiario_username);
        return list;
    }

    @Transactional(readOnly = true)
    public List<Prestiti> getPrestitiListByOggetti(Integer oggettoPrestato_id) {
        List<Prestiti> list = daoFactory.getPrestitiDAO().getPrestitiListByOggettoPrestato(oggettoPrestato_id);
        return list;
    }

    /**
     * Returns the number of Prestiti that satisfy conditions passed in
     * prestitiSearch parameter
     * 
     * @param prestitiSearch search model that contains the filters to use
     * @return the number of Prestiti found
     * @see PrestitiSearch
     * @see Prestiti
     */
    @Transactional(readOnly = true)
    public Long countPrestiti(PrestitiSearch prestitiSearch) {
        return daoFactory.getPrestitiDAO().count(prestitiSearch);
    }

    /**
     * retrieve from persistence system the required Prestiti record
     * 
     * @param prestitiId the key to retrieve the prestiti
     * @return the requested Prestiti record
     * @throws QuixacademyException if an unexpected exception occurs or no record
     *             is found
     * @see Prestiti
     */
    @Transactional(readOnly = true, rollbackFor = { QuixacademyException.class })
    public Prestiti getPrestiti(String beneficiario_username, Integer oggettoPrestato_id) throws DAOFinderException {
        Prestiti prestiti = null;
        prestiti = daoFactory.getPrestitiDAO().get(beneficiario_username, oggettoPrestato_id);
        return prestiti;
    }

    /**
     * persist the passed Prestiti object to database, previous validation
     * 
     * @param prestiti the object to save
     * @return the persisted object
     * @throws QuixacademyException if an unexpected exception occurs during
     *             operation
     * @throws ValidationException if input data doesn't satisfy validation
     * @see Prestiti
     */
    @Transactional(rollbackFor = { QuixacademyException.class, ValidationException.class })
    public Prestiti savePrestiti(Prestiti prestiti) throws QuixacademyException, ValidationException {
        return savePrestiti(prestiti, true);
    }

    /**
     * persist the passed Prestiti object to database
     * 
     * @param prestiti the object to save
     * @param validate false skip model validation
     * @return the persisted object
     * @throws QuixacademyException if an unexpected exception occurs during
     *             operation
     * @throws ValidationException if input data doesn't satisfy validation
     * @see Prestiti
     */
    @Transactional(rollbackFor = { QuixacademyException.class, ValidationException.class })
    public Prestiti savePrestiti(Prestiti prestiti, boolean validate) throws QuixacademyException, ValidationException {
        if (validate) {
            validatePrestiti(prestiti);
        }
        if (prestiti.getBeneficiario() == null && prestiti.getOggettoPrestato() == null) {
            createPrestiti(prestiti, validate);
        } else {
            updatePrestiti(prestiti, validate);
        }
        return prestiti;
    }

    /**
     * create the passed Prestiti object to database, previous validation
     * 
     * @param prestiti the object to create
     * @return the created object
     * @throws QuixacademyException if an unexpected exception occurs during
     *             operation
     * @throws ValidationException if input data doesn't satisfy validation
     * @see Prestiti
     */
    @Transactional(rollbackFor = { QuixacademyException.class, ValidationException.class })
    public Prestiti createPrestiti(Prestiti prestiti) throws QuixacademyException, ValidationException {
        return createPrestiti(prestiti, true);
    }

    /**
     * create the passed Prestiti object to database
     * 
     * @param prestiti the object to create
     * @param validate false skip model validation
     * @return the created object
     * @throws QuixacademyException if an unexpected exception occurs during
     *             operation
     * @throws ValidationException if input data doesn't satisfy validation
     * @see Prestiti
     */
    @Transactional(rollbackFor = { QuixacademyException.class, ValidationException.class })
    public Prestiti createPrestiti(Prestiti prestiti, boolean validate) throws QuixacademyException, ValidationException {
        if (validate) {
            validatePrestiti(prestiti);
        }
        try {
            daoFactory.getPrestitiDAO().create(prestiti);
            return prestiti;
        } catch (DAOCreateException ex) {
            throw new QuixacademyException(ex, prestiti);
        }
    }

    /**
     * update the passed Prestiti object to database, previous validation
     * 
     * @param prestiti the object to update
     * @return the updated object
     * @throws QuixacademyException if an unexpected exception occurs during
     *             operation
     * @throws ValidationException if input data doesn't satisfy validation
     * @see Prestiti
     */
    @Transactional(rollbackFor = { QuixacademyException.class, ValidationException.class })
    public Prestiti updatePrestiti(Prestiti prestiti) throws QuixacademyException, ValidationException {
        return updatePrestiti(prestiti, true);
    }

    /**
     * update the passed Prestiti object to database
     * 
     * @param prestiti the object to update
     * @param validate false skip model validation
     * @return the updated object
     * @throws QuixacademyException if an unexpected exception occurs during
     *             operation
     * @throws ValidationException if input data doesn't satisfy validation
     * @see Prestiti
     */
    @Transactional(rollbackFor = { QuixacademyException.class, ValidationException.class })
    public Prestiti updatePrestiti(Prestiti prestiti, boolean validate) throws QuixacademyException, ValidationException {
        if (validate) {
            validatePrestiti(prestiti);
        }
        try {

            daoFactory.getPrestitiDAO().update(prestiti);

            return prestiti;
        } catch (DAOStoreException ex) {
            throw new QuixacademyException(ex, prestiti);
        }
    }

    /**
     * delete the Prestiti object from the database
     * 
     * @param prestiti the object to delete
     * @throws QuixacademyException if an unexpected exception occurs during
     *             operation
     * @see Prestiti
     */
    @Transactional(rollbackFor = { QuixacademyException.class })
    public void deletePrestiti(String beneficiario_username, Integer oggettoPrestato_id) throws QuixacademyException {
        try {
            daoFactory.getPrestitiDAO().delete(beneficiario_username, oggettoPrestato_id);
        } catch (DAODeleteException e) {
            throw new QuixacademyException("Error on delete Prestiti", e);
        }
    }

    /**
     * performs the validation of the selected Prestiti
     *
     * @param prestiti the object to be validated
     * @param groups group name(s) targeted for validation (default to <code>[blank]</code> means all the validation will be done)
     * @throws ValidationException if validation error occurs
     * @see Prestiti
     * @see it.quix.experis.quixacademy.core.validation.PrestitiValidator
     */
    @Transactional(readOnly = true, rollbackFor = { ValidationException.class })
    public void validatePrestiti(Prestiti prestiti, String... groups) throws ValidationException {
        QuixacademyUserContext userContext = (QuixacademyUserContext) UserContextHolder.getUserContext();
        validatorFactory.getPrestitiValidator().validate(userContext, prestiti, groups);
    }

    /**
     * performs the validation of the selected search model PrestitiSearch
     *
     * @param prestitiSearch the search model to be validated
     * @param groups group name(s) targeted for validation (default to <code>[blank]</code> means all the validation will be done)
     * @throws ValidationException if validation error occurs
     * @see PrestitiSearch
     * @see it.quix.experis.quixacademy.core.validation.PrestitiValidator
     */
    @Transactional(readOnly = true, rollbackFor = { ValidationException.class })
    public void validatePrestitiSearch(PrestitiSearch prestitiSearch, String... groups) throws ValidationException {
        QuixacademyUserContext userContext = (QuixacademyUserContext) UserContextHolder.getUserContext();
        validatorFactory.getPrestitiSearchValidator().validate(userContext, prestitiSearch, groups);
    }

    /**
     * Returns the list of Soggetti that satisfy conditions passed in
     * soggettiSearch parameter
     * 
     * @param soggettiSearch search model that contains the filters to use
     * @return returns the list of soggetti that satisfy conditions
     * @see SoggettiSearch
     * @see Soggetti
     */
    @Transactional(readOnly = true)
    public List<Soggetti> getSoggettiList(SoggettiSearch soggettiSearch) {
        List<Soggetti> list = daoFactory.getSoggettiDAO().getList(soggettiSearch);
        return list;
    }

    /**
     * Returns the number of Soggetti that satisfy conditions passed in
     * soggettiSearch parameter
     * 
     * @param soggettiSearch search model that contains the filters to use
     * @return the number of Soggetti found
     * @see SoggettiSearch
     * @see Soggetti
     */
    @Transactional(readOnly = true)
    public Long countSoggetti(SoggettiSearch soggettiSearch) {
        return daoFactory.getSoggettiDAO().count(soggettiSearch);
    }

    /**
     * retrieve from persistence system the required Soggetti record
     * 
     * @param soggettiId the key to retrieve the soggetti
     * @return the requested Soggetti record
     * @throws QuixacademyException if an unexpected exception occurs or no record
     *             is found
     * @see Soggetti
     */
    @Transactional(readOnly = true, rollbackFor = { QuixacademyException.class })
    public Soggetti getSoggetti(String username) throws DAOFinderException {
        Soggetti soggetti = null;
        soggetti = daoFactory.getSoggettiDAO().get(username);
        return soggetti;
    }

    /**
     * persist the passed Soggetti object to database, previous validation
     * 
     * @param soggetti the object to save
     * @return the persisted object
     * @throws QuixacademyException if an unexpected exception occurs during
     *             operation
     * @throws ValidationException if input data doesn't satisfy validation
     * @see Soggetti
     */
    @Transactional(rollbackFor = { QuixacademyException.class, ValidationException.class })
    public Soggetti saveSoggetti(Soggetti soggetti) throws QuixacademyException, ValidationException {
        return saveSoggetti(soggetti, true);
    }

    /**
     * persist the passed Soggetti object to database
     * 
     * @param soggetti the object to save
     * @param validate false skip model validation
     * @return the persisted object
     * @throws QuixacademyException if an unexpected exception occurs during
     *             operation
     * @throws ValidationException if input data doesn't satisfy validation
     * @see Soggetti
     */
    @Transactional(rollbackFor = { QuixacademyException.class, ValidationException.class })
    public Soggetti saveSoggetti(Soggetti soggetti, boolean validate) throws QuixacademyException, ValidationException {
        if (validate) {
            validateSoggetti(soggetti);
        }
        if (soggetti.getUsername() == null) {
            createSoggetti(soggetti, validate);
        } else {
            updateSoggetti(soggetti, validate);
        }
        return soggetti;
    }

    /**
     * create the passed Soggetti object to database, previous validation
     * 
     * @param soggetti the object to create
     * @return the created object
     * @throws QuixacademyException if an unexpected exception occurs during
     *             operation
     * @throws ValidationException if input data doesn't satisfy validation
     * @see Soggetti
     */
    @Transactional(rollbackFor = { QuixacademyException.class, ValidationException.class })
    public Soggetti createSoggetti(Soggetti soggetti) throws QuixacademyException, ValidationException {
        return createSoggetti(soggetti, true);
    }

    /**
     * create the passed Soggetti object to database
     * 
     * @param soggetti the object to create
     * @param validate false skip model validation
     * @return the created object
     * @throws QuixacademyException if an unexpected exception occurs during
     *             operation
     * @throws ValidationException if input data doesn't satisfy validation
     * @see Soggetti
     */
    @Transactional(rollbackFor = { QuixacademyException.class, ValidationException.class })
    public Soggetti createSoggetti(Soggetti soggetti, boolean validate) throws QuixacademyException, ValidationException {
        if (validate) {
            validateSoggetti(soggetti);
        }
        try {
            daoFactory.getSoggettiDAO().create(soggetti);
            return soggetti;
        } catch (DAOCreateException ex) {
            throw new QuixacademyException(ex, soggetti);
        }
    }

    /**
     * update the passed Soggetti object to database, previous validation
     * 
     * @param soggetti the object to update
     * @return the updated object
     * @throws QuixacademyException if an unexpected exception occurs during
     *             operation
     * @throws ValidationException if input data doesn't satisfy validation
     * @see Soggetti
     */
    @Transactional(rollbackFor = { QuixacademyException.class, ValidationException.class })
    public Soggetti updateSoggetti(Soggetti soggetti) throws QuixacademyException, ValidationException {
        return updateSoggetti(soggetti, true);
    }

    /**
     * update the passed Soggetti object to database
     * 
     * @param soggetti the object to update
     * @param validate false skip model validation
     * @return the updated object
     * @throws QuixacademyException if an unexpected exception occurs during
     *             operation
     * @throws ValidationException if input data doesn't satisfy validation
     * @see Soggetti
     */
    @Transactional(rollbackFor = { QuixacademyException.class, ValidationException.class })
    public Soggetti updateSoggetti(Soggetti soggetti, boolean validate) throws QuixacademyException, ValidationException {
        if (validate) {
            validateSoggetti(soggetti);
        }
        try {

            daoFactory.getSoggettiDAO().update(soggetti);

            return soggetti;
        } catch (DAOStoreException ex) {
            throw new QuixacademyException(ex, soggetti);
        }
    }

    /**
     * delete the Soggetti object from the database
     * 
     * @param soggetti the object to delete
     * @throws QuixacademyException if an unexpected exception occurs during
     *             operation
     * @see Soggetti
     */
    @Transactional(rollbackFor = { QuixacademyException.class })
    public void deleteSoggetti(String username) throws QuixacademyException {
        try {
            daoFactory.getSoggettiDAO().delete(username);
        } catch (DAODeleteException e) {
            throw new QuixacademyException("Error on delete Soggetti", e);
        }
    }

    /**
     * performs the validation of the selected Soggetti
     *
     * @param soggetti the object to be validated
     * @param groups group name(s) targeted for validation (default to <code>[blank]</code> means all the validation will be done)
     * @throws ValidationException if validation error occurs
     * @see Soggetti
     * @see it.quix.experis.quixacademy.core.validation.SoggettiValidator
     */
    @Transactional(readOnly = true, rollbackFor = { ValidationException.class })
    public void validateSoggetti(Soggetti soggetti, String... groups) throws ValidationException {
        QuixacademyUserContext userContext = (QuixacademyUserContext) UserContextHolder.getUserContext();
        validatorFactory.getSoggettiValidator().validate(userContext, soggetti, groups);
    }

    /**
     * performs the validation of the selected search model SoggettiSearch
     *
     * @param soggettiSearch the search model to be validated
     * @param groups group name(s) targeted for validation (default to <code>[blank]</code> means all the validation will be done)
     * @throws ValidationException if validation error occurs
     * @see SoggettiSearch
     * @see it.quix.experis.quixacademy.core.validation.SoggettiValidator
     */
    @Transactional(readOnly = true, rollbackFor = { ValidationException.class })
    public void validateSoggettiSearch(SoggettiSearch soggettiSearch, String... groups) throws ValidationException {
        QuixacademyUserContext userContext = (QuixacademyUserContext) UserContextHolder.getUserContext();
        validatorFactory.getSoggettiSearchValidator().validate(userContext, soggettiSearch, groups);
    }

    public DAOFactory getDaoFactory() {
        return daoFactory;
    }

    public void setDaoFactory(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    public ValidatorFactory getValidatorFactory() {
        return validatorFactory;
    }

    public void setValidatorFactory(ValidatorFactory validatorFactory) {
        this.validatorFactory = validatorFactory;
    }

    public void setSysAttributeHandler(SysAttributeHandler sysAttributeHandler) {
        this.sysAttributeHandler = sysAttributeHandler;
    }

    public SysAttributeHandler getSysAttributeHandler() {
        return sysAttributeHandler;
    }

}