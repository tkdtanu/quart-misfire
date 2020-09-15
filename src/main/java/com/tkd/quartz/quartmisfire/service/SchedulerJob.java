package com.tkd.quartz.quartmisfire.service;

import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.stereotype.Service;


@Slf4j
@PersistJobDataAfterExecution
@DisallowConcurrentExecution
@Service
public class SchedulerJob implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        log.info("ProcessJob Group Name ** {} ** Key Name ** {} ** fired @ {}", context.getJobDetail().getKey()
                .getGroup(), context.getJobDetail().getKey().getName(), context.getFireTime());

    }

}
