package org.personal.todos.todo;


import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Long> {
}
