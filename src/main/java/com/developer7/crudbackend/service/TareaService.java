package com.developer7.crudbackend.service;

import com.developer7.crudbackend.model.Tarea;

import java.util.List;

public interface TareaService {
    public List<Tarea> findAll();
    public Tarea save(Tarea tarea);
    public Tarea findById(Integer id);
    public void delete(Integer id);
}
