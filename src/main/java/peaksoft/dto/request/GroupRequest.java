package peaksoft.dto.request;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import peaksoft.model.Company;
import peaksoft.model.Course;

@Getter
@Setter
public class GroupRequest {
    @NotNull

    private String groupName;
    private String dateOfStart;
    private String dateOfFinish;
    private Company company;
    private Course course;
}
