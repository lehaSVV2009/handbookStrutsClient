package com.kadet.handbook.client.actions;

import com.kadet.handbook.client.bussinessDelegate.BusinessDelegate;
import com.kadet.handbook.client.form.EditChapterForm;
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
public class EditChapterAction extends Action {

    private BusinessDelegate businessDelegate = BusinessDelegate.getInstance();


    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        request.setCharacterEncoding("UTF-8");
        EditChapterForm editChapterForm = (EditChapterForm) form;
        String idString = editChapterForm.getChapterId();
        if (idString == null) {
            request.setAttribute("chapters", businessDelegate.findAll());
            return mapping.findForward("success");
        }
        String title = editChapterForm.getTitle();
        String text = editChapterForm.getText();
        Integer id = Integer.parseInt(idString);
        Chapter chapter = new Chapter();
        chapter.setId(id);
        chapter.setTitle(title);
        chapter.setText(text);
        businessDelegate.update(chapter);
        request.setAttribute("editSuccess", new Boolean(true));
        request.setAttribute("chapters", businessDelegate.findAll());
        return mapping.findForward("success");
    }


}
