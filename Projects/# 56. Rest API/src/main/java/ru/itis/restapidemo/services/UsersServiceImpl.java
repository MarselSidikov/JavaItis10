package ru.itis.restapidemo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.restapidemo.dto.CommunityDto;
import ru.itis.restapidemo.dto.UserDto;
import ru.itis.restapidemo.forms.CommunityForUserForm;
import ru.itis.restapidemo.models.Community;
import ru.itis.restapidemo.models.User;
import ru.itis.restapidemo.repositories.CommunitiesRepository;
import ru.itis.restapidemo.repositories.UsersRepository;

import java.util.List;
import java.util.stream.Collectors;

import static ru.itis.restapidemo.dto.CommunityDto.from;

@Component
public class UsersServiceImpl implements UsersService {

    @Autowired
    private CommunitiesRepository communitiesRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public List<CommunityDto> getCommunitiesByUser(Long userId) {
        User member = usersRepository.getOne(userId);
        List<Community> communities = communitiesRepository.findAllByMembersContaining(member);
        return from(communities);
    }

    @Transactional
    @Override
    public List<CommunityDto> addCommunityToUser(Long userId, CommunityForUserForm communityForm) {
        User member = usersRepository.getOne(userId);
        Community community = communitiesRepository.getOne(communityForm.getId());
        community.getMembers().add(member);
        communitiesRepository.save(community);
        
        List<Community> communities = communitiesRepository.findAllByMembersContaining(member);
        return from(communities);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return usersRepository.findAll().stream()
                .map(UserDto::from)
                .collect(Collectors.toList());
    }
}
