package peaksoft.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.dto.request.TeacherRequest;
import peaksoft.dto.response.TeacherResponse;
import peaksoft.mapper.TeacherMapper;
import peaksoft.model.Course;
import peaksoft.model.Teacher;
import peaksoft.repository.CourseRepository;
import peaksoft.repository.TeacherRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;
    private final CourseRepository courseRepository;

    @Override
    public TeacherResponse saveTeacher(TeacherRequest teacherRequest, Long id) {
        return teacherMapper.viewTeacher(teacherRepository.save(teacherMapper.saveTeacher(teacherRequest, id)));
    }

    @Override
    public Teacher findById(Long id) {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> {
                    throw new RuntimeException();
                });
        return teacher;
    }

    @Override
    public List<TeacherResponse> getAllTeacher() {
        List<Teacher> teachers = teacherRepository.findAll().stream().toList();
        return teacherMapper.viewTeacher(teachers);
    }

    @Override
    public TeacherResponse getTeacherById(Long id) {
        Course course = courseRepository.findById(id).orElseThrow();
        return teacherMapper.viewTeacher(course.getTeacher());
    }

    @Override
    public void deleteTeacher(Long id) {
        Teacher teacher = teacherRepository.findById(id).get();
        teacherRepository.deleteById(id);
        teacherMapper.viewTeacher(teacher);

    }

    @Override
    public TeacherResponse updateTeacher(Long id, TeacherRequest teacherRequest) {
        Teacher teacher = teacherRepository.findById(id).get();
        teacherMapper.updateTeacher(teacher, teacherRequest);
        return teacherMapper.viewTeacher(teacherRepository.save(teacher));
    }
}
