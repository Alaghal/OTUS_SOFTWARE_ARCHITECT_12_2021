package otus.seryakov.myapp.controller;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import otus.seryakov.myapp.domain.User;
import otus.seryakov.myapp.service.UserService;

import javax.validation.Valid;

import java.util.List;

import static org.springframework.http.ResponseEntity.badRequest;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@NoArgsConstructor
@RequestMapping("/v1/users")
//@Timed("users")
public class UserController {

    private  UserService service;


    // Metric Counter to collect the amount of Echo calls
    private Counter reqEchoCounter;


    public UserController (final MeterRegistry registry) {
        reqEchoCounter = registry.counter("user_rest", "usecase", "getUsers");

    }

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping()
//    @Timed(value = "users.all", percentiles = {0.5, 0.95, 0.99}, histogram = true)
    public List<User> getUsers() {
        return service.getAllUsers();
    }

    @GetMapping("/all")
    public List<User> getUsersWithCounter() {
        reqEchoCounter.increment();
        return service.getAllUsers();
    }

    @GetMapping("/id")
//    @Timed(value = "user", percentiles = {0.5, 0.95, 0.99}, histogram = true)
    public User getUserById(@RequestParam(value = "id", required = true) Long id) {
        return service.getUserById(id);
    }

    @PostMapping()
//    @Timed(value = "user.create", percentiles = {0.5, 0.95, 0.99}, histogram = true)
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
        if (service.addUser(user)) {
            return ok().body("Success added new user " + user.getUsername());
        }
        return badRequest().body("Current user already Exist");
    }

    @PutMapping("/id")
//    @Timed(value = "user.update", percentiles = {0.5, 0.95, 0.99}, histogram = true)
    public ResponseEntity<Object> updateUser(@RequestParam(value = "id", required = true) Long id,
                                             @Valid @RequestBody User user) {
        if (service.updateUsers(user)) {
            return ok().body("Success edit with   id = " + user.getId());
        }
        return badRequest().body("User not found for update ");
    }

    @DeleteMapping("/id")
//    @Timed(value = "user.delete", percentiles = {0.5, 0.95, 0.99}, histogram = true)
    public ResponseEntity<Object> deleteAddress(@RequestParam(value = "id", required = true) Long id) {
        if (service.deleteUser(id)) {
            return ResponseEntity.ok().body("Success delete user with id = " + id);
        }
        return ResponseEntity.badRequest().body("User not found for delete");
    }

    @GetMapping("/error")
//    @Timed(value = "error", percentiles = {0.5, 0.95, 0.99}, histogram = true)
    public ResponseEntity<Object> getError() {
        throw new IllegalStateException();
    }

}
