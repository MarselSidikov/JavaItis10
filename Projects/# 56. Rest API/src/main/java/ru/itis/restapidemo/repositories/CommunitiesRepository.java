package ru.itis.restapidemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.restapidemo.models.Community;
import ru.itis.restapidemo.models.User;

import java.util.List;

public interface CommunitiesRepository extends JpaRepository<Community, Long> {
    List<Community> findAllByMembersContaining(User member);
}
