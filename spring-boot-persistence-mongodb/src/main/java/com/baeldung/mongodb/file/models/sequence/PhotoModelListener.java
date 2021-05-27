package com.baeldung.mongodb.file.models.sequence;

import com.baeldung.mongodb.file.models.Photo;
import com.baeldung.mongodb.services.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

@Component
public class PhotoModelListener extends AbstractMongoEventListener<Photo> {
    private SequenceGeneratorService sequenceGenerator;

    @Autowired
    public PhotoModelListener(SequenceGeneratorService sequenceGenerator) {
        this.sequenceGenerator = sequenceGenerator;
    }

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Photo> event) {
        if (event.getSource().getId() == null || event.getSource().getId() < 1) {
            event.getSource().setId(sequenceGenerator.generateSequence(Photo.SEQUENCE_NAME));
        }
    }
}
