package peaksoft.dto.request;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import peaksoft.model.Company;
import peaksoft.model.Course;


@Getter
@Setter
public class TeacherRequest {
    @NotNull

    private String firstName;
    private String lastName;
    private String email;
    private Course course;
    private Company company;

}
