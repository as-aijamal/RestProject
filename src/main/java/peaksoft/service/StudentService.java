package peaksoft.service;

import peaksoft.dto.request.StudentRequest;
import peaksoft.dto.response.StudentResponse;
import peaksoft.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    StudentResponse saveStudent(StudentRequest studentRequest, Long id);

    Optional<Student> findById(Long id);

    List<Student> getAllStudents();

    Student getStudentById(Long id);

    void deleteStudent(Long id);

    StudentResponse updateStudent(Long id,StudentRequest studentRequest);
}

