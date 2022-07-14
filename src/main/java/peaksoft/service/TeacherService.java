package peaksoft.service;

import peaksoft.dto.request.TeacherRequest;
import peaksoft.dto.response.TeacherResponse;
import peaksoft.model.Teacher;

import java.util.List;

public interface TeacherService {

    TeacherResponse saveTeacher(TeacherRequest teacherRequest, Long id);

    Teacher findById(Long id);

    List<TeacherResponse> getAllTeacher();

    TeacherResponse getTeacherById(Long id);

    void deleteTeacher(Long id);

    TeacherResponse updateTeacher(Long id,TeacherRequest teacherRequest);
}
