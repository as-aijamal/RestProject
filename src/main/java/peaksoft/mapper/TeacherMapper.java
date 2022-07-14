package peaksoft.mapper;

import org.springframework.stereotype.Component;
import peaksoft.dto.request.TeacherRequest;
import peaksoft.dto.response.TeacherResponse;
import peaksoft.model.Teacher;
import peaksoft.repository.CourseRepository;
import peaksoft.repository.TeacherRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class TeacherMapper {

    private final TeacherRepository teacherRepository;
    private final CourseRepository courseRepository;

    public TeacherMapper(TeacherRepository teacherRepository, CourseRepository courseRepository) {
        this.teacherRepository = teacherRepository;
        this.courseRepository = courseRepository;
    }

    public Teacher saveTeacher(TeacherRequest teacherRequest, Long id) {
        Teacher teacher = new Teacher();
        teacher.setCourse(courseRepository.findById(id).get());
        teacher.setFirstName(teacherRequest.getFirstName());
        teacher.setLastName(teacherRequest.getLastName());
        teacher.getAuthInfo().setEmail(teacherRequest.getEmail());

        return teacher;
    }

    public TeacherResponse viewTeacher(Teacher teacher) {
        if (teacher == null) {
            return null;
        }
        TeacherResponse teacherResponse = new TeacherResponse();
        if (teacher.getId() != null) {
            teacherResponse.setId(String.valueOf(teacher.getId()));
        }
        teacherResponse.setFirstName(teacher.getFirstName());
        teacherResponse.setLastName(teacher.getLastName());
        teacherResponse.setEmail(teacher.getAuthInfo().getEmail());
        return teacherResponse;
    }

    public List<TeacherResponse> viewTeacher(List<Teacher> teachers) {
        List<TeacherResponse> teacherResponses = new ArrayList<>();
        for (Teacher teacher : teachers) {
            teacherResponses.add(viewTeacher(teacher));
        }
        return teacherResponses;
    }

    public void updateTeacher(Teacher teacher, TeacherRequest teacherRequest) {
        teacher.setFirstName(teacherRequest.getFirstName());
        teacher.setLastName(teacherRequest.getLastName());
        teacher.getAuthInfo().setEmail(teacherRequest.getEmail());
    }
}
