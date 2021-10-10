package br.com.davimc.todo.domains;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "@type")
public abstract class Task implements Serializable, ITask {
    private static final long serialVersionUID = 1L;
    @Id
    private long id;
    private String name;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private Calendar criationDate;

    @ManyToOne
    @JoinColumn(name = "todolist_id")
    private ToDoList todoList;

    public Task() {
    }

    public Task(long id, String name, Calendar criationDate) {
        this.id = id;
        this.name = name;
        this.criationDate = criationDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getCriationDate() {
        return criationDate;
    }

    public void setCriationDate(Calendar criationDate) {
        this.criationDate = criationDate;
    }

    public ToDoList getTodoList() {
        return todoList;
    }

    public void setTodoList(ToDoList todoList) {
        this.todoList = todoList;
    }
}
