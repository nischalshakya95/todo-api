package org.personal.todos.todo;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.Optional;

@Singleton
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

    public Optional<ToDo> findById(Long id) {
        return toDoRepository.findById(id);
    }
}

