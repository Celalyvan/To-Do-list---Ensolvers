package com.intervew.toDoList.services;

import com.intervew.toDoList.entities.ToDoList;

import java.util.List;

public interface IToDoListService{

    public List<ToDoList> listToDos();

    public void save(ToDoList toDoList);

    public void delete(ToDoList toDoList);

    public ToDoListService findPersona(ToDoList toDoList);

    public void changeCheckState(ToDoList toDoList);

    public ToDoList findToDoList(Long id_toDoList);

}
