package br.com.davimc.todo.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;

public class ToDoListNewDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotEmpty(message="Preenchimento obrigatório")
    @Length(min=1, max=120, message="O tamanho deve ser entre 5 e 120 caracteres")
    private String name;
    @PositiveOrZero(message="A pontuação não poderá ser negativa")
    private Long points;

    public ToDoListNewDTO() {
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
}
