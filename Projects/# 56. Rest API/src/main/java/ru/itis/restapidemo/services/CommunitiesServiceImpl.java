package ru.itis.restapidemo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.restapidemo.dto.CommunityDto;
import ru.itis.restapidemo.forms.CommunityForm;
import ru.itis.restapidemo.models.Community;
import ru.itis.restapidemo.repositories.CommunitiesRepository;

import java.util.List;
import java.util.stream.Collectors;

import static ru.itis.restapidemo.dto.CommunityDto.from;

@Service
public class CommunitiesServiceImpl implements CommunitiesService {

    @Autowired
    private CommunitiesRepository communitiesRepository;

    @Transactional
    @Override
    public CommunityDto addCommunity(CommunityForm community) {
        Community newCommunity = Community.builder()
                .name(community.getName())
                .build();
        communitiesRepository.save(newCommunity);
        return from(newCommunity);
    }

    @Override
    public List<CommunityDto> getAll() {
        return communitiesRepository.findAll()
                .stream()
                .map(CommunityDto::from)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void deleteCommunity(Long communityId) {
        Community community = communitiesRepository.getOne(communityId);
        community.getMembers().clear();
        communitiesRepository.save(community);
        communitiesRepository.delete(community);
    }
}
