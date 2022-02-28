package org.neobank.profile.controller.defination;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.neobank.profile.config.SwaggerConfiguration;
import org.neobank.profile.dto.ProfileDetailsDto;

import java.util.List;


@Api(value = "/profiles", tags = {SwaggerConfiguration.SERVICE_TAG})
public interface ProfileApplicationApi {

    @ApiOperation("A sample endpoint which returns all profiles in the bank that the user has access to")
    List<String> getProfiles();

    @ApiOperation(value = "Returns the profile details based on a valid customer ID")
    ProfileDetailsDto getProfileById(@ApiParam(value = "Login ID", required = true, defaultValue = "arauf")
                                             String loginId);

    @ApiOperation("Updates the profile of the customer based on the customer ID supplied")
    String updateProfileById(@ApiParam(value = "Login ID", required = true, defaultValue = "arauf")
                             String loginId,
                             ProfileDetailsDto profileDetails);
}