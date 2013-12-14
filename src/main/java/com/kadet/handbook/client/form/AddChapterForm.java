package com.kadet.handbook.client.form;

import com.kadet.handbook.client.util.TextValidator;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import javax.servlet.http.HttpServletRequest;

/**
 * Date: 12/14/13
 * Time: 5:50 AM
 *
 * @author SarokaA
 */
public class AddChapterForm extends ActionForm {

    private String title = "";
    private String text = "";

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
