package peaksoft.dto.request;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import peaksoft.enumPackage.StudyFormat;
import peaksoft.model.Group;

@Getter
@Setter
public class StudentRequest {
    @NotNull
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private StudyFormat studyFormat;
    private Group group;

}
