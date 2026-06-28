package com.jobrunr.demo;

import lombok.extern.slf4j.Slf4j;
import org.jobrunr.jobs.JobId;
import org.jobrunr.jobs.annotations.Recurring;
import org.jobrunr.jobs.mappers.JobMapper;
import org.jobrunr.jobs.states.JobState;
import org.jobrunr.scheduling.JobScheduler;
import org.jobrunr.scheduling.cron.Cron;
import org.jobrunr.storage.InMemoryStorageProvider;
import org.jobrunr.storage.StorageProvider;
import org.jobrunr.storage.ThreadSafeStorageProvider;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.Instant;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

@Slf4j
@SpringBootApplication
public class JobrunrDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobrunrDemoApplication.class, args);
	}

//	@Bean
//	public StorageProvider storageProvider(JobMapper jobMapper) {
//		InMemoryStorageProvider provider = new InMemoryStorageProvider();
//		provider.setJobMapper(jobMapper);
//		return new ThreadSafeStorageProvider(provider);
//	}

	@Bean
	ApplicationRunner runner(JobScheduler jobScheduler, StorageProvider storageProvider) {
		return args -> {
			JobId jobId = jobScheduler.enqueue(() -> {
				System.out.println("Testing Instant Job");
			});

			JobState jobState = storageProvider.getJobById(jobId.asUUID()).getJobState();
			System.out.println(jobState.getName());

			jobScheduler.schedule(Instant.now().plus(30, ChronoUnit.SECONDS), () -> {
				System.out.println("Testing Schedule Job");
			});

			jobScheduler.scheduleRecurrently("testing", Cron.every15seconds(), () -> {
				System.out.println("Testing Cron Job");
			});
		};
	}

	@Recurring(id = "test-rec", cron = "*/5 * * * * *", zoneId = "Asia/Kolkata")
	public void testRec() {
		log.info("test-rec");
	}

}
