package com.b2formeditor.services;

import com.b2formeditor.models.databasemodels.Form;
import com.b2formeditor.models.databasemodels.Question;

/**
 * Created by Dorneanu Dragos-Andrei on 29.04.2017.
 */
public interface QuestionService extends CrudService<Question> {
    Question getOneByField (String field);
}
