package otus.seryakov.myapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import otus.seryakov.myapp.domain.User;
import otus.seryakov.myapp.service.UserService;

import javax.validation.Valid;

import static org.springframework.http.ResponseEntity.badRequest;
import static org.springframework.http.ResponseEntity.ok;

@Controller
@RequiredArgsConstructor
public class RegistrationController {

    private final UserService userService;

    @PostMapping("/registration")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
        if (userService.addUser(user)) {
            return ok().body("Success registration new user " + user.getUsername());
        }
        return badRequest().body("Current user already Exist");
    }
}