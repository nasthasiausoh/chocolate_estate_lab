package com.bnta.chocolate.services;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.repositories.ChocolateRepository;
import com.bnta.chocolate.repositories.EstateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstateService {

    @Autowired
    EstateRepository estateRepository;


    // method getting estates
    public List<Estate> getAllEstates(){
        return estateRepository.findAll();
    }

    //method to get estate by id
    public Optional<Estate> getEstateById(long id){
        return estateRepository.findById(id);
    }

    public Estate saveEstate(Estate estate){
        estateRepository.save(estate);
        return estate;
    }

//    // add a new estate
//    public Estate addNewEstate(Estate estate){
//        estateRepository.save(estate);
//        return estate;
//    }



    // update a estate
    public Estate updateEstate(Estate estate){
        estateRepository.save(estate);
        return estate;
    }


    // delete a estate
    public void deleteEstate(long id){
        estateRepository.deleteById(id);
    }

//
}
