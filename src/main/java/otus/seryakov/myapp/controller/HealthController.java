package otus.seryakov.myapp.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
public class HealthController {

    @ResponseBody
    @GetMapping("/health")
    public Map<String, String> getHealth(){
        return Collections.singletonMap("status","ok");
    }

}
