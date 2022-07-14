package peaksoft.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.dto.request.StudentRequest;
import peaksoft.dto.response.StudentResponse;
import peaksoft.mapper.StudentMapper;
import peaksoft.model.Student;
import peaksoft.repository.StudentRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    @Override
    public StudentResponse saveStudent(StudentRequest studentRequest, Long id) {
        return studentMapper.viewStudent(studentRepository.save(studentMapper.saveStudent(studentRequest, id)));
    }

    @Override
    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> studentList = studentRepository.findAll();
        return studentList;
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.getById(id);
    }

    @Override
    public void deleteStudent(Long id) {
        Student student = studentRepository.findById(id).get();
        studentRepository.deleteById(id);
        studentMapper.viewStudent(student);
    }

    @Override
    public StudentResponse updateStudent(Long id, StudentRequest studentRequest) {
        Student student=studentRepository.findById(id).get();
        studentMapper.updateStudent(student,studentRequest);
        return studentMapper.viewStudent(studentRepository.save(student));
    }
}
