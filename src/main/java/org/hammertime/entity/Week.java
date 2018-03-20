package org.hammertime.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Week
{
    @Id
    @GeneratedValue
    private Long id;

    @Min(1)
    @Max(52)
    @NotBlank
    private Integer weekNumber;
//TODO: Til Integer

    @OneToMany(mappedBy = "week")
    private List<Weekday> weekdays;

    @NotNull
    private LocalDate dateWeekStart;

    @NotNull
    private LocalDate dateWeekEnd;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Integer getWeekNumber()
    {
        return weekNumber;
    }

    public void setWeekNumber(Integer weekNumber)
    {
        this.weekNumber = weekNumber;
    }

    public List<Weekday> getWeekdays()
    {
        return weekdays;
    }

    public void setWeekdays(List<Weekday> weekdays)
    {
        this.weekdays = weekdays;
    }

    public LocalDate getDateWeekStart()
    {
        return dateWeekStart;
    }

    public void setDateWeekStart(LocalDate dateWeekStart)
    {
        this.dateWeekStart = dateWeekStart;
    }

    public LocalDate getDateWeekEnd()
    {
        return dateWeekEnd;
    }

    public void setDateWeekEnd(LocalDate dateWeekEnd)
    {
        this.dateWeekEnd = dateWeekEnd;
    }
}
