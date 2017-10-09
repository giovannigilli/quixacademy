package it.quix.experis.quixacademy.core.model;

import java.io.Serializable;

import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlTransient;

import flexjson.JSON;

import it.quix.experis.quixacademy.core.manager.QuixacademyManager;
import it.quix.framework.core.handler.SysAttributeHandler;
import it.quix.framework.core.manager.ManagerHolder;

import it.quix.framework.core.model.AbstractModel;

public class QuixacademyAbstractModel extends AbstractModel implements Serializable {

    /**
	 *
	 */
    private static final long serialVersionUID = 1764636486333100576L;

    @Transient
    protected boolean jdbc = false;

    @Transient
    private transient QuixacademyManager quixacademyManager;

    @Transient
    private transient SysAttributeHandler sysAttributeHandler;

    protected static String stringSeparator = "|";

    public QuixacademyAbstractModel() {
        super();
        this.jdbc = true;
    }

    public QuixacademyAbstractModel(QuixacademyManager quixacademyManager) {
        super();
        this.jdbc = true;
        this.quixacademyManager = quixacademyManager;
    }

    public QuixacademyAbstractModel(boolean jdbc, QuixacademyManager quixacademyManager) {
        super();
        this.jdbc = jdbc;
        this.quixacademyManager = quixacademyManager;
    }

    @JSON(include = false)
    @XmlTransient
    public boolean isJdbc() {
        return jdbc;
    }

    public void setJdbc(boolean jdbc) {
        this.jdbc = jdbc;
    }

    @JSON(include = false)
    @XmlTransient
    public QuixacademyManager getQuixacademyManager() {
        if (quixacademyManager != null) {
            return quixacademyManager;
        }
        return (QuixacademyManager) ManagerHolder.getManagerOnThreadLocal("quixacademyManager");
    }

    public void setQuixacademyManager(QuixacademyManager quixacademyManager) {
        this.quixacademyManager = quixacademyManager;
    }

    @JSON(include = false)
    @XmlTransient
    public SysAttributeHandler getSysAttributeHandler() {
        if (sysAttributeHandler != null) {
            return sysAttributeHandler;
        }
        return (SysAttributeHandler) ManagerHolder.getManagerOnThreadLocal("sysAttributeHandler");
    }

    public void setSysAttributeHandler(SysAttributeHandler sysAttributeHandler) {
        this.sysAttributeHandler = sysAttributeHandler;
    }

}