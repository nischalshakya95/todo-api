package org.personal.todos.todo;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;

import javax.inject.Inject;
import java.util.List;

@Controller("/api/todos")
public class ToDoResource {

    @Inject
    private ToDoRepository toDoRepository;

    @Get
    public HttpResponse<List<ToDo>> findAll() {
        return HttpResponse.ok().body(toDoRepository.findAll());
    }

    @Post
    public HttpResponse<ToDo> save(@Body ToDo toDo) {
        return HttpResponse.created(toDoRepository.save(toDo));
    }

    @Put("/{id}")
    public HttpResponse<ToDo> update(@PathVariable Long id, @Body ToDo toDo) {
        if (toDo.getId() == null || !toDo.getId().equals(id)) {
            return HttpResponse.badRequest();
        }
        return HttpResponse.ok(toDoRepository.update(toDo));
    }

    @Delete("/{id}")
    public HttpResponse<Void> remove(@PathVariable Long id) {
        ToDo toDo = toDoRepository.findById(id).orElseThrow(() -> new RuntimeException("Resource with given id not found"));
        toDoRepository.delete(toDo);
        return HttpResponse.noContent();
    }

    @Get("/{id}")
    public HttpResponse<ToDo> findOne(@PathVariable Long id) {
        return toDoRepository.findById(id).map(HttpResponse::ok)
                .orElseThrow(() -> new RuntimeException("Resource with given id not found"));
    }
}
