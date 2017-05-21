package com.b2formeditor.models.datatransferobjects;

import com.b2formeditor.models.responsemodels.ProcessedForm;
import com.b2formeditor.models.responsemodels.ProcessedQuestion;

/**
 * Created by Dorneanu on 5/9/2017.
 */
public class DownloadedFormDTO extends FormDTO {
    private String id;

    public DownloadedFormDTO(ProcessedForm form) {
        ProcessedQuestion[] questions = form.getFields();

        this.fields = new QuestionDTO[questions.length];
        this.setFormId(form.getId());
        this.setDescription(form.getDescription());
        this.setTitle(form.getTitle());
        this.setFont(form.getFont());

        for (int i = 0; i < questions.length; ++i) {
            this.fields[i] = new QuestionDTO();
            this.fields[i].setValues(questions[i].getValues());
            this.fields[i].setType(questions[i].getType());
            this.fields[i].setTitle(questions[i].getTitle());
            this.fields[i].setRequired(questions[i].getRequired());
            this.fields[i].setOptions(questions[i].getOptions());
            this.fields[i].setDescription(questions[i].getDescription());
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
