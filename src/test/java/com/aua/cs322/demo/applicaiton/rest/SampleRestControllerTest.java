package com.aua.cs322.demo.applicaiton.rest;

import com.aua.cs322.demo.applicaiton.dto.RequestDto;
import com.aua.cs322.demo.applicaiton.dto.ResponseDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = SampleRestController.class)
class SampleRestControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void sayHello() throws Exception {

        //run get request
        mockMvc.perform(get("/api/hello?name=Vahe"))
                //check the result HTTP status code to be 200(OK)
                .andExpect(status().isOk())
                //Expect to return the name given in the params
                .andExpect(content().string("Hello Vahe"));
    }

    @Test
    void sayHelloNoParamGiven() throws Exception {

        //run get request
        mockMvc.perform(get("/api/hello"))
                //check the result HTTP status code to be 400(Bad request)
                .andExpect(status().isBadRequest());
    }

    @Test
    void getJson() throws Exception {

        RequestDto request = new RequestDto();
        request.setFullName("Vahe Momjyan");

        ResponseDto response = new ResponseDto("Vahe","Momjyan");
        //run post request
        mockMvc.perform(post("/api/json")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(request)).characterEncoding("UTF-8"))
                //check the result HTTP status code to be 200(OK)
                .andExpect(status().isOk())
                //Expect to return the name given in the params
                .andExpect(content().json(objectMapper.writeValueAsString(response)));
    }

    @Test
    void getJsonNull() throws Exception {

        RequestDto request = new RequestDto();
        request.setFullName("");

        //run post request
        mockMvc.perform(post("/api/json")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(request)))
                //check the result HTTP status code to be 200(OK)
                .andExpect(status().isBadRequest());
    }
}