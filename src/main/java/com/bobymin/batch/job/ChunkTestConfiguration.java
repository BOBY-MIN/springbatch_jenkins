package com.bobymin.batch.job;

import java.util.List;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bobymin.batch.step.ChunkStepProcess;
import com.bobymin.batch.step.ChunkStepRead;
import com.bobymin.batch.step.ChunkStepWrite;
import com.bobymin.batch.vo.TestVo;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
@EnableBatchProcessing
public class ChunkTestConfiguration {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Autowired
	private ChunkStepRead chunkStepRead;

	@Autowired
	private ChunkStepProcess chunkStepProcess;

	@Autowired
	private ChunkStepWrite chunkStepWrite;


	@Bean
	public Job chunkJob() {
		return jobBuilderFactory.get("chunkJob")
				.start(chunkStep())
				.build();
	}

	@Bean
	protected Step chunkStep() {
		return stepBuilderFactory.get("chunkStep")
				.<List<TestVo>, List<TestVo>> chunk(2)
				.reader(chunkStepRead)
				.processor(chunkStepProcess)
				.writer(chunkStepWrite)
				.build();
	}
}
