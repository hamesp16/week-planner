package org.hammertime.service;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;

public class ServiceTestBase
{
    @Autowired
    private ResetService resetService;

    @Before
    public void cleanDatabase()
    {
        resetService.resetDatabase();
    }
}
