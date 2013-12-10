package com.kadet.handbook.client.actions;

import com.kadet.handbook.client.service.RestService;
import com.kadet.handbook.client.service.impl.RestServiceImpl;
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
 * Time: 3:42
 *
 * @author Кадет
 */
public class AddChapterAction extends Action {

    private RestService restService = new RestServiceImpl();

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");
        String title = request.getParameter("addChapter.title");
        String text = request.getParameter("addChapter.text");
        if (!TextValidator.badText(title)
                && !TextValidator.badText(text)) {
            Chapter chapter = new Chapter(
                    new Random().nextLong(),
                    title,
                    text
            );
            restService.saveOrUpdate(chapter);
            request.setAttribute("addSuccess", new Boolean(true));
        }
        return mapping.findForward("success");
    }

}
