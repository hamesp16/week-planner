package org.hammertime.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Weekday
{
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    @Size(max = 15)
    private String name;

    @NotNull
    @Column(unique = true)
    private LocalDate date;

    private boolean allTasksComplete;

    @OneToMany(mappedBy = "weekday", cascade = CascadeType.ALL)
    private List<Task> tasks = new ArrayList<>();

    @ManyToOne
    private Week week;

    public Weekday()
    {
    }

    public Weekday(String name)
    {
        this.name = name;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public LocalDate getDate()
    {
        return date;
    }

    public void setDate(LocalDate date)
    {
        this.date = date;
    }

    public boolean isAllTasksComplete()
    {
        return allTasksComplete;
    }

    public void setAllTasksComplete(boolean allTasksComplete)
    {
        this.allTasksComplete = allTasksComplete;
    }

    public List<Task> getTasks()
    {
        return tasks;
    }

    public void setTasks(List<Task> tasks)
    {
        this.tasks = tasks;
    }

    public Week getWeek()
    {
        return week;
    }

    public void setWeek(Week week)
    {
        this.week = week;
    }
}
