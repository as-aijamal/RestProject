package peaksoft.mapper;

import org.springframework.stereotype.Component;
import peaksoft.dto.request.StudentRequest;
import peaksoft.dto.response.StudentResponse;
import peaksoft.enumPackage.Authority;
import peaksoft.model.AuthInfo;
import peaksoft.model.Student;
import peaksoft.repository.GroupRepository;
import peaksoft.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentMapper {

    private final GroupRepository groupRepository;
    private final StudentRepository studentRepository;

    public StudentMapper(GroupRepository groupRepository, StudentRepository studentRepository) {
        this.groupRepository = groupRepository;
        this.studentRepository = studentRepository;
    }

    public Student saveStudent(StudentRequest studentRequest, Long id) {
        Student student = new Student();
        student.setGroups(groupRepository.findById(id).get());
        student.setFirstName(studentRequest.getFirstName());
        student.setLastName(studentRequest.getLastName());
        student.setStudyFormat(studentRequest.getStudyFormat());

        AuthInfo authInfo=new AuthInfo();
        authInfo.setEmail(studentRequest.getEmail());
        authInfo.setPassword(studentRequest.getPassword());
        authInfo.setAuthority(Authority.STUDENT);
        student.setAuthInfo(authInfo);
        return student;
    }

    public StudentResponse viewStudent(Student student) {
        if (student == null) {
            return null;
        }
        StudentResponse studentResponse = new StudentResponse();
        if (student.getId() != null) {
            studentResponse.setId(String.valueOf(student.getId()));
        }
        studentResponse.setFirstName(student.getFirstName());
        studentResponse.setEmail(student.getAuthInfo().getEmail());
        return studentResponse;
    }

    public List<StudentResponse> viewStudents(List<Student> students) {
        List<StudentResponse> studentResponses = new ArrayList<>();
        for (Student student : students) {
            studentResponses.add(viewStudent(student));
        }
        return studentResponses;
    }

    public void updateStudent(Student student, StudentRequest studentRequest) {
        student.setFirstName(studentRequest.getFirstName());
        student.setLastName(studentRequest.getLastName());
        student.getAuthInfo().setEmail(studentRequest.getEmail());
        student.setStudyFormat(studentRequest.getStudyFormat());
    }
}
