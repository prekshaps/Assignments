package com.logging.loggingdemo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;

import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class DemoControllerTest {
	private static MemoryAppender memoryAppender;
	private static final String LOGGER_NAME = "com.logging.loggingdemo";
	private static final String MSG = "This is a test message!!!";

	@BeforeEach
	public void setup() {
		Logger logger = (Logger) LoggerFactory.getLogger(LOGGER_NAME);
		memoryAppender = new MemoryAppender();
		memoryAppender.setContext((LoggerContext) LoggerFactory.getILoggerFactory());
		logger.setLevel(Level.DEBUG);
		logger.addAppender(memoryAppender);
		memoryAppender.start();

	}

	@AfterEach
	public void cleanUp() {
		memoryAppender.reset();
		memoryAppender.stop();
	}

	@Test
	public void test() {
		DemoController worker = new DemoController();
		worker.welcome(MSG);

		assertThat(memoryAppender.countEventsForLogger(LOGGER_NAME)).isEqualTo(5);

		assertThat(memoryAppender.search(MSG, Level.INFO).size()).isEqualTo(1);

		assertThat(memoryAppender.contains(MSG, Level.TRACE)).isFalse();
	}
}
