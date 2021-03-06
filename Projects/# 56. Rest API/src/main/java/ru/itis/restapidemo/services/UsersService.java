package ru.itis.restapidemo.services;

import org.springframework.security.core.Authentication;
import ru.itis.restapidemo.dto.CommunityDto;
import ru.itis.restapidemo.dto.UserDto;
import ru.itis.restapidemo.forms.CommunityForUserForm;

import java.util.List;

public interface UsersService {
    List<CommunityDto> getCommunitiesByUser(Long userId);

    List<CommunityDto> addCommunityToUser(Long userId, CommunityForUserForm community);

    List<UserDto> getAllUsers();

    UserDto getUser(Authentication authentication, Long userId);
}
