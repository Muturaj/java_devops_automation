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
public  class Employee {


    @JsonProperty("support")
    public SupportEntity support;
    @JsonProperty("data")
    public DataEntity data;
}
