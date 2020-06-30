package org.finastra.exam.app.main;

import org.finastra.exam.config.RepositoryConfig;
import org.finastra.exam.integration.config.JmsConfig;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * The Main class of this project
 * 
 * @author Jr Mangulabnan
 *
 */

@ComponentScan({ "org.finastra.exam.app.service", "org.finastra.exam.repository", "org.finastra.exam.integration.amq" })
@Import({ JmsConfig.class, RepositoryConfig.class })
@SpringBootApplication
public class FinastraExamApplication {
	/**
	 * The main method of this project
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(FinastraExamApplication.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
	}
}
