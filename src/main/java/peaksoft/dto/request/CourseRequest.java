package peaksoft.dto.request;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import peaksoft.model.Company;

@Getter
@Setter
public class CourseRequest {
    @NotNull

    private String courseName;
    private String duration;
    private Company company;
}
