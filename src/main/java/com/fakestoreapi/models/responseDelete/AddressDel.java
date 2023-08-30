package com.fakestoreapi.models.responseDelete;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressDel {

    @JsonProperty("geolocation")
    public GeolocationDel geolocation;

    @JsonProperty("city")
    public String city;

    @JsonProperty("street")
    public String street;

    @JsonProperty("number")
    public Integer number;

    @JsonProperty("zipcode")
    public String zipcode;
}
