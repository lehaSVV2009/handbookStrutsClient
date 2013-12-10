package com.kadet.handbook.client.actions;

import com.kadet.handbook.client.service.RestService;
import com.kadet.handbook.client.service.impl.RestServiceImpl;
import com.kadet.handbook.client.util.DataStrings;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Date: 10.12.13
 * Time: 3:31
 *
 * @author Кадет
 */
public class GoToRemoveChapterAction extends Action {

    private RestService restService = new RestServiceImpl();

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");
        request.setAttribute("chapters", restService.findAll());
        return mapping.findForward("success");
    }
}
