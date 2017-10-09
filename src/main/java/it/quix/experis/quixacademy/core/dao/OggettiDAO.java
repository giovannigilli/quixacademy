package it.quix.experis.quixacademy.core.dao;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import it.quix.experis.quixacademy.core.dao.generated.OggettiAbstractDAO;

/**
 * The DAO for Oggetti entity.
 * 
 * @author Quix CodeGenerator version 03.03.00-SNAPSHOT, generated 06/10/2017 17:48:25
 */
public class OggettiDAO extends OggettiAbstractDAO {

    private static Log log = LogFactory.getLog(OggettiDAO.class);

    public OggettiDAO(DataSource dataSource) {
        super(dataSource);
        if (log.isDebugEnabled()) {
            log.debug("OggettiDAO initialized!");
        }
    }

}