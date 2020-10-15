package com.aua.cs322.demo.applicaiton.rest;

import com.aua.cs322.demo.applicaiton.dto.RequestDto;
import com.aua.cs322.demo.applicaiton.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class SampleRestController {

    @GetMapping("/hello")
    public ResponseEntity<String> sayHello(@RequestParam("name") String name) {
        if (StringUtils.isEmpty(name)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok("Hello " + name);
    }

    @PostMapping(value = "/json", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDto> getJson(@RequestBody RequestDto data) {
        try {
            return ResponseEntity.ok(extractFirstAndLastNames(data.getFullName()));
        }catch (IllegalArgumentException ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    private ResponseDto extractFirstAndLastNames(String fullName) throws IllegalArgumentException {
        String[] splitValues = fullName.split(" ");
        if (splitValues.length < 2) {
            throw new IllegalArgumentException("Full name should contain at least two words");
        }
        return new ResponseDto(splitValues[0], splitValues[1]);
    }
}
