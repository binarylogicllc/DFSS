package com.ca.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.TimeZone;

@Slf4j
@SpringBootApplication
@EnableScheduling
public class DigitalFuelSchedulerApplication {
	public static void main(String[] args) {

		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Muscat"));
		Calendar calendar = Calendar.getInstance();
		log.info("Timezone" + calendar.getTimeZone());
		log.info("LocalDate : " + LocalDate.now().toString());
		log.info("LocalDateTime : " + LocalDateTime.now().toString());
		SpringApplication.run(DigitalFuelSchedulerApplication.class, args);
	}
}