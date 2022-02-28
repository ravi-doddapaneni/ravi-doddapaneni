package org.neobank.profile.service.impl;

import org.neobank.profile.dto.ProfileDetailsDto;
import org.neobank.profile.entities.Profile;
import org.neobank.profile.mappers.EntityDtoMapper;
import org.neobank.profile.repository.ProfileApplicationRepository;
import org.neobank.profile.service.ProfileApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfileApplicationServiceImpl implements ProfileApplicationService
{
    @Autowired
    ProfileApplicationRepository profileApplicationRepository;

    @Autowired
    EntityDtoMapper mapper;

    @Override
    public List<String> GetProfiles() {
        List<Profile> profiles = profileApplicationRepository.getProfileDetails();
        return profiles.stream().map(Profile::getLoginId).collect(Collectors.toList());
    }

    @Override
    public ProfileDetailsDto GetProfileDetails(String loginId) {
        List<Profile> profiles = profileApplicationRepository.getProfileDetails();
        Profile pf = profiles.stream().filter(p -> p.getLoginId().equals(loginId))
                             .findAny().orElse(null);
        return mapper.profileToProfileDetailsDto(pf);
    }

    @Override
    public boolean UpdateProfileDetails(String loginId, ProfileDetailsDto profileDetails) {
        return false;
    }
}
