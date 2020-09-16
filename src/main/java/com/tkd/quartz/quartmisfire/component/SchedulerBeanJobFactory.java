package com.tkd.quartz.quartmisfire.component;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;
import org.springframework.stereotype.Component;

@Component
public class SchedulerBeanJobFactory extends SpringBeanJobFactory implements ApplicationContextAware {
    private ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        this.context = applicationContext;
    }

    public <T> T getBean(Class<T> requiredType) {
        return this.context.getBean(requiredType);
    }

    @Override
    protected Object createJobInstance(TriggerFiredBundle bundle)
            throws Exception {

        Object jobInstance = super.createJobInstance(bundle);
        this.context.getAutowireCapableBeanFactory().autowireBean(jobInstance);
        return jobInstance;
    }

}
