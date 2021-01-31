package otus.seryakov.myapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
public class HealthController {

    @GetMapping("/health")
    public ResponseEntity<Object> getHealth(){
        return ok().body("It's alive");
    }

}
