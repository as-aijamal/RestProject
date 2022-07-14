package peaksoft.service;

import peaksoft.dto.request.GroupRequest;
import peaksoft.dto.response.GroupResponse;
import peaksoft.model.Group;

import java.util.List;
import java.util.Optional;

public interface GroupService {

    GroupResponse saveGroup(GroupRequest groupRequest, Long id);

    Optional<Group> findById(Long id);

    List<Group> getAllGroups();

    Group getGroupById(Long id);

    void deleteGroup(Long id);

    GroupResponse updateGroup(Long id,GroupRequest groupRequest);
}
