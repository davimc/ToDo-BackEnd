package br.com.davimc.todo.dto;

import br.com.davimc.todo.domains.ToDoList;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ToDoListDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private Long points;
    private List<String> users = new ArrayList<>();

    public ToDoListDTO() {
    }

    public ToDoListDTO(ToDoList todo) {
        this.name = todo.getName();
        this.points = todo.getPoints();
        this.users = todo.getUsers().stream().map(u -> u.getName()).collect(Collectors.toList());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPoints() {
        return points;
    }

    public void setPoints(Long points) {
        this.points = points;
    }

    public List<String> getUsers() {
        return users;
    }

    public void setUsers(List<String> users) {
        this.users = users;
    }
}
