package org.soyphea.springboot3;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping
    ResponseEntity<?> listUsers() {
        List<User> users = List.of(new User("1234", "Mak Chandara"));
        return ResponseEntity.ok(users);
    }
}
