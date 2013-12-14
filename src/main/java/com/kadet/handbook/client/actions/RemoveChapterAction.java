package com.kadet.handbook.client.actions;

import com.kadet.handbook.client.service.RestService;
import com.kadet.handbook.client.service.impl.RestServiceImpl;
import com.kadet.handbook.entity.Chapter;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Date: 10.12.13
 * Time: 3:43
 *
 * @author Кадет
 */
public class RemoveChapterAction extends Action {

    private RestService restService = new RestServiceImpl();

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");
        String idString = request.getParameter("removeChapter.id");
        if (idString == null) {
            request.setAttribute("chapters", restService.findAll());
            return mapping.findForward("success");
        }
        Integer id = Integer.parseInt(idString);
        boolean success = restService.delete(id);
        if (success) {
            request.setAttribute("removeSuccess", new Boolean(true));
            request.setAttribute("chapters", restService.findAll());
        }
        return mapping.findForward("success");
    }

}
