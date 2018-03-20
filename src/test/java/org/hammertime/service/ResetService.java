package org.hammertime.service;

import org.hammertime.entity.Task;
import org.hammertime.entity.Week;
import org.hammertime.entity.Weekday;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Query;

@Service
@Transactional
public class ResetService
{
    @Autowired
    private EntityManager em;

    public void resetDatabase()
    {
        deleteEntities(Task.class);
        deleteEntities(Weekday.class);
        deleteEntities(Week.class);
    }

    private void deleteEntities(Class<?> entity)
    {
        if (entity == null || entity.getAnnotation(Entity.class) == null)
        {
            throw new IllegalArgumentException("Invalid non-entity class.");
        }

        String name = entity.getName();

        /*
            Passing Class<?> as input instead of String to avoid SQL injection.
            Should not be a problem since it is test code, but as a good habit always
            be paranoid about security..
         */

        Query query = em.createQuery("DELETE FROM " + name);
        query.executeUpdate();
    }
}
