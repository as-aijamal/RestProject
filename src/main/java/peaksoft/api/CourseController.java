package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.dto.request.CourseRequest;
import peaksoft.dto.response.CourseResponse;
import peaksoft.model.Course;
import peaksoft.service.CompanyService;
import peaksoft.service.CourseService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/courses/{id}")
public class CourseController {

    private final CourseService courseService;
    private final CompanyService companyService;

    @PostMapping()
    public CourseResponse saveCourse(@RequestBody CourseRequest courseRequest, @PathVariable("id") Long id) {
        courseRequest.setCompany(companyService.getCompanyById(id));
        return courseService.saveCourse(courseRequest, id);
    }

    @GetMapping()
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/get/{courseId}")
    public Optional<Course> getCourseById(@PathVariable Long courseId) {
        return courseService.findById(courseId);
    }

    @PatchMapping("/update/{courseId}")
    public CourseResponse updateCourse(@PathVariable Long courseId, @RequestBody CourseRequest courseRequest) {
        return courseService.updateCourse(courseId, courseRequest);
    }

    @DeleteMapping("/delete/{courseId}")
    public void deleteCourse(@PathVariable Long courseId) {
        courseService.deleteCourse(courseId);
    }
}
