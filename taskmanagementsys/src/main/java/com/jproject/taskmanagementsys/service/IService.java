package com.jproject.taskmanagementsys.service;

import java.util.List;

public interface IService<T> {
	
    public T create(T t);
    public List<T> getAll();
    public T getById(Long id);
    public T update(Long id, T updatedType);
    public String delete(Long id);


}
