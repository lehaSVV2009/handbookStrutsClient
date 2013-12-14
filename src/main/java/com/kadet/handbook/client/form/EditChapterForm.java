package com.kadet.handbook.client.form;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Date: 12/14/13
 * Time: 5:32 AM
 *
 * @author SarokaA
 */
public class EditChapterForm extends ActionForm {

    private String chapterId;
    private String title = "";
    private String text = "";

    public String getChapterId() {
        return chapterId;
    }

    public void setChapterId(String chapterId) {
        this.chapterId = chapterId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        text = "";
    }
}
