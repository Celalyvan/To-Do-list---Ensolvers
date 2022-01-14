package com.intervew.toDoList.dao;

import com.intervew.toDoList.entities.ToDoList;
import org.springframework.data.repository.CrudRepository;

public interface IToDoListDAO extends CrudRepository<ToDoList, Long> {

}
