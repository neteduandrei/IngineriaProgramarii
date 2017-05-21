package com.b2formeditor.services;

import com.b2formeditor.models.databasemodels.FormResponse;
import com.b2formeditor.models.datatransferobjects.FormResponseDTO;
import com.b2formeditor.models.responsemodels.ProcessedForm;
import com.b2formeditor.models.responsemodels.ProcessedFormResponse;
import com.b2formeditor.models.responsemodels.ProcessedQuestion;

import java.util.List;

/**
 * Copyright @ Valentin Rosca <rosca.valentin2012@gmail.com>
 */

public interface FormResponseService extends CrudService<ProcessedFormResponse, FormResponseDTO> {
    void notifyOwner(String formId);

    List<ProcessedFormResponse> findByCreatedBy(String owner);
}
