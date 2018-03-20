package org.hammertime.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

@Entity
public class Task
{
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    @Size(max = 128)
    private String description;

    private boolean complete;

    @ManyToOne
    private Weekday weekday;

    public Task()
    {
    }

    public Task(String description)
    {
        this.description = description;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public boolean isComplete()
    {
        return complete;
    }

    public void setComplete(boolean complete)
    {
        this.complete = complete;
    }

    public Weekday getWeekday()
    {
        return weekday;
    }

    public void setWeekday(Weekday weekday)
    {
        this.weekday = weekday;
    }
}
