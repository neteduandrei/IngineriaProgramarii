package com.b2formeditor.services;

import com.b2formeditor.models.databasemodels.Response;

import java.util.List;

/**
 * Copyright @ Valentin Rosca <rosca.valentin2012@gmail.com>
 */

public interface ResponseService extends CrudService<Response> {
    void notifyOwner(String formId);

    List<Response> findByCreatedBy(String owner);
}
