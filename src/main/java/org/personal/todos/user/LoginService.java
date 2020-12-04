package org.personal.todos.user;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.transaction.Transactional;
import java.util.List;

@Singleton
@Transactional
public class LoginService {

    @Inject
    private LoginRepository loginRepository;

    public Login findLoginByUsernameAndPassword(Login login) {
        return loginRepository.find(login.getUsername(), login.getPassword())
                .orElseThrow(() -> new RuntimeException("Invalid Credentials"));
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

    public Login findById(Long id) {
        return loginRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Resource with given id not found"));
    }
}
