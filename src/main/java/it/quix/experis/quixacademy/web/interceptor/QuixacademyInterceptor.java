package it.quix.experis.quixacademy.web.interceptor;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.StrutsStatics;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import it.quix.framework.core.handler.SysAttributeHandler;
import it.quix.framework.core.manager.ManagerHolder;
import it.quix.experis.quixacademy.core.manager.QuixacademyManager;

/**
 *
 * @author Quix CodeGenerator version 03.03.00-SNAPSHOT
 */
public class QuixacademyInterceptor extends AbstractInterceptor {

    /**
     * Serial Version UID
     */
    private static final long serialVersionUID = 1L;

    /**
     * QuixacademyManager
     */
    private QuixacademyManager quixacademyManager;

    /**
     * SysAttributeHandler
     */
    private SysAttributeHandler sysAttributeHandler;

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        HttpServletRequest request = (HttpServletRequest) invocation.getInvocationContext().get(StrutsStatics.HTTP_REQUEST);

        WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getSession().getServletContext());
        quixacademyManager = (QuixacademyManager) wac.getBean("quixacademyManager");
        sysAttributeHandler = (SysAttributeHandler) wac.getBean("sysAttributeHandler");

        ManagerHolder.setManagerOnThreadLocal("quixacademyManager", quixacademyManager);
        ManagerHolder.setManagerOnThreadLocal("sysAttributeHandler", sysAttributeHandler);

        return invocation.invoke();
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

    /**
     * @see #sysAttributeHandler
     * @return the sysAttributeHandler
     */
    public SysAttributeHandler getSysAttributeHandler() {
        return sysAttributeHandler;
    }

    /**
     * @see #sysAttributeHandler
     * @param sysAttributeHandler the sysAttributeHandler to set
     */
    public void setSysAttributeHandler(SysAttributeHandler sysAttributeHandler) {
        this.sysAttributeHandler = sysAttributeHandler;
    }
}