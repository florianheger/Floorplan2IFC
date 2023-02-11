package de.fheger.floorplan2ifc.temp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ModelTestMain {
    @Autowired
    public ModelTestMain(PersonRepository personRepository) {
        Person person = new Person("Peter");
        personRepository.save(person);
    }
}
