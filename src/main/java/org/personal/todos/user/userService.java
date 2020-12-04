package org.personal.todos.user;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.transaction.Transactional;
import java.util.List;

@Singleton
@Transactional
public class userService {

    @Inject
    private UserRepository userRepository;

    public User findLoginByUsernameAndPassword(User user) {
        return userRepository.find(user.getUsername(), user.getPassword())
                .orElseThrow(() -> new RuntimeException("Invalid Credentials"));
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User update(User user) {
        return userRepository.update(user);
    }

    public void delete(User user) {
        userRepository.delete(user);
    }

    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Resource with given id not found"));
    }
}
