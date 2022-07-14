package peaksoft.mapper;

import org.springframework.stereotype.Component;
import peaksoft.dto.request.CourseRequest;
import peaksoft.dto.response.CourseResponse;
import peaksoft.model.Course;
import peaksoft.repository.CompanyRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class CourseMapper {

private final CompanyRepository companyRepository;

    public CourseMapper(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Course saveCourse(CourseRequest courseRequest,Long id) {
        Course course = new Course();
        course.setCourseName(courseRequest.getCourseName());
        course.setDuration(courseRequest.getDuration());
        course.setCompany(companyRepository.findById(id).get());
        return course;
    }

    public CourseResponse viewCourse(Course course) {
        if (course == null) {
            return null;
        }
        CourseResponse courseResponse = new CourseResponse();
        if (course.getId() != null) {
            courseResponse.setId(String.valueOf(course.getId()));
        }
        courseResponse.setCourseName(course.getCourseName());
        courseResponse.setDuration(course.getDuration());
        return courseResponse;
    }

        public List<CourseResponse>viewCourses(List<Course>courses){
        List<CourseResponse>courseResponses=new ArrayList<>();
            for (Course course:courses) {
                courseResponses.add(viewCourse(course));
            }
            return courseResponses;
        }

        public void updateCourse(Course course,CourseRequest courseRequest){
        course.setCourseName(courseRequest.getCourseName());
        course.setDuration(courseRequest.getDuration());
        }
    }
