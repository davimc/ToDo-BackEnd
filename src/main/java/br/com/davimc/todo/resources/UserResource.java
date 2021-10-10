package br.com.davimc.todo.resources;

import br.com.davimc.todo.domains.User;
import br.com.davimc.todo.dto.UserNewDTO;
import br.com.davimc.todo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/users")
public class UserResource {
    @Autowired
    private UserService service;

    @GetMapping("/{id}")
    public ResponseEntity<User> find(@PathVariable Long id) {
        User user = service.find(id);
        return ResponseEntity.ok().body(user);
    }
    @PostMapping
    public ResponseEntity<User> create(@Valid @RequestBody UserNewDTO objDTO){
        User obj = service.fromDTO(objDTO);
        service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }


}
