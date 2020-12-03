package org.personal.todos.user;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.Optional;

@Singleton
public class LoginService {

    @Inject
    private LoginRepository loginRepository;

    public Optional<Login> findLoginByUsernameAndPassword(Login login) {
        return loginRepository.find(login.getUsername(), login.getPassword());
    }

    public List<Login> findAll() {
        return loginRepository.findAll();
    }

    public Login save(Login login) {
        return loginRepository.save(login);
    }

    public Login update(Login login) {
        return loginRepository.update(login);
    }

    public void delete(Login login) {
        loginRepository.delete(login);
    }

    public Optional<Login> findById(Long id) {
        return loginRepository.findById(id);
    }
}
