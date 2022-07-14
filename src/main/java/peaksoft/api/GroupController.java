package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.dto.request.GroupRequest;
import peaksoft.dto.response.GroupResponse;
import peaksoft.model.Group;
import peaksoft.service.CourseService;
import peaksoft.service.GroupService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/groups/{id}")
public class GroupController {

    private final CourseService courseService;
    private final GroupService groupService;

    @PostMapping()
    public GroupResponse saveGroup(@RequestBody GroupRequest groupRequest, @PathVariable("id") Long id) {
        groupRequest.setCourse(courseService.getCourseById(id));
        return groupService.saveGroup(groupRequest, id);
    }

    @GetMapping()
    public List<Group> getAllGroups() {
        return groupService.getAllGroups();
    }

    @GetMapping("/get/{groupId}")
    public Optional<Group> getGroupById(@PathVariable Long groupId) {
        return groupService.findById(groupId);
    }

    @PatchMapping("/update/{groupId}")
    public GroupResponse updateGroup(@PathVariable Long groupId, @RequestBody GroupRequest groupRequest) {
        return groupService.updateGroup(groupId, groupRequest);
    }

    @DeleteMapping("/delete/{groupId}")
    public void deleteGroup(@PathVariable Long groupId) {
        groupService.deleteGroup(groupId);
    }

}
