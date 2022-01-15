package com.intervew.toDoList.web;

import com.intervew.toDoList.entities.ToDoList;
import com.intervew.toDoList.services.ToDoListService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
public class StartController {

    @Autowired
    private ToDoListService toDoListService;

    @GetMapping("/")
    public String start(Model model){


        var toDolist = toDoListService.listToDos();

        model.addAttribute("toDoList", toDolist);

        return "index";
    }

    @PostMapping("/add")
    public String add(ToDoList toDoList){

        toDoListService.save(toDoList);

        return "redirect:/";
    }

    @PostMapping("/update")
    public String update(@RequestBody String request){

        Long id = Long.parseLong(request);

        var tdlToChange = toDoListService.findToDoList(id);

        if (tdlToChange!=null){
            System.out.println("tdlToChange = " + tdlToChange + "\n");
            toDoListService.changeCheckState(tdlToChange);
        }

        return "redirect:/";
    }

    @GetMapping("/delete/{id_item}")
    public String delete(ToDoList toDelete){

        if (toDelete!=null){
            toDoListService.delete(toDelete);
        }

        return "redirect:/";
    }
    
    @GetMapping("/edit/{id_item}")
    public String edit(ToDoList toEdit){

        toEdit = toDoListService.findToDoList(toEdit.getId_item());

        System.out.println("toEdit = " + toEdit);
        
        return "edit";
    }

}