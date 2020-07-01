package org.finastra.exam;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The Main class of this project
 * 
 * @author Jr Mangulabnan
 *
 */

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
