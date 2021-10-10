package br.com.davimc.todo.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;

public class UserUpdateDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    @Length(min=2, max=120, message="O tamanho deve ser entre 5 e 120 caracteres")
    private String name;
    @Email(message="Email inválido")
    private String email;
    @PositiveOrZero(message="A pontuação não poderá ser negativa")
    private Long points;

    public UserUpdateDTO() {
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
}
