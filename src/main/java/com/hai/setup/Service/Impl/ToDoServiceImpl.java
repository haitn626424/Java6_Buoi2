package com.hai.setup.Service.Impl;

import com.hai.setup.Entity.ToDo;
import com.hai.setup.Repository.ToDoRepository;
import com.hai.setup.Service.ToDoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ToDoServiceImpl implements ToDoService {

    private final ToDoRepository toDoRepository;

    @Override
    public List<ToDo> findAll() {
        return toDoRepository.findAll();
    }

    @Override
    public ToDo findById(long id) {
        return toDoRepository
                .findById(id)
                .orElse(null);
    }

    @Override
    public ToDo add(ToDo toDo) {
        return toDoRepository.save(toDo);
    }

    @Override
    public ToDo update(ToDo toDo, long id) {
       return toDoRepository
               .findById(id)
               .map(exitsting ->{
                   if(toDo.getTitle() != null){
                       exitsting.setTitle(toDo.getTitle());
                   }
                   if(toDo.getDescription() != null){
                       exitsting.setDescription(toDo.getDescription());
                   }
                   exitsting.setCompleted(toDo.isCompleted());

                   return toDoRepository.save(exitsting);
               })
               .orElse(null);
    }

    @Override
    public ToDo delete(long id) {
       ToDo deletedToDo = findById(id);
       if(deletedToDo!=null){
           toDoRepository.deleteById(id);
       }
       return deletedToDo;
    }
}
