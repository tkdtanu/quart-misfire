package com.tkd.quartz.quartmisfire.service;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ScheduleJobProcessor {

    public void processJob(JobExecutionContext context) {
        log.info("ProcessJob Group Name ** {} ** Key Name ** {} ** fired @ {}", context.getJobDetail().getKey()
                .getGroup(), context.getJobDetail().getKey().getName(), context.getFireTime());
    }
}
