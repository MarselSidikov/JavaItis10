package ru.itis.restapidemo.services;

import ru.itis.restapidemo.dto.CommunityDto;
import ru.itis.restapidemo.forms.CommunityForm;

import java.util.List;

public interface CommunitiesService {
    CommunityDto addCommunity(CommunityForm community);

    List<CommunityDto> getAll();

    void deleteCommunity(Long communityId);
}
