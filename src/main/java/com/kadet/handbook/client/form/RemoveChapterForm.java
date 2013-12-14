package com.kadet.handbook.client.form;

import org.apache.struts.action.ActionForm;

/**
 * Date: 12/14/13
 * Time: 5:32 AM
 *
 * @author SarokaA
 */
public class RemoveChapterForm extends ActionForm {

    private String chapterId;

    public String getChapterId() {
        return chapterId;
    }

    public void setChapterId(String chapterId) {
        this.chapterId = chapterId;
    }

}
