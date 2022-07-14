package peaksoft.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.dto.request.CourseRequest;
import peaksoft.dto.response.CourseResponse;
import peaksoft.mapper.CourseMapper;
import peaksoft.model.Course;
import peaksoft.repository.CourseRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
@Transactional
public class CourseServiceImpl implements CourseService {


    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    @Override
    public CourseResponse saveCourse(CourseRequest course, Long id) {
        return courseMapper.viewCourse(courseRepository.save(courseMapper.saveCourse(course,id)));
    }

    @Override
    public Optional<Course> findById(Long id) {
        return courseRepository.findById(id);
    }

    @Override
    public List<Course> getAllCourses() {
        List<Course> courseList = courseRepository.findAll();
        return courseList;
    }

    @Override
    public Course getCourseById(Long id) {
        return courseRepository.getById(id);
    }

    @Override
    public void deleteCourse(Long id) {
        Course course = courseRepository.findById(id).get();
        courseRepository.deleteById(id);
        courseMapper.viewCourse(course);
    }

    @Override
    public CourseResponse updateCourse(Long id, CourseRequest course) {
        Course course1 = courseRepository.findById(id).get();
        courseMapper.updateCourse(course1, course);
        return courseMapper.viewCourse(courseRepository.save(course1));
    }
}
