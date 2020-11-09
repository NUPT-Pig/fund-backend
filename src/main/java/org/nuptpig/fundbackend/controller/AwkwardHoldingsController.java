package org.nuptpig.fundbackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/awkward_holdings")
public class AwkwardHoldingsController {

    @GetMapping("")
    public String listAwkwardHoldings(){
        return "test";
    }
}
