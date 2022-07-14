package peaksoft.service;

import peaksoft.dto.request.CourseRequest;
import peaksoft.dto.response.CourseResponse;
import peaksoft.model.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {

    CourseResponse saveCourse(CourseRequest course, Long id);

    Optional<Course> findById(Long id);

    List<Course> getAllCourses();

    Course getCourseById(Long id);

    void deleteCourse(Long id);

    CourseResponse updateCourse(Long id,CourseRequest course);
}
