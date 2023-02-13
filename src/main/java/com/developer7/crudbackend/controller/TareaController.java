package com.developer7.crudbackend.controller;

import com.developer7.crudbackend.model.Tarea;
import com.developer7.crudbackend.service.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Param TareaController
 * Clase que nos permite a Angular acceder a la API por HTML
 */

@RestController
/**
 *  @Param origins
 * Le indicamos con *  que podemos conectarnos anuestra API Rest  desde cualquier parte.
 */
@CrossOrigin(origins = "*")
//Indicamos la ruta de acceso
@RequestMapping("/api")
public class TareaController {
    //para insertar dependencias
    @Autowired
    private TareaService tareaService;

    //listar
    @GetMapping("/tareas")
    /**
     * @Param listar
     * Funcion utilizada para listas todos los datos de la tabla Tarea
     */
    public List<Tarea> listar(){
        return tareaService.findAll();
    }

    //Guargar
    @PostMapping("/tareas")
    /**
     * @Param guardar
     * Funcion utilizada para listas todos los datos de la tabla Tarea
     *  con @RequestBody le indicamos a spring Boot que el objeto tipo de tarea es un JSON
     */
    public  Tarea guargar(@RequestBody Tarea tarea){
        return  tareaService.save(tarea);
    }

    //implementado para señalizar un elemento
    @GetMapping("/tareas/{id}")
    /**
     * @Param getUnatarea
     * Funcion utilizada para listar un elemento especifico de la tabla Tarea
     */
    public Tarea getUnatarea(@PathVariable Integer id){
        return tareaService.findById(id);
    }

    //Modificar
    @PutMapping("/tareas/{id}")
    /**
     * @Param modificar
     * Funcion utilizada para modificar un elemento especifico de la tabla Tarea
     */
    public Tarea modificar(@RequestBody Tarea tarea,@PathVariable Integer id){
        //creamos una atarea tipo Tarea, y le pasamos el recuperamos el ID de la BD
        Tarea tareaActual = tareaService.findById(id);
        tareaActual.setTarea(tarea.getTarea());
        tareaActual.setFinalizado(tarea.getFinalizado());
        return tareaService.save(tareaActual);
    }

    //eliminar
    @DeleteMapping("/tareas/{id}")
    public void eliminar(@PathVariable Integer id){
        tareaService.delete(id);

    }


}
