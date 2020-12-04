package org.personal.todos.user;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;

import javax.inject.Inject;
import java.util.List;

@Controller("/api/login")
public class UserController {

    @Inject
    private userService userService;

    @Post("/signup")
    public HttpResponse<User> save(@Body User user) {
        return HttpResponse.created(userService.save(user));
    }

    @Get
    public HttpResponse<List<User>> findAll() {
        return HttpResponse.ok(userService.findAll());
    }

    @Post("/sign-in")
    public HttpResponse<User> findLoginByUsernameAndPassword(@Body User user) {
        return HttpResponse.ok(userService.findLoginByUsernameAndPassword(user));
    }

    @Put("/{id}")
    public HttpResponse<User> update(@PathVariable Long id, @Body User user) {
        if (user.getId() == null || !user.getId().equals(id)) {
            return HttpResponse.badRequest();
        }
        return HttpResponse.ok(userService.update(user));
    }

    @Delete("/{id}")
    public HttpResponse<User> remove(@PathVariable Long id) {
        User user = userService.findById(id);
        userService.delete(user);
        return HttpResponse.noContent();
    }

    @Get("/{id}")
    public HttpResponse<User> findOne(@PathVariable Long id) {
        return HttpResponse.ok(userService.findById(id));
    }
}
