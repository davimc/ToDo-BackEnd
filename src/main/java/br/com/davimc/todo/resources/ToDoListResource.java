package br.com.davimc.todo.resources;

import br.com.davimc.todo.domains.ToDoList;
import br.com.davimc.todo.dto.ToDoListDTO;
import br.com.davimc.todo.dto.ToDoListNewDTO;
import br.com.davimc.todo.dto.ToDoListUpdateDTO;
import br.com.davimc.todo.services.ToDoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/lists")
public class ToDoListResource {
    @Autowired
    private ToDoListService service;

    @GetMapping("/{id}")
    public ResponseEntity<ToDoListDTO> find(@PathVariable Long id) {
        ToDoListDTO obj = new ToDoListDTO(service.find(id));
        return ResponseEntity.ok().body(obj);
    }
    @PostMapping
    public ResponseEntity<ToDoList> create(@Valid @RequestBody ToDoListNewDTO objDTO){
        ToDoList obj = service.fromDTO(objDTO);
        service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ToDoList> update(@Valid @RequestBody ToDoListNewDTO objDTO, @PathVariable Long id) {
        ToDoList obj = service.fromDTO(objDTO);
        obj.setId(id);
        service.update(obj);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ToDoList> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
