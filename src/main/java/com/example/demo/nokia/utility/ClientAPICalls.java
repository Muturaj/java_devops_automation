package com.example.demo.nokia.utility;

import com.example.demo.nokia.dto.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@RequiredArgsConstructor
@Component
public class ClientAPICalls {
     @Qualifier(value = "webClient")
     private final WebClient webClient;

    @Qualifier(value = "webClientDisablessl")
    private final WebClient webClientDisable;


    public  Employee getEmployeeinfo() {

       return webClient.get()
                .uri("https://reqres.in/api/users/2")
                .header(MediaType.APPLICATION_JSON_VALUE)
                //.headers(h->h.setBearerAuth("ff"))
                .retrieve()
                .toEntity(Employee.class)
                .map(s->s.getBody())
                .block();

    }

    public  Employee getEmployeeinfoDisable() {

        System.out.println("called");
        return webClientDisable.get()
                .uri("https://reqres.in/api/users/2")
                .header(MediaType.APPLICATION_JSON_VALUE)
                //.headers(h->h.setBearerAuth("ff"))
                .retrieve()
                .toEntity(Employee.class)
                .map(s->s.getBody())
                .block();

    }
}
