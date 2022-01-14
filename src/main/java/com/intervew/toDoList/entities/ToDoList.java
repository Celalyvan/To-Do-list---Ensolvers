package com.intervew.toDoList.entities;

import lombok.Data;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
@Table(name="todoitems")
public class ToDoList {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_item;

    @NotEmpty
    private String description;

    private boolean is_checked;

}
