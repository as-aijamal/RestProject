package peaksoft.mapper;

import org.springframework.stereotype.Component;
import peaksoft.dto.request.GroupRequest;
import peaksoft.dto.response.GroupResponse;
import peaksoft.model.Group;
import peaksoft.repository.CompanyRepository;
import peaksoft.repository.CourseRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class GroupMapper {

    private final CourseRepository courseRepository;

    public GroupMapper(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Group saveGroup(GroupRequest groupRequest, Long id) {
        Group group = new Group();
        group.setCourses(courseRepository.findById(id).get());
        group.setGroupName(groupRequest.getGroupName());
        group.setDateOfStart(groupRequest.getDateOfStart());
        group.setDateOfFinish(groupRequest.getDateOfFinish());
        return group;
    }

    public GroupResponse viewGroup(Group group) {
        if (group == null) {
            return null;
        }
        GroupResponse groupResponse = new GroupResponse();
        if (group.getId() != null) {
            groupResponse.setId(String.valueOf(group.getId()));
        }
        groupResponse.setGroupName(group.getGroupName());
        groupResponse.setDateOfStart(group.getDateOfStart());
        groupResponse.setDateOfFinish(group.getDateOfFinish());
        return groupResponse;
    }

    public List<GroupResponse> viewGroups(List<Group> groups) {
        List<GroupResponse> groupResponses = new ArrayList<>();
        for (Group group : groups) {
            groupResponses.add(viewGroup(group));
        }
        return groupResponses;
    }

    public void updateGroup(Group group, GroupRequest groupRequest) {
        group.setGroupName(groupRequest.getGroupName());
        group.setDateOfStart(groupRequest.getDateOfStart());
        group.setDateOfFinish(groupRequest.getDateOfFinish());
    }
}
