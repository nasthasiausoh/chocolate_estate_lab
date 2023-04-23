package com.bnta.chocolate.controllers;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.services.ChocolateService;
import com.bnta.chocolate.services.EstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estates")  // everything is going to have the route "estates"
public class EstateController {

    @Autowired
    EstateService estateService;



    @GetMapping       // This is an INDEX route
    public ResponseEntity<List<Estate>> getAllEstates(){
        List<Estate> estates = estateService.getAllEstates();
        return new ResponseEntity<>(estates, HttpStatus.OK);      // the reason why we have to new up a ResponseEntity<> is because in "public ResponseEntity<List<Estate>> getAllEstates(){"  we have actually created it yet, we are just naming a method that uses it ??
    }
//    Anna did the above slightly differently in the lab review, but it does the same thing.


    @GetMapping(value = "/{id}")       // This is a SHOW route
    public ResponseEntity<List<Estate>> getEstateById(@PathVariable Long id){
        return new ResponseEntity(estateService.findEstateById(id), HttpStatus.OK);      // the reason why we have to new up a ResponseEntity<> is because in "public ResponseEntity<List<Estate>> getAllEstates(){"  we have actually created it yet, we are just naming a method that uses it ??
    }

    @PostMapping
    public ResponseEntity<Estate> addNewEstate(@RequestBody Estate estate){
        Estate savedEstate = estateService.saveEstate(estate);
        return new ResponseEntity<>(savedEstate, HttpStatus.CREATED);
    }

}

