package br.com.davimc.todo.repositories;

import br.com.davimc.todo.domains.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoListRepository extends JpaRepository<ToDoList,Long> {
}
