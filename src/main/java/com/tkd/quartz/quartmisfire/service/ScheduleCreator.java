package com.tkd.quartz.quartmisfire.service;

import org.quartz.*;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Service
public class ScheduleCreator {

    @Autowired
    private Scheduler scheduler;

    public void construct() throws SchedulerException {
        CalendarIntervalScheduleBuilder schedule = CalendarIntervalScheduleBuilder
                .calendarIntervalSchedule()
                .withIntervalInMinutes((int) 3)
                .withMisfireHandlingInstructionFireAndProceed();
        JobDetail jobDetail = new JobDetailImpl("job", SchedulerJob.class);

        Trigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity("Abc")
                .withIdentity("trigger2", "group1")
                .startAt(Date.from(LocalDateTime.now().minusMinutes(2).minusSeconds(30).atZone(ZoneId.systemDefault()).toInstant()))
                .withSchedule(schedule).build();
        try {
            scheduler.scheduleJob(jobDetail, trigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
    @PostConstruct
    public void create() throws SchedulerException {

        // define the job and tie it to the SimpleJob class
        JobDetail job = JobBuilder.newJob(SchedulerJob.class)
                .withIdentity("myJob", "myGroup")
                .build();

        // create the trigger and define its schedule to run every 3 seconds
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("myTrigger", "myGroup")
                .startAt(Date.from(LocalDateTime.now().plusMinutes(2).atZone(ZoneId.systemDefault()).toInstant()))
                .withSchedule(SimpleScheduleBuilder.simpleSchedule())
                .build();

        // add the job details to the scheduler and associate it with the trigger
        try {
            scheduler.scheduleJob(job, trigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
