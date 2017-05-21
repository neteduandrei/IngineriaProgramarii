package com.b2formeditor.services;

/**
 * Copyright @ Valentin Rosca <rosca.valentin2012@gmail.com>
 */


import java.util.List;

public interface CrudService<T,P> {
    T save(P entity);

    List<T> getAll();

    T getById(String id);

    void delete(String id);
}
