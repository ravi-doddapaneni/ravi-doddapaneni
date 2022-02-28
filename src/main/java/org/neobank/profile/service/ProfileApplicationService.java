package org.neobank.profile.service;

import org.neobank.profile.dto.ProfileDetailsDto;

import java.util.List;

public interface ProfileApplicationService
{
    List<String> GetProfiles();
    ProfileDetailsDto GetProfileDetails(String loginId);
    boolean UpdateProfileDetails(String loginId, ProfileDetailsDto profileDetails);
}
