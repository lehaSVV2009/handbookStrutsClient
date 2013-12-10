package com.kadet.handbook.client.actions;

import com.kadet.handbook.client.service.RestService;
import com.kadet.handbook.client.service.impl.RestServiceImpl;
import com.kadet.handbook.client.util.DataStrings;
import com.kadet.handbook.client.util.TextValidator;
import com.kadet.handbook.entity.Chapter;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Random;

/**
 * Date: 10.12.13
 * Time: 3:43
 *
 * @author Кадет
 */
public class EditChapterAction extends Action {

    private RestService restService = new RestServiceImpl();

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");
        String idString = request.getParameter("editChapter.id");
        if (idString == null) {
            request.setAttribute("chapters", restService.findAll());
            return mapping.findForward("success");
        }
        String title = request.getParameter("editChapter.title");
        String text = request.getParameter("editChapter.text");
        Long id = Long.parseLong(idString);
        Chapter chapter = new Chapter();
        chapter.setId(id);
        chapter.setTitle(title);
        chapter.setText(text);
        restService.saveOrUpdate(chapter);
        request.setAttribute("editSuccess", new Boolean(true));
        request.setAttribute("chapters", restService.findAll());
        return mapping.findForward("success");
    }


}
