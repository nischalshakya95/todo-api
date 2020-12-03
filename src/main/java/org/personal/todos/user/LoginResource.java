package org.personal.todos.user;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;

import javax.inject.Inject;
import java.util.List;

@Controller("/api/login")
public class LoginResource {

    @Inject
    private LoginRepository loginRepository;

    @Post("/signup")
    public HttpResponse<Login> save(@Body Login login) {
        return HttpResponse.created(loginRepository.save(login));
    }

    @Get
    public HttpResponse<List<Login>> findAll() {
        return HttpResponse.ok(loginRepository.findAll());
    }

    @Post("/sign-in")
    public HttpResponse<Login> findLoginByUsernameAndPassword(@Body Login login) {
        return loginRepository
                .find(login.getUsername(), login.getPassword())
                .map(HttpResponse::ok)
                .orElseThrow(() -> new RuntimeException("Invalid Credentials"));
    }

    @Put("/{id}")
    public HttpResponse<Login> update(@PathVariable Long id, @Body Login login) {
        if (login.getId() == null || !login.getId().equals(id)) {
            return HttpResponse.badRequest();
        }
        return HttpResponse.ok(loginRepository.update(login));
    }

    @Delete("/{id}")
    public HttpResponse<Login> remove(@PathVariable Long id) {
        Login login = loginRepository.findById(id).orElseThrow(() -> new RuntimeException("Resource with given id not found"));
        loginRepository.delete(login);
        return HttpResponse.noContent();
    }

    @Get("/{id}")
    public HttpResponse<Login> findOne(@PathVariable Long id) {
        return loginRepository.findById(id).map(HttpResponse::ok)
                .orElseThrow(() -> new RuntimeException("Resource with give id not found"));
    }
}
