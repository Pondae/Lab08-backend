package se331.lab.rest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import se331.lab.rest.entity.Organizer;
import se331.lab.rest.repository.OrganizerRepository;

@Component
public class InitAppOrganizer implements ApplicationListener<ApplicationReadyEvent> {
    @Autowired
    OrganizerRepository organizerRepository;
    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        organizerRepository.save(Organizer.builder()
                .name("AAAA")
                .address("A")
                .build());
        organizerRepository.save(Organizer.builder()
                .name("BBBB")
                .address("B")
                .build());
        organizerRepository.save(Organizer.builder()
                .name("CCCC")
                .address("C")
                .build());
        organizerRepository.save(Organizer.builder()
                .name("DDDD")
                .address("D")
                .build());
        organizerRepository.save(Organizer.builder()
                .name("EEEE")
                .address("E")
                .build());
        organizerRepository.save(Organizer.builder()
                .name("FFFF")
                .address("FF")
                .build());
    }
}
