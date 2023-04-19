package com.bnta.chocolate.components;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.repositories.ChocolateRepository;
import com.bnta.chocolate.repositories.EstateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.lang.reflect.Executable;
import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    ChocolateRepository chocolateRepository;

    @Autowired
    EstateRepository estateRepository;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        Estate estate1 = new Estate("Willows Chocolate", "Colombia");
        Chocolate chocolate1 = new Chocolate("Bounty", 35, estate1);

        Estate estate2 = new Estate("ChocoLand", "Brazil");
        Chocolate chocolate2 = new Chocolate("Dark Chocolate", 90, estate2);

        Estate estate3 = new Estate("Cocoas", "Spain");
        Chocolate chocolate3 = new Chocolate("MilkyBar", 4, estate3);

        estateRepository.save(estate1);
        chocolateRepository.save(chocolate1);

        estateRepository.save(estate2);
        chocolateRepository.save(chocolate2);

        estateRepository.save(estate3);
        chocolateRepository.save(chocolate3);
    }




}
