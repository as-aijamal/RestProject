package peaksoft.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.dto.request.GroupRequest;
import peaksoft.dto.response.GroupResponse;
import peaksoft.mapper.GroupMapper;
import peaksoft.model.Group;
import peaksoft.repository.GroupRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;
    private final GroupMapper groupMapper;

    @Override
    public GroupResponse saveGroup(GroupRequest groupRequest, Long id) {
        return groupMapper.viewGroup(groupRepository.save(groupMapper.saveGroup(groupRequest, id)));
    }

    @Override
    public Optional<Group> findById(Long id) {
        return groupRepository.findById(id);
    }

    @Override
    public List<Group> getAllGroups() {
        List<Group> groupList = groupRepository.findAll();
        return groupList;
    }

    @Override
    public Group getGroupById(Long id) {
        return groupRepository.getById(id);
    }

    @Override
    public void deleteGroup(Long id) {
        Group group = groupRepository.findById(id).get();
        groupRepository.deleteById(id);
        groupMapper.viewGroup(group);
    }

    @Override
    public GroupResponse updateGroup(Long id, GroupRequest groupRequest) {
        Group group=groupRepository.findById(id).get();
        groupMapper.updateGroup(group,groupRequest);
        return groupMapper.viewGroup(groupRepository.save(group));
    }
}
