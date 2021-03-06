package br.com.davimc.todo.services;

import br.com.davimc.todo.domains.User;
import br.com.davimc.todo.dto.UserNewDTO;
import br.com.davimc.todo.dto.UserUpdateDTO;
import br.com.davimc.todo.repositories.UserRepository;
import br.com.davimc.todo.services.exceptions.DataIntegrityException;
import br.com.davimc.todo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;


    public User find(Long id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + User.class.getName())
        );
    }
    @Transactional
    public User insert(User obj) {
        return repository.save(obj);
    }

    public User update(User obj) {
        User newObj = this.find(obj.getId());
        newObj = updateData(newObj, obj);
        return repository.save(newObj);
    }

    private User updateData(User newObj, User obj) {
        newObj.setName(obj.getName()==null? newObj.getName() : obj.getName());
        newObj.setEmail(obj.getEmail() == null? newObj.getEmail() : obj.getEmail());
        newObj.setPoints(obj.getPoints() == null? newObj.getPoints() : obj.getPoints());
        return newObj;
    }

    public User fromDTO(UserNewDTO objDTO) {
        return new User(null,objDTO.getName(),objDTO.getEmail(),objDTO.getPoints());
    }
    public User fromDTO(UserUpdateDTO objDTO) {
        return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail(), objDTO.getPoints());
    }

    public void delete(Long id) {
        User obj = this.find(id);
        try {
            repository.delete(obj);
        }catch(DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir o Usuário porque há Listas relacionadas");
        }
    }
}
