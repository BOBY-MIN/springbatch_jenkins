package com.bobymin.batch.job;

import java.util.List;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bobymin.batch.service.TestService;
import com.bobymin.batch.vo.TestVo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@RequiredArgsConstructor
@EnableBatchProcessing
public class TaskletTestConfiguration {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Autowired
	private TestService testService;

	@Bean
	public Job taskletJob() {
		return jobBuilderFactory.get("taskletJob")
				.flow(taskletStep())
				.end()
				.build();
	}

	@Bean
	public Step taskletStep() {
		return stepBuilderFactory.get("taskletStep")
				.tasklet(taskletTask(null))
				.build();
	}

	@Bean
	@StepScope
	public Tasklet taskletTask(@Value("#{jobParameters['exeDateTime']}") String exeDateTime) {

		return (stepContribution, chunkContext) -> {

			log.info("releaseKey param ==== " + exeDateTime);


			List<TestVo> tempList = testService.selectList();

			for(TestVo arg : tempList) {
				log.info("arg ==== " + arg.toString());
			}

			return RepeatStatus.FINISHED;
		};
	}
}
