package com.example.institute;

import com.example.institute.entity.Subject;
import com.example.institute.repository.ISubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    ISubjectRepository subjectRepository;

    @Override
    public void run(String... args) throws Exception {

        Subject math = new Subject("Mathematics");
        Subject literature = new Subject("Literature");
        Subject geography = new Subject("Geography");
        Subject history = new Subject("History");
        Subject biology = new Subject("Biology");
        Subject physicalEducation= new Subject("Physical Education");
        Subject physics = new Subject("Physics");
        Subject chemistry = new Subject("Chemistry");
        Subject music = new Subject("Music");
        Subject civic = new Subject("Civic");
        Subject it = new Subject("IT");
        Subject programming = new Subject("Programming");
        Subject drawing = new Subject("Drawing");
        Subject law = new Subject("Law");
        Subject accounting = new Subject("Accounting");
        Subject economy = new Subject("Economy");
        Subject philosophy = new Subject("Philosophy");

        subjectRepository.saveAll(Arrays.asList(math, literature, geography, history, biology,
                physicalEducation, physics, chemistry, music, civic, it, programming, drawing,
                law, accounting, economy, philosophy));
    }
}