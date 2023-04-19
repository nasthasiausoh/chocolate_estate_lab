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


    // method getting chocolates
    public List<Chocolate> getAllChocolates(){
        return chocolateRepository.findAll();
    }

    //method to get chocolate by id
    public Optional<Chocolate> getChocolateById(long id){
        return chocolateRepository.findById(id);
    }

    // add a new chocolate
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
