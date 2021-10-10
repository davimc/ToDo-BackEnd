package br.com.davimc.todo.domains;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User implements Serializable {
    private static final long versionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true)
    private String email;
    private Long points;
    @ManyToMany(mappedBy = "users")
    private List<ToDoList> lists = new ArrayList<>();

    public User() {
    }

    public User(Long id, String name, String email, Long points) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.points = points;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPoints() {
        return points;
    }

    public void setPoints(Long points) {
        this.points = points;
    }

    public List<ToDoList> getLists() {
        return lists;
    }

    public void setLists(List<ToDoList> lists) {
        this.lists = lists;
    }
}
