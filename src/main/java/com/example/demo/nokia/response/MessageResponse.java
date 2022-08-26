package com.example.demo.nokia.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
public class MessageResponse {

    private String message;
    private HttpStatus httpStatus;

}
