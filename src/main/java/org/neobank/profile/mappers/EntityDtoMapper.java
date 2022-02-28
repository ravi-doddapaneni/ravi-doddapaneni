package org.neobank.profile.mappers;

import org.mapstruct.Mapper;
import org.neobank.profile.dto.AddressDetailsDto;
import org.neobank.profile.dto.ProfileDetailsDto;
import org.neobank.profile.entities.Address;
import org.neobank.profile.entities.Profile;

@Mapper(componentModel = "spring")
public interface EntityDtoMapper
{
    AddressDetailsDto addressToAddressDto(Address address);
    ProfileDetailsDto profileToProfileDetailsDto(Profile profile);
}
