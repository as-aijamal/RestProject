package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.dto.request.StudentRequest;
import peaksoft.dto.response.StudentResponse;
import peaksoft.model.Student;
import peaksoft.service.GroupService;
import peaksoft.service.StudentService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students/{id}")
public class StudentController {

    private final GroupService groupService;
    private final StudentService studentService;

    @PostMapping()
    public StudentResponse saveStudent(@RequestBody StudentRequest studentRequest, @PathVariable("id") Long id) {
        studentRequest.setGroup(groupService.getGroupById(id));
        return studentService.saveStudent(studentRequest, id);
    }

    @GetMapping()
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/get/{studentId}")
    public Optional<Student> getStudentById(@PathVariable Long studentId) {
        return studentService.findById(studentId);
    }

    @PatchMapping("/update/{studentId}")
    public StudentResponse updateStudent(@PathVariable Long studentId, @RequestBody StudentRequest studentRequest) {
        return studentService.updateStudent(studentId, studentRequest);
    }

    @DeleteMapping("/delete/{studentId}")
    public void deleteStudent(@PathVariable Long studentId) {
        studentService.deleteStudent(studentId);
    }
}
