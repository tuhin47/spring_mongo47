package com.tuhin47.mongo;

import com.tuhin47.mongo.domain.Biller;
import com.tuhin47.mongo.domain.BillingParticular;
import com.tuhin47.mongo.repository.BillerRepository;
import com.tuhin47.mongo.repository.BillingParticularRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class MongoApplication implements CommandLineRunner {

    @Autowired
    private BillerRepository billerRepository;

    @Autowired
    private BillingParticularRepository billingParticularRepository;

    public static void main(String[] args) {
        SpringApplication.run(MongoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

       /* billerRepository.deleteAll();
        List<Biller> billers = Arrays.asList(
                new Biller().setName("Biller1_11").setCategory(1).setSubcategory(1),
                new Biller().setName("Biller2_11").setCategory(1).setSubcategory(1),
                new Biller().setName("Biller2_12").setCategory(1).setSubcategory(2),
                new Biller().setName("Biller2_22").setCategory(2).setSubcategory(1)

        );
        billerRepository.saveAll(billers);*/

        /*billingParticularRepository.deleteAll();

        List<BillingParticular> particulars = Arrays.asList(
                BillingParticular.builder().code(1).title("Registration").defaultValue(5000.0).build(),
                BillingParticular.builder().code(2).title("Hall Fee").defaultValue(2000.0).build(),
                BillingParticular.builder().code(3).title("Tuition Fee").defaultValue(8000.0).build(),
                BillingParticular.builder().code(4).title("Development Fee").defaultValue(1000.0).build()
        );

        billingParticularRepository.saveAll(particulars);*/


    }
}
