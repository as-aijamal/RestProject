package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.dto.request.TeacherRequest;
import peaksoft.dto.response.TeacherResponse;
import peaksoft.model.Teacher;
import peaksoft.service.CourseService;
import peaksoft.service.TeacherService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/teachers/{id}")
public class TeacherController {

    private final CourseService courseService;
    private final TeacherService teacherService;


    @PostMapping()
    public TeacherResponse saveTeacher(@RequestBody TeacherRequest teacherRequest, @PathVariable("id") Long id) {
        teacherRequest.setCourse(courseService.getCourseById(id));
        return teacherService.saveTeacher(teacherRequest, id);
    }

    @GetMapping()
    public List<TeacherResponse> getAllTeacher()  {
        return teacherService.getAllTeacher();
    }

    @GetMapping("/get/{teacherId}")
    public TeacherResponse getTeacherById(@PathVariable("teacherId") Long teacherId) {
        return teacherService.getTeacherById(teacherId);
    }

    @PatchMapping("/update/{teacherId}")
    public TeacherResponse updateTeacher( @RequestBody TeacherRequest teacherRequest,@PathVariable("teacherId") Long teacherId) {
        return teacherService.updateTeacher(teacherId, teacherRequest);
    }

    @DeleteMapping("/delete/{teacherId}")
    public void deleteTeacher(@PathVariable("teacherId") Long teacherId) {
        teacherService.deleteTeacher(teacherId);
    }


}


