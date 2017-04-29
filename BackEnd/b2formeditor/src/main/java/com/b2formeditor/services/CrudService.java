package com.b2formeditor.services;

/**
 * Copyright @ Valentin Rosca <rosca.valentin2012@gmail.com>
 */

import java.util.List;

public interface CrudService<T> {
    T save(T entity);
    List<T> getAll();
    T getById(Long id);
    void delete(Long id);
}
