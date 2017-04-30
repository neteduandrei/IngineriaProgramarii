package com.b2formeditor.models.databasemodels;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Dorneanu Dragos-Andrei on 29.04.2017.
 */
@Document(collection = "Questions")
public class Question {
    @Id
    private Integer id;
    private String type;
    private String[] options;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] option) {
        this.options = option;
    }
}
