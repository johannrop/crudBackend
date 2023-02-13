package com.developer7.crudbackend.Dao;

import com.developer7.crudbackend.model.Tarea;
import org.springframework.data.repository.CrudRepository;

/**
 * @Param TareaDao
 * Implementado para utilizar las funciones CRUD de Spring BOOT tipo de dato TAREA y Integer por que es el tipo de dato del ID de la tabla Tarea
 */
public interface TareaDao extends CrudRepository<Tarea, Integer> {

}
