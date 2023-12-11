package dev.danvega;

import dev.danvega.DAO.DAO;
import dev.danvega.model.Course;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class CoursePlatformApplication {

	private static DAO<Course> dao;

	public CoursePlatformApplication(DAO<Course> dao) {
		this.dao = dao;
	}


	public static void main(String[] args) {

		SpringApplication.run(CoursePlatformApplication.class, args);

		System.out.println("\nCreate Course---------------\n");
		Course oracleCourse = new Course("Oracle", "Course of Oracle", "http://localhost/Oracle");
		dao.create(oracleCourse);



		System.out.println("\nAll Courses---------------\n");
		List<Course> courses = dao.list();

		courses.forEach(System.out::println);

		System.out.println("\nGet One Course---------------\n");
		Optional<Course> firstOne = dao.get(1);
		System.out.println(firstOne.get());

		System.out.println("\nUpdate One Course---------------\n");
		oracleCourse.setDescription("A must for those who admin Oracle");
		int oracleId = 5;
		System.out.println("Updating course for oracle id " + oracleId);
		dao.update(oracleCourse, oracleId);

		System.out.println("\nAll Courses : after update---------------\n");
		List<Course> updatedCourses = dao.list();

		updatedCourses.forEach(System.out::println);

		System.out.println("\nAll Courses : after deleting 3---------------\n");
		dao.delete(3);
		updatedCourses = dao.list();
		updatedCourses.forEach(System.out::println);

	}
}
