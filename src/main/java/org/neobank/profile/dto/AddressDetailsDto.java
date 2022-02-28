package org.neobank.profile.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ApiModel(value = "Address Details")
public class AddressDetailsDto
{
    @ApiModelProperty(example = "Verdun Tower")
    String addressLineOne;
    @ApiModelProperty(example = "7775 King Fahd Rd")
    String street;
    @ApiModelProperty(example = "Riyadh")
    String city;
    @ApiModelProperty(example = "12212")
    @NonNull
    String Postcode;
    @ApiModelProperty(example = "Kingdom of Saudi Arabia")
    String Country;
}

