package com.bnta.chocolate.controllers;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.services.ChocolateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chocolates")
public class ChocolateController {

    @Autowired
    ChocolateService chocolateService;


//  INDEX: GET /chocolates
    @GetMapping
    public ResponseEntity<List<Chocolate>> getAllChocolates(){
        List<Chocolate> chocolates = chocolateService.getAllChocolates();
        return new ResponseEntity<>(chocolates, HttpStatus.OK);
    }


// SHOW: GET /chocolates/id
    @GetMapping(value = "/{id}")       // This is a SHOW route
    public ResponseEntity<List<Chocolate>> getChocolateById(@PathVariable Long id){
        return new ResponseEntity(chocolateService.findChocolateById(id), HttpStatus.OK);      // the reason why we have to new up a ResponseEntity<> is because in "public ResponseEntity<List<Estate>> getAllEstates(){"  we have actually created it yet, we are just naming a method that uses it ??
    }



//    Handles following:
//    * INDEX: GET /chocolates
//    * GET /chocolates?cocoaPercentage=69
    @GetMapping
    public ResponseEntity<List<Chocolate>> getAllChocolatesAndFilters(
            @RequestParam(required = false, name = "cocoaPercentage") Integer cocoaPercentage
    ){
//        GET /chocolates?cocoaPercentage=69
        if(cocoaPercentage != null){
            return new ResponseEntity<>(chocolateService.getChocolatesWithCocoaPercentageGreaterThan(cocoaPercentage), HttpStatus.OK);
        }
//        GET /chocolates
        return new ResponseEntity<>(chocolateService.getAllChocolates(), HttpStatus.OK);
    }


// CREATE: POST /chocolates
    @PostMapping
    public ResponseEntity<Chocolate> addNewChocolate(@RequestBody Chocolate chocolate){
        chocolateService.addNewChocolate(chocolate);
        return new ResponseEntity<>(chocolate, HttpStatus.CREATED);
    }

}
