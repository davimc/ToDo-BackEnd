package br.com.davimc.todo.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;

public class UserNewDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotEmpty(message="Preenchimento obrigatório")
    @Length(min=2, max=120, message="O tamanho deve ser entre 5 e 120 caracteres")
    private String name;

    @NotEmpty(message="Preenchimento obrigatório")
    @Email(message="Email inválido")
    private String email;

    @PositiveOrZero(message="A pontuação não poderá ser negativa")
    private Long points;

    public UserNewDTO() {
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
