package com.hai.setup.Controller;

import com.hai.setup.Entity.ToDo;
import com.hai.setup.Repository.ToDoRepository;
import com.hai.setup.Service.ToDoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
@RequiredArgsConstructor
public class ToDoController {
    private final ToDoService toDoService;
    //api/todos
    @GetMapping
    public List<ToDo> findAll(){
        return toDoService.findAll();
    }

    @GetMapping("/{id}")
    public ToDo getToDo(@PathVariable long id){
        return toDoService.findById(id);
    }
    @PostMapping("/add")
    public ToDo add(@ModelAttribute ToDo toDo){
        return  toDoService.add(toDo);
    }
    @PostMapping("/update/{id}")
    public ToDo update(@ModelAttribute ToDo toDo, @PathVariable long id){
        return toDoService.update(toDo,id);
    }
    @DeleteMapping("/delete/{id}")
    public ToDo delete(@PathVariable long id){
        return toDoService.delete(id);
    }
}
