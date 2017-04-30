package com.b2formeditor.services;

/**
 * Copyright @ Valentin Rosca <rosca.valentin2012@gmail.com>
 */

import com.b2formeditor.models.responsemodels.ProcessedForm;

import java.util.List;

public interface FormService extends CrudService<ProcessedForm> {
    List<ProcessedForm> getByUserId(String id);
}
