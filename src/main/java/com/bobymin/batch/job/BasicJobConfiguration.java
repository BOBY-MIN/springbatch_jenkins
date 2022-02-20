package com.bobymin.batch.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bobymin.batch.tasklet.BasicTasklet;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class BasicJobConfiguration {

	private final JobBuilderFactory jobBuilderFactory;
	private final StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Job basicJob() {
		return jobBuilderFactory.get("basicJob")
				.flow(basicStep1())
				.end()
				.build();
	}
	
	@Bean
	public Step basicStep1() {
		return stepBuilderFactory.get("basicStep1")
				.tasklet(new BasicTasklet())
				.build();
	}
}
