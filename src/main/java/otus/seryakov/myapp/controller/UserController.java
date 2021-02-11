package otus.seryakov.myapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import otus.seryakov.myapp.model.User;
import otus.seryakov.myapp.service.UserService;

import javax.validation.Valid;

import java.util.List;

import static org.springframework.http.ResponseEntity.badRequest;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/users")
public class UserController {
    private final UserService service;

    @GetMapping()
    public List getUsers() {
        return service.getAllUsers();
    }

    @GetMapping("/id")
    public User getUserById(@RequestParam(value = "id", required = true) Long id) {
        return service.getUserById(id);
    }

    @PostMapping()
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
        if (service.addUser(user)) {
            return ok().body("Success added new user " + user.getUsername());
        }
        return badRequest().body("Current user already Exist");
    }

    @PutMapping("/id")
    public ResponseEntity<Object> updateUser(@RequestParam(value = "id", required = true) Long id,
                                             @Valid @RequestBody User user) {
        if (service.updateUsers(user)) {
            return ok().body("Success edit with id = " + user.getId());
        }
        return badRequest().body("User not found for update ");
    }

    @DeleteMapping("/id")
    public ResponseEntity<Object> deleteAddress(@RequestParam(value = "id", required = true) Long id) {
        if (service.deleteUser(id)) {
            return ResponseEntity.ok().body("Success delete user with id = " + id);
        }
        return ResponseEntity.badRequest().body("User not found for delete");
    }

}
