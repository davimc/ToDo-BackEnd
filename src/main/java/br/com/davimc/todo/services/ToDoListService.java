package br.com.davimc.todo.services;

import br.com.davimc.todo.domains.ToDoList;
/*import br.com.davimc.todo.dto.ToDoListNewDTO;
import br.com.davimc.todo.dto.ToDoListUpdateDTO;*/
import br.com.davimc.todo.dto.ToDoListNewDTO;
import br.com.davimc.todo.dto.ToDoListUpdateDTO;
import br.com.davimc.todo.repositories.ToDoListRepository;
import br.com.davimc.todo.services.exceptions.DataIntegrityException;
import br.com.davimc.todo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ToDoListService {
    @Autowired
    private ToDoListRepository repository;

    public ToDoList find(Long id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + ToDoList.class.getName())
        );
    }
    @Transactional
    public ToDoList insert(ToDoList obj) {
        return repository.save(obj);
    }

    public ToDoList update(ToDoList obj) {
        ToDoList newObj = this.find(obj.getId());
        newObj = updateData(newObj, obj);
        return repository.save(newObj);
    }

    private ToDoList updateData(ToDoList newObj, ToDoList obj) {
        newObj.setName(obj.getName() == null? newObj.getName() : obj.getName());
        newObj.setPoints(obj.getPoints() == null? newObj.getPoints() : obj.getPoints());
        return newObj;
    }

    public ToDoList fromDTO(ToDoListNewDTO objDTO) {
        return new ToDoList(null,objDTO.getName(),objDTO.getPoints());
    }

    public ToDoList fromDTO(ToDoListUpdateDTO objDTO) {
       return new ToDoList(objDTO.getId(), objDTO.getName(), objDTO.getPoints());
    }
    public void delete(Long id) {
        ToDoList obj = this.find(id);
        try {
            repository.delete(obj);
        }catch(DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir o Usuário porque há Listas relacionadas");
        }
    }
}
