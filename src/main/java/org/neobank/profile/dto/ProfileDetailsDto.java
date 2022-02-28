package org.neobank.profile.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.Example;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;


import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ApiModel(value = "Profile Details")
public class ProfileDetailsDto {
    @ApiModelProperty(value = "Login ID", example="7000320")
    @NonNull
    String loginId;
    @ApiModelProperty(value = "First Name", example="Ali")
    String firstName;
    @ApiModelProperty(value = "Last Name", example="Reza")
    String lastName;
    @ApiModelProperty(value = "Date Of Birth", example="1990-03-23")
    Date dateOfBirth;
    AddressDetailsDto address;
}
