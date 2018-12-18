package com.kirylshreyter.smart_dictionary.services;

import java.util.List;

public interface AbstractService<T> {

    public T create(T t);

    public T read(long id);

    public List<T> readAll();

    public void delete(T t);

    public List<T> saveAll(Iterable<T> entities);

    void deleteAll(Iterable<T> entities);

}
