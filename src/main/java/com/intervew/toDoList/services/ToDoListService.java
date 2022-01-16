package com.intervew.toDoList.services;

import com.intervew.toDoList.dao.IToDoListDAO;
import com.intervew.toDoList.entities.ToDoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ToDoListService implements IToDoListService{

   @Autowired
   private IToDoListDAO iToDoListDAO;

    @Override
    @Transactional(readOnly = true)
    public List<ToDoList> listToDos() {
        return (List<ToDoList>) iToDoListDAO.findAll();
    }

    @Override
    @Transactional
    public void save(ToDoList toDoList) {
        iToDoListDAO.save(toDoList);
    }

    @Override
    @Transactional
    public void delete(ToDoList toDoList) {
        iToDoListDAO.delete(toDoList);
    }



    @Override
    @Transactional(readOnly = true)
    public ToDoListService findPersona(ToDoList toDoList) {
        return null;
    }

    @Override
    @Transactional
    public void changeCheckState(ToDoList toDoList) {
        toDoList.set_checked(!toDoList.is_checked());
        System.out.println("toDoList = " + toDoList);
        iToDoListDAO.save(toDoList);
    }

    @Override
    @Transactional
    public ToDoList findToDoList(Long id_toDoList) {

        var response= iToDoListDAO.findById(id_toDoList).orElse(null);

        return response;
    }
}
