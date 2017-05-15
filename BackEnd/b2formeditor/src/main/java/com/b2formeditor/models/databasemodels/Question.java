package com.b2formeditor.models.databasemodels;

import com.b2formeditor.models.datatransferobjects.QuestionDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


/**
 * Created by Dorneanu Dragos-Andrei on 29.04.2017.
 */
@Document(collection = "Questions")
public class Question extends QuestionDTO {
    @Id
    private String id;

    public Question() {
    }

    public Question(QuestionDTO questionDTO) {
        this.description = questionDTO.getDescription();
        this.options = questionDTO.getOptions();
        this.required = questionDTO.getRequired();
        this.title = questionDTO.getTitle();
        this.type = questionDTO.getType();
        this.value = questionDTO.getValue();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
