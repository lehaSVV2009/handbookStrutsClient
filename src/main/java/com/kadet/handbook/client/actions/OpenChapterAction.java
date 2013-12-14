package com.kadet.handbook.client.actions;

import com.kadet.handbook.client.form.OpenChapterForm;
import com.kadet.handbook.client.service.RestService;
import com.kadet.handbook.client.service.impl.RestServiceImpl;
import com.kadet.handbook.client.util.Messages;
import com.kadet.handbook.entity.Chapter;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Date: 10.12.13
 * Time: 2:39
 *
 * @author Кадет
 */
public class OpenChapterAction extends Action {

    private RestService restService = new RestServiceImpl();

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        OpenChapterForm openChapterForm = (OpenChapterForm) form;
        request.setCharacterEncoding("UTF-8");
        Chapter chapter;
        try {

            String chapterIdString = openChapterForm.getChapterId();
//            String chapterIdString = request.getParameter("chapterId");
            if (chapterIdString == null) {
                chapter = createStandardChapter();
            } else {
                Integer chapterId = Integer.parseInt(chapterIdString);
                chapter = restService.findById(chapterId);
                if (chapter == null) {
                    chapter = createStandardChapter();
                }
            }
        } catch (NumberFormatException nfe) {
            chapter = createStandardChapter();
        }
        request.setAttribute("title", chapter.getTitle());
        request.setAttribute("text", chapter.getText());
        request.setAttribute("chapters", restService.findAll());
        return mapping.findForward("success");
    }


    private Chapter createStandardChapter() {
        Chapter chapter = new Chapter();
        chapter.setTitle(Messages.STANDARD_TITLE);
        chapter.setText(Messages.STANDARD_TEXT);
        return chapter;
    }

}
