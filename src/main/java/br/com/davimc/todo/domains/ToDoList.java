package br.com.davimc.todo.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ToDoList implements Serializable {
    private static final long versionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long points;

    @ManyToMany
    @JoinTable(name="TODOLIST_USER",
            joinColumns = @JoinColumn(name="todolist_id"),
            inverseJoinColumns = @JoinColumn(name="user_id"))
    private List<User> users = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "todoList")
    private List<Task> tasks = new ArrayList();

    public ToDoList() {
    }

    public ToDoList(Long id, String name, Long points) {
        this.id = id;
        this.name = name;
        this.points = points;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
