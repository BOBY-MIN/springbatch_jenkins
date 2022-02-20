package com.bobymin.batch.tasklet;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Component
public class BasicTasklet implements Tasklet, StepExecutionListener {


	/*
	 * Tasklet : 주요 비즈니스로직 처리
	 * StepExecutionListener : 전처리, 후처리 지원
	 * */
	

	@Override
	public void beforeStep(StepExecution stepExecution) {
		
		log.info("ComCodeSelectTask 전처리");
	}
	
	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		
		log.info("ComCodeSelectTask 확인");
		System.out.println("test 확인");
		return RepeatStatus.FINISHED;
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		
		log.info("ComCodeSelectTask 후처리");
		
		return ExitStatus.COMPLETED;
	}
	
}
