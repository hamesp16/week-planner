package org.hammertime.service;

import org.hammertime.entity.Task;
import org.hammertime.entity.Weekday;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
@Transactional
public class TaskService
{
    @Autowired
    private EntityManager em;

    public Long createTask(String description, Long weekdayId)
    {
        Weekday weekday = em.find(Weekday.class, weekdayId);
        if (weekday == null)
        {
            throw new IllegalArgumentException("Weekday " + weekdayId + " does not exist");
        }

        Task task = new Task();
        task.setDescription(description);
        task.setWeekday(weekday);

        em.persist(task);

        return task.getId();
    }

    public Task getTask(Long taskId)
    {
        return em.find(Task.class, taskId);
    }

    public List<Task> getAllTasks(boolean withWeekdays)
    {
        TypedQuery<Task> query = em.createQuery("SELECT t FROM Task t", Task.class);

        if (withWeekdays)
        {

        }

        return query.getResultList();
    }
}
