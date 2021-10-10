package br.com.davimc.todo;

import br.com.davimc.todo.domains.User;
import br.com.davimc.todo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ToDoApplication implements CommandLineRunner {
    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(ToDoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
