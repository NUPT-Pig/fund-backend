package org.nuptpig.fundbackend.controller;

import org.nuptpig.fundcommon.Response.CommonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/login")
public class LoginController {
    @PostMapping(path = "")
    public ResponseEntity login(){
        return CommonResponse.ok(HttpStatus.OK);
    }
}
