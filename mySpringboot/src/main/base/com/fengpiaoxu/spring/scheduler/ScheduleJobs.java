package com.fengpiaoxu.spring.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleJobs {
	
	private static Logger log = LoggerFactory.getLogger(ScheduleJobs.class) ;

	/**
	 * 5秒执行一次
	 */
	@Scheduled(fixedRate = 5000)
    public void cronJob() {
		log.info("测试定时任务");
    }
	
	//每天19点16分50秒时执行
    @Scheduled(cron = "50 32 19 * * ?")
    public void timerCron() {
    	log.info("测试定时任务 19：3250");
    }
}
