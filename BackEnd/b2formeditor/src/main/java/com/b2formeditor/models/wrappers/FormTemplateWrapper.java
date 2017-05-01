package com.b2formeditor.models.wrappers;

import com.b2formeditor.models.responsemodels.ProcessedForm;

/**
 * Created by Dorneanu Dragos-Andrei on 01.05.2017.
 */
public class FormTemplateWrapper {
    private String owner;
    private ProcessedForm form;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public ProcessedForm getForm() {
        return form;
    }

    public void setForm(ProcessedForm form) {
        this.form = form;
    }
}
