package com.b2formeditor.models.databasemodels;

import com.b2formeditor.models.responsemodels.ProcessedForm;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.Valid;
import java.util.Date;

/**
 * Created by Dorneanu Dragos-Andrei on 29.04.2017.
 */
@Document(collection = "Responses")
public class Response {
    @Id
    private String id;

    private String createdBy;

    private Date createdAt;

    @Valid
    private ProcessedForm form;

    public Response() {

    }

    public Response(ProcessedForm form) {
        this.form = form;
    }

    public String getId() {
        return id;
    }

    public Response setId(String id) {
        this.id = id;
        return this;
    }

    public ProcessedForm getForm() {
        return form;
    }

    public Response setForm(ProcessedForm form) {
        this.form = form;
        return this;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public Response setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Response setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }
}
