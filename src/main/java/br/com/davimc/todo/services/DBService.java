package br.com.davimc.todo.services;

import br.com.davimc.todo.domains.User;
import br.com.davimc.todo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private UserRepository userRepository;

    public void instantiateDatabase() throws ParseException {
        User u1 = new User(null, "Davi", "davimatosc@hotmail.com", 0L);
        User u2 = new User(null, "Lucas", "lucasgarcia@gmail.com", 0L);
        User u3 = new User(null, "Marcos", "marcosgarcia@gmail.com", 0L);

        userRepository.saveAll(Arrays.asList(u1,u2,u3));
    }
}
