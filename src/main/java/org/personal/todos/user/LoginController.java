package org.personal.todos.user;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;

import javax.inject.Inject;
import java.util.List;

@Controller("/api/login")
public class LoginController {

    @Inject
    private LoginService loginService;

    @Post("/signup")
    public HttpResponse<Login> save(@Body Login login) {
        return HttpResponse.created(loginService.save(login));
    }

    @Get
    public HttpResponse<List<Login>> findAll() {
        return HttpResponse.ok(loginService.findAll());
    }

    @Post("/sign-in")
    public HttpResponse<Login> findLoginByUsernameAndPassword(@Body Login login) {
        return HttpResponse.ok(loginService.findLoginByUsernameAndPassword(login));
    }

    @Put("/{id}")
    public HttpResponse<Login> update(@PathVariable Long id, @Body Login login) {
        if (login.getId() == null || !login.getId().equals(id)) {
            return HttpResponse.badRequest();
        }
        return HttpResponse.ok(loginService.update(login));
    }

    @Delete("/{id}")
    public HttpResponse<Login> remove(@PathVariable Long id) {
        Login login = loginService.findById(id);
        loginService.delete(login);
        return HttpResponse.noContent();
    }

    @Get("/{id}")
    public HttpResponse<Login> findOne(@PathVariable Long id) {
        return HttpResponse.ok(loginService.findById(id));
    }
}
