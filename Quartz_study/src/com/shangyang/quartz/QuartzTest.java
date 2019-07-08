package com.shangyang.quartz;

import java.util.Date;

import static org.quartz.DateBuilder.evenSecondDate;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

/**
 * quartz学习入门
 * @author shangyang
 *
 */
public class QuartzTest {

	public void run() throws Exception{
		// 1.创建Scheduler的工厂
		SchedulerFactory sf = new StdSchedulerFactory();
		// 2.从工厂中获取调度器
		Scheduler sched = sf.getScheduler();
		
		// 3.创建
		JobDetail job = newJob(HelloJob.class).withIdentity("job1","group1").build();
		
		// 时间
		Date runTime = evenSecondDate(new Date());
		
		// 4.触发器
		Trigger triger = newTrigger().withIdentity("trigger1", "group1").startAt(runTime).build();
		
		// 5.注册任务和触发条件
		sched.scheduleJob(job,triger);
		
		// 6.启动
		sched.start();
		//五秒后停止
		Thread.sleep(5L * 1000L);
		sched.shutdown(true);
	}
	
	public static void main(String[] args) throws Exception {
		QuartzTest example = new QuartzTest();
		example.run();
	}
}
