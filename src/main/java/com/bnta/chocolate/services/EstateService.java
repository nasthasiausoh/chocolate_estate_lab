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

//  we do not want to be instantiating our repositories anywhere other than our service layers as this is where our business logic is handled
//  and we can also instantiate them in our data loader .

    // method getting estates
    public List<Estate> getAllEstates(){
        return estateRepository.findAll();
    }


    public Estate saveEstate(Estate estate){
        estateRepository.save(estate);
        return estate;
    }



// EXTENSION:

    //method to get estate by id
//    public Optional<Estate> getEstateById(long id){
//        return estateRepository.findById(id);
//    }
//    ANOTHER METHOD:
    public Estate findEstateById(Long id) {
        return estateRepository.findById(id).get();
    }

//    method to add a new estate:
//    public Estate addNewEstate(Estate estate){
//        estateRepository.save(estate);
//        return estate;
//    }


    // update a estate
    public Estate updateEstate(Estate estate){
        estateRepository.save(estate);
        return estate;
    }


    //    Delete a estate by id:
    public void deleteEstate(long id){
        estateRepository.deleteById(id);
    }




//
}
