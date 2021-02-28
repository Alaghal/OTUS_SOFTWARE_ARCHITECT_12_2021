package otus.seryakov.myapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
public class StubController {

    @GetMapping("/")
    public ResponseEntity<Object> getCurrentPage() {
        return ok().body("Main page :version  1.0.2.0");
    }
}
