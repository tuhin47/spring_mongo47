package com.tuhin47.mongo;

import com.tuhin47.mongo.domain.*;
import com.tuhin47.mongo.repository.BillerRepository;
import com.tuhin47.mongo.repository.BillingParticularRepository;
import com.tuhin47.mongo.repository.TemplateDocumentRepository;
import com.tuhin47.mongo.repository.TemplateStructureRepository;
import com.tuhin47.mongo.util.KeyGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class MongoApplication implements CommandLineRunner {

    @Autowired
    private BillerRepository billerRepository;

    @Autowired
    private BillingParticularRepository billingParticularRepository;

    @Autowired
    private TemplateStructureRepository templateStructureRepository;

    @Autowired
    private TemplateDocumentRepository templateDocumentRepository;

    public static void main(String[] args) {
        SpringApplication.run(MongoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        billerRepository.deleteAll();
        List<Biller> billers = Arrays.asList(
                new Biller().setName("Biller1_11").setCategory(1).setSubcategory(1),
                new Biller().setName("Biller2_11").setCategory(1).setSubcategory(1),
                new Biller().setName("Biller2_12").setCategory(1).setSubcategory(2),
                new Biller().setName("Biller2_22").setCategory(2).setSubcategory(1)

        );
        billerRepository.saveAll(billers);

        billingParticularRepository.deleteAll();

        List<BillingParticular> BillingParticulars = Arrays.asList(
                BillingParticular.builder().code(1).title("Registration").defaultValue(5000.0).build(),
                BillingParticular.builder().code(2).title("Hall Fee").defaultValue(2000.0).build(),
                BillingParticular.builder().code(3).title("Tuition Fee").defaultValue(8000.0).build(),
                BillingParticular.builder().code(4).title("Development Fee").defaultValue(1000.0).build()
        );

        billingParticularRepository.saveAll(BillingParticulars);

        templateStructureRepository.deleteAll();

        List<TemplateParticular> particulars = Arrays.asList(
                TemplateParticular.builder().title("Student Id").titleKey(KeyGenerator.getKey("Student Id")).columnType("unique").searchable(true).sampleValue("123").build(),
                TemplateParticular.builder().title("Campus").titleKey(KeyGenerator.getKey("Campus")).columnType("generic").searchable(true).sampleValue("Dhaka").build(),
                TemplateParticular.builder().title("Date").titleKey(KeyGenerator.getKey("Date")).columnType("generic").searchable(true).sampleValue("01/03/2021").build()
        );

        TemplateStructure templateStructure = TemplateStructure.builder().category(1).subcategory(1).templateParticulars(particulars).build();

        templateStructureRepository.save(templateStructure);

        TemplateStructure template = templateStructureRepository.findAll().get(0);
        Biller biller = billerRepository.findAll().get(0);
        biller.setTemplateStructure(template);

        billerRepository.save(biller);

        templateDocumentRepository.deleteAll();

        List<TemplateParticular> templateParticulars = biller.getTemplateStructure().getTemplateParticulars();
        Map<String, Object> values = new HashMap<>();
        int i = 0;
        for (TemplateParticular part : templateParticulars) {
            values.put(part.getTitleKey(), "" + (++i));
        }

        List<BillingParticular> billingParticulars = billingParticularRepository.findAll();

        for (int j = 0; j < billingParticulars.size(); j++) {
            if (j % 2 == 1) {
                BillingParticular bp = billingParticulars.get(j);
                values.put(KeyGenerator.getKey(bp.getTitle()), bp.getDefaultValue());
            }
        }
        templateDocumentRepository.save(TemplateDocument.builder().data(values).build());


    }
}
