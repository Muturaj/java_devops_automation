package com.example.demo.nokia.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
public class DataEntity {
    @JsonProperty("avatar")
    public String avatar;
    @JsonProperty("last_name")
    public String last_name;
    @JsonProperty("first_name")
    public String first_name;
    @JsonProperty("email")
    public String email;
    @JsonProperty("id")
    public int id;
}
