package peaksoft.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GroupResponse {

    private String id;
    private String groupName;
    private String dateOfStart;
    private String dateOfFinish;
}
