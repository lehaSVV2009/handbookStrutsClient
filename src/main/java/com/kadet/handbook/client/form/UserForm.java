package com.kadet.handbook.client.form;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import javax.servlet.http.HttpServletRequest;

/**
 * Date: 10.12.13
 * Time: 2:15
 *
 * @author Кадет
 */
public class UserForm extends ActionForm {

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        if (getUsername() == null || "".equals(getUsername())) {
            errors.add(
                    "common.name.err"
                    , new ActionMessage("error.common.name.required")
            );
        }
        return errors;
    }

    @Override
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        username = "";
    }
}
