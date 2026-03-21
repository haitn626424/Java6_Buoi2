package com.hai.setup.Controller;
import com.hai.setup.Entity.ToDo;
import com.hai.setup.Service.ToDoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/todos")
@RequiredArgsConstructor
public class ToDoController {

    private final ToDoService toDoService;

    //api/todos
    @GetMapping
    public ResponseEntity<List<ToDo>>  findAll(){
        List<ToDo> todos = toDoService.findAll();

        // return new ResponseEntity<>(todos, HttpStatus.OK);

        // return ResponseEntity.ok(todos);

         return ResponseEntity.status(HttpStatus.OK).body(todos);

//        return ResponseEntity
//                .ok()
//                .header("Custom-Header","Custom-Value").body(todos);
    }
    // GET: api/todos/{id}
    @GetMapping("/{id}")
    public ResponseEntity<ToDo>  getToDo(@PathVariable long id){
       ToDo todos =  toDoService.findById(id);

       return  new ResponseEntity<>(todos, HttpStatus.OK);
    }

    // POS: api/todos
    // 201-CREATED
    @PostMapping
    public ResponseEntity<ToDo> add(@Valid @RequestBody ToDo toDo){
        ToDo addTodo = toDoService.add(toDo);
        return new ResponseEntity<>(addTodo, HttpStatus.CREATED);
    }
    // PUT: api/todos/{id}
    @PutMapping("/{id}")
    public ResponseEntity<ToDo> update(@Valid @RequestBody ToDo toDo, @PathVariable long id){
         ToDo updateTodo = toDoService.update(toDo,id);
         //return new ResponseEntity<>(updateTodo, HttpStatus.OK);
        return ResponseEntity
                .ok()
                .header("Custome-Name","Custome-Value").body(updateTodo);

    }
    // DELETE: api/todos/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<ToDo> delete(@PathVariable long id){
       ToDo deleteTodo = toDoService.delete(id);
       return new ResponseEntity<>(deleteTodo, HttpStatus.OK);
    }
}
