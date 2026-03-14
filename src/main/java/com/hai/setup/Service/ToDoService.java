package com.hai.setup.Service;

import com.hai.setup.Entity.ToDo;
import com.hai.setup.Repository.ToDoRepository;

import java.util.List;

public interface ToDoService {
    List<ToDo> findAll();

    ToDo findById(long id);

    ToDo add(ToDo toDo);

    ToDo update(ToDo toDo , long id);

    ToDo delete(long id);
}
