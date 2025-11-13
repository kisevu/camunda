package com.kevin.ameda.Camunda.controller;

import io.camunda.zeebe.client.ZeebeClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: kev.Ameda
 */
@RestController
public class KevController {

    private final ZeebeClient zeebeClient;

    public KevController(ZeebeClient zeebeClient) {
        this.zeebeClient = zeebeClient;
    }

    @GetMapping("/trial")
    public ResponseEntity<?> trial(){
        return new ResponseEntity<>(zeebeClient.newActivateJobsCommand().jobType("test"),
                HttpStatus.OK);
    }


}
