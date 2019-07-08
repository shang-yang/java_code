package com.shangyang.quartz;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;


/**
 * 任务
 * @author shangyang
 *
 */
public class HelloJob implements Job{

	public HelloJob() {
		
	}
	
	
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		System.out.println("------start-----");
		System.out.println("Hello World! -"  + new Date());
		System.out.println("------end-------");
	}
}
