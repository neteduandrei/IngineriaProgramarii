package com.b2formeditor.models.datatransferobjects;

import com.b2formeditor.models.responsemodels.ProcessedForm;

/**
 * Created by Dorneanu on 5/9/2017.
 */
public class DownloadedFormDTO extends FormDTO {
    private String id;

    public DownloadedFormDTO(ProcessedForm form) {
        QuestionDTO[] questions = form.getFields();

        this.fields = new QuestionDTO[questions.length];
        this.setFormId(form.getId())
                .setDescription(form.getDescription())
                .setTitle(form.getTitle())
                .setFont(form.getFont());
        for (int i = 0; i < questions.length; ++i) {
            this.fields[i] = new QuestionDTO();
            this.fields[i].setValue(questions[i].getValue())
                          .setType(questions[i].getType())
                          .setTitle(questions[i].getTitle())
                          .setRequired(questions[i].isRequired())
                          .setOptions(questions[i].getOptions())
                          .setDescription(questions[i].getDescription());
        }
    }

    public String getId() {
        return id;
    }

    public DownloadedFormDTO setFormId(String formId) {
        this.id = formId;
        return this;
    }
}
