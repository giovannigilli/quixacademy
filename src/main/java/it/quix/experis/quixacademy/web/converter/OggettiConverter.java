package it.quix.experis.quixacademy.web.converter;

import java.util.Map;
import java.lang.Exception;
import java.math.BigInteger;
import java.util.Date;

import javax.annotation.Resource;
import it.quix.experis.quixacademy.core.manager.QuixacademyManager;
import it.quix.experis.quixacademy.core.model.Oggetti;
import it.quix.experis.quixacademy.core.model.QuixacademyUserContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.conversion.TypeConversionException;
import com.opensymphony.xwork2.util.ValueStack;
import it.quix.framework.web.converter.AbstractTypeConverter;

import org.apache.struts2.util.StrutsTypeConverter;

/**
 * Converter class for the Oggetti model.
 * 
 * @author Quix CodeGenerator version 03.03.00-SNAPSHOT
 */
public class OggettiConverter extends AbstractTypeConverter<java.lang.Integer> {

    /**
     * QuixacademyManager injected by Spring
     */
    @Resource(name = "quixacademyManager")
    private QuixacademyManager quixacademyManager;

    @SuppressWarnings("unchecked")
    @Override
    public Object convertFromString(Map context, String[] arg1, Class arg2) {
        try {
            if (arg1 == null || arg1.length == 0 || arg1[0] == null || arg1[0].equals(""))
                return null;
            if (!arg2.equals(Oggetti.class))
                throw new TypeConversionException();
            ValueStack stack = ActionContext.getContext().getValueStack();
            // QuixacademyUserContext uc = (QuixacademyUserContext) stack.findValue("userContext");

            String[] pks = arg1[0].split("[|]");
            Integer id = (java.lang.Integer) convertFromString(pks[0], Integer.class);
            Oggetti oggetti = getQuixacademyManager().getOggetti(id);

            if (oggetti == null) {
                throw new TypeConversionException("Error on OggettiConverter. Oggetti with key (id serialized) " + arg1[0] + " not found.");
            }
            return oggetti;
        } catch (Exception e) {
            throw new TypeConversionException("Error on OggettiConverter.", e);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public String convertToString(Map context, Object obj) {
        Oggetti oggetti = (Oggetti) obj;
        try {
            StringBuilder pk = new StringBuilder();
            pk.append(convertToString(oggetti.getId()));
            return pk.toString();
        } catch (Exception e) {
            throw new TypeConversionException(e);
        }
    }

    /**
     * @see #quixacademyManager
     * @return the quixacademyManager
     */
    public QuixacademyManager getQuixacademyManager() {
        return quixacademyManager;
    }

    /**
     * @see #quixacademyManager
     * @param quixacademyManager the quixacademyManager to set
     */
    public void setQuixacademyManager(QuixacademyManager quixacademyManager) {
        this.quixacademyManager = quixacademyManager;
    }

}
