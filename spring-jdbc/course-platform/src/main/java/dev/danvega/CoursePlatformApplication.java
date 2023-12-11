package dev.danvega;

import dev.danvega.model.Course;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoursePlatformApplication {

	private static DAO<Course> dao;

	public CoursePlatformApplication(DAO<Course> dao) {
		this.dao = dao;
	}

	public static void main(String[] args) {

		SpringApplication.run(CoursePlatformApplication.class, args);

		system.out.println("\nAll Courses ------------------");
		List<Course> courses = dao.list();
		courses.forEach(System.out::println);
	}

}
