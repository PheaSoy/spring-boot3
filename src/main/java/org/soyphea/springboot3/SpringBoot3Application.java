package org.soyphea.springboot3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
public class SpringBoot3Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot3Application.class, args);
    }

    @RestController
    @RequestMapping("/users")
    class UserController {

        @GetMapping
        ResponseEntity<?> listUsers() {
            List<User> users = List.of(new User("1234", "Mak Chandara"));
            return ResponseEntity.ok(users);
        }
    }

    public record User(String id, String name) {

    }


}
