package com.hai.setup.Controller;

import com.hai.setup.Entity.ToDo;
import com.hai.setup.Repository.ToDoRepository;
import com.hai.setup.Service.ToDoService;
import lombok.RequiredArgsConstructor;
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
    // GET: api/todos/{id}
    @GetMapping("/{id}")
    public ToDo getToDo(@PathVariable long id){
        return toDoService.findById(id);
    }

    // POS: api/todos
    @PostMapping
    public ToDo add(@RequestBody ToDo toDo){
        return  toDoService.add(toDo);
    }
    // PUT: api/todos/{id}
    @PutMapping("/{id}")
    public ToDo update(@RequestBody ToDo toDo, @PathVariable long id){
        return toDoService.update(toDo,id);
    }
    // DELETE: api/todos/{id}
    @DeleteMapping("/{id}")
    public ToDo delete(@PathVariable long id){
        return toDoService.delete(id);
    }
}
