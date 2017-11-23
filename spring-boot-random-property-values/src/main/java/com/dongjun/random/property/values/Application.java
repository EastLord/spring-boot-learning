package com.dongjun.random.property.values;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.UUID;


/**
 * @author Administrator
 */
@SpringBootApplication
public class Application {

	private static Logger log = LoggerFactory.getLogger(Application.class);

	@Value("${property.values.password}")
	private String password;

	@Value("${property.values.intValue}")
	private Integer intValue;

	@Value("${property.values.intValueRange}")
	private Integer intValueRange;

	@Value("${property.values.longValue}")
	private Long longValue;

	@Value("${property.values.longValueRange}")
	private Long longValueRange;

	@Value("${property.values.uuid}")
	private UUID uuid;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@PostConstruct
	private void init(){
		log.info("Configure Random Property Values using Spring Boot");
		log.info("password: " + password);
		log.info("intValue: " + intValue);
		log.info("intValueRange: " + intValueRange);
		log.info("longValue: " + longValue);
		log.info("longValueRange: " + longValueRange);
		log.info("uuid: " + uuid);
	}

}
