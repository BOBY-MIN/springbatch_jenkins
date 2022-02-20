package com.bobymin.batch;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bobymin.batch.job.ComCodeSelectJobConfiguration;

@SpringBatchTest
@RunWith(SpringRunner.class)
@SpringBootTest(classes={ComCodeSelectJobConfiguration.class})
public class ComCodeSelectJobTest {

	@Autowired
	private JobLauncherTestUtils jobLauncherTestUtils;

	@Test
	public void jobTest() throws Exception {
		// given
		JobParameters jobParameters = new JobParametersBuilder()
				.addString("exeDateTime", "202007241682")
				.toJobParameters();
		
		// when
		JobExecution jobExecution = jobLauncherTestUtils.launchJob(jobParameters);
		
		// then
		Assert.assertEquals(jobExecution.getStatus(), BatchStatus.COMPLETED);
	}

}
