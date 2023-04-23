package com.bnta.chocolate.services;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.repositories.ChocolateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChocolateService {

    @Autowired
    EstateService estateService;

    @Autowired
    ChocolateRepository chocolateRepository;


//    Method for getting chocolates:
    public List<Chocolate> getAllChocolates(){
        return chocolateRepository.findAll();
    }


//    EXTENSION:

//    Method for finding chocolate by id (GET: SHOW)
    public Chocolate findChocolateById(Long id) {
        return chocolateRepository.findById(id).get();
    }
//    ANOTHER METHOD:
//    public Optional<Chocolate> getChocolateById(long id){
//        return chocolateRepository.findById(id);
//    }


//    Method for filtering chocolate with cocoa % > 60%
    public List<Chocolate> getChocolatesWithCocoaPercentageGreaterThan(int cocoaPercentage){
        return chocolateRepository.findByCocoaPercentageGreaterThan(cocoaPercentage);
    }





    // add a new chocolate (POST)
    public Chocolate addNewChocolate(Chocolate chocolate){
        chocolateRepository.save(chocolate);
        return chocolate;
    }

    // update a chocolate
    public Chocolate updateChocolate(Chocolate chocolate){
        chocolateRepository.save(chocolate);
        return chocolate;
    }


    // delete a chocolate
    public void deleteChocolate(long id){
        chocolateRepository.deleteById(id);
    }



//
}
