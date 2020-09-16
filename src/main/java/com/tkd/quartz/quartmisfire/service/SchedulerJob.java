package com.tkd.quartz.quartmisfire.service;

import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Slf4j
@PersistJobDataAfterExecution
@DisallowConcurrentExecution
@Service
public class SchedulerJob implements Job {

    @Autowired
    private ScheduleJobProcessor scheduleJobProcessor;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        scheduleJobProcessor.processJob(context);
    }

}
