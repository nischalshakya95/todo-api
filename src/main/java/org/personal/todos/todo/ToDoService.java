package org.personal.todos.todo;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.transaction.Transactional;
import java.util.List;

@Singleton
@Transactional
public class ToDoService {

    @Inject
    private ToDoRepository toDoRepository;

    public List<ToDo> findAll() {
        return toDoRepository.findAll();
    }

    public ToDo save(ToDo toDo) {
        return toDoRepository.save(toDo);
    }

    public ToDo update(ToDo toDo) {
        return toDoRepository.update(toDo);
    }

    public void delete(ToDo toDo) {
        toDoRepository.delete(toDo);
    }

    public ToDo findById(Long id) {
        return toDoRepository.findById(id).orElseThrow(() -> new RuntimeException("Resource with given id not found"));
    }
}

