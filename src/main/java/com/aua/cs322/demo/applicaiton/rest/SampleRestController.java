package com.aua.cs322.demo.applicaiton.rest;

import com.aua.cs322.demo.applicaiton.dto.RequestDto;
import com.aua.cs322.demo.applicaiton.dto.ResponseDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class SampleRestController {

    @GetMapping("/hello")
    public String sayHello(@RequestParam("name") String name){
        return "Hello "+ name;
    }

    @PostMapping(value = "/json", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDto getJson(@RequestBody RequestDto data){
        return extractFirstAndLastNames(data.getFullName());
    }

    private ResponseDto extractFirstAndLastNames(String fullName){
        return new ResponseDto(fullName.split(" ")[0],fullName.split(" ")[1]);
    }
}
