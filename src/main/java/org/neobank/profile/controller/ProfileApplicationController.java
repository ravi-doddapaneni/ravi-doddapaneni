package org.neobank.profile.controller;

import lombok.extern.flogger.Flogger;
import org.neobank.profile.controller.defination.ProfileApplicationApi;
import org.neobank.profile.dto.ProfileDetailsDto;
import org.neobank.profile.service.ProfileApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Flogger
@RestController
@RequestMapping("/api/v1/profiles")
public class ProfileApplicationController implements ProfileApplicationApi
{
    @Autowired
    ProfileApplicationService profileApplicationService;

    @Override
    @GetMapping("/{loginId}")
    public ProfileDetailsDto getProfileById(@PathVariable String loginId)
    {
        return profileApplicationService.GetProfileDetails(loginId);
    }

    @Override
    @GetMapping("")
    public List<String> getProfiles()
    {
        return profileApplicationService.GetProfiles();
    }

    @Override
    @PutMapping("/{loginId}")
    public String updateProfileById(@PathVariable String loginId, @RequestBody ProfileDetailsDto profileDetails)
    {
        var success = profileApplicationService.UpdateProfileDetails(loginId, profileDetails);
        if (success)
            return "profile updated successfully";
        else
            return "profile update failed";
    }
}
