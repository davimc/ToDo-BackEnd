package br.com.davimc.todo.domains;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Entity
public class DailyITask extends Task implements Serializable {
    private static final long versionUID = 1L;
    @ElementCollection
    @CollectionTable(name = "DATA_REALIZACAO")
    private List<Calendar> completionDates;

    public DailyITask() {
    }

    public DailyITask(Long id, String name) {
        super(id,name, Calendar.getInstance());
        this.completionDates = new ArrayList<>();
    }

    public List<Calendar> getCompletionDates() {
        return completionDates;
    }

    public void setCompletionDates(List<Calendar> completionDates) {
        this.completionDates = completionDates;
    }

    @Override
    public void realizar(Calendar dataRealizacao) {
        this.completionDates.add(dataRealizacao);
    }
}
