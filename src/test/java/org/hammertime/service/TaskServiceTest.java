package org.hammertime.service;

import org.hammertime.Application;
import org.hammertime.entity.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TaskServiceTest extends ServiceTestBase
{
    @Autowired
    private TaskService taskService;

    @Test
    public void testNoTask()
    {
        List<Task> tasks = taskService.getAllTasks(false);
        assertEquals(0, tasks.size());
    }
}