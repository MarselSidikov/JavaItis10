package ru.itis.restapidemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.itis.restapidemo.dto.CommunitiesResponseDto;
import ru.itis.restapidemo.dto.CommunityResponseDto;
import ru.itis.restapidemo.forms.CommunityForm;
import ru.itis.restapidemo.services.CommunitiesService;

@RestController
public class CommunitiesController {

    @Autowired
    private CommunitiesService communitiesService;

    @PostMapping("/communities")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<CommunityResponseDto> addCommunity(@RequestHeader("token") String token, @RequestBody CommunityForm community) {
        CommunityResponseDto responseBody = CommunityResponseDto.builder()
                .data(communitiesService.addCommunity(community))
                .build();

        return ResponseEntity.status(201)
                .body(responseBody);
    }

    @GetMapping("/communities")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<CommunitiesResponseDto> getAll(@RequestHeader("token") String token) {
        CommunitiesResponseDto responseBody = CommunitiesResponseDto.builder()
                .data(communitiesService.getAll())
                .build();

        return ResponseEntity.ok(responseBody);
    }

    @DeleteMapping("/communities/{community-id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<Object> deleteCommunity(@RequestHeader("token") String token, @PathVariable("community-id") Long communityId) {
        communitiesService.deleteCommunity(communityId);
        return ResponseEntity.ok().build();
    }
}
