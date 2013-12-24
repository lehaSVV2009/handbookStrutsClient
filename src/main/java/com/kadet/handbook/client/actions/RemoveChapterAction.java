package com.kadet.handbook.client.actions;

import com.kadet.handbook.client.bussinessDelegate.BusinessDelegate;
import com.kadet.handbook.client.form.RemoveChapterForm;
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

    private BusinessDelegate businessDelegate = BusinessDelegate.getInstance();


    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        request.setCharacterEncoding("UTF-8");

        RemoveChapterForm removeChapterForm = (RemoveChapterForm) form;
        String idString = removeChapterForm.getChapterId();
        if (idString == null) {
            request.setAttribute("chapters", businessDelegate.findAll());
            return mapping.findForward("success");
        }
        Integer id = Integer.parseInt(idString);
        boolean success = businessDelegate.delete(id);
        if (success) {
            request.setAttribute("removeSuccess", new Boolean(true));
            request.setAttribute("chapters", businessDelegate.findAll());
        }
        return mapping.findForward("success");
    }

}
