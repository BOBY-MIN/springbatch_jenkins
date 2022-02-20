package com.bobymin.batch.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class ComCodeSelectJobConfiguration {

	private final JobBuilderFactory jobBuilderFactory;
	private final StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Job comCodeSelectJob() {
		return jobBuilderFactory.get("comCodeSelectJob")
				.flow(comCodeSelectStep1())
				.end()
				.build();
	}
	
	@Bean
	public Step comCodeSelectStep1() {
		return stepBuilderFactory.get("comCodeSelectStep1")
				.tasklet(comCodeSelectTask(null))
				.build();
	}
	
	@Bean
	@StepScope
	public Tasklet comCodeSelectTask(@Value("#{jobParameters['exeDateTime']}") String exeDateTime) {
		
		return (stepContribution, chunkContext) -> {
			
			log.info("param ==== " + exeDateTime);
			
			return RepeatStatus.FINISHED;
		};
	}
	
}
