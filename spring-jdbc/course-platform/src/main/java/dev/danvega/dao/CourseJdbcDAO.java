package dev.danvega.dao;

import dev.danvega.model.Course;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class CourseJdbcDAO implements DAO<Course> {

    private static final Logger log = LoggerFactory.getLogger(CourseJdbcDAO.class);

    private JdbcTemplate jdbcTemplate;

    RowMapper<Course> rowMapper = (rs, rowNum) -> {
        Course course = new Course();

        course.setCourseId(rs.getInt("course_id"));
        course.setTitle(rs.getString("title"));
        course.setDescription(rs.getString("description"));
        course.setLink(rs.getString("link"));

        return course;
    };

    public CourseJdbcDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @java.lang.Override
    public List<Course> list() {
        String sql = "SELECT course_id, title, description link from course";

        jdbcTemplate.query(sql, rowMapper);
        return null;
    }

    @java.lang.Override
    public void create(Course course) {

    }

    @java.lang.Override
    public Optional<Course> get(int id) {
        return null;
    }

    @java.lang.Override
    public void update(Course course, int id) {

    }

    @java.lang.Override
    public void delete(int id) {

    }
}
