package com.hackathon.digitalisation.services;

import com.hackathon.digitalisation.NotificationService;
import com.hackathon.digitalisation.dtos.CreateEvenementIn;
import com.hackathon.digitalisation.entitites.Evenement;
import com.hackathon.digitalisation.repositories.EvenementRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class EvenementService {
    EvenementRepository evenementRepository;
    NotificationService notificationService;

    public Evenement createEvenement(CreateEvenementIn evenementInfo) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd:MM:yyyy");
        Date start = dateFormat.parse(evenementInfo.start());
        Date end = dateFormat.parse(evenementInfo.end());

        Evenement evenement = new Evenement();
        evenement.setEnd(end);
        evenement.setStart(start);
        evenement.setTitle(evenementInfo.title());
        evenement.setContent(evenementInfo.content());
        evenement.setAttachmentLink(evenementInfo.attachmentLink());

        return evenementRepository.save(evenement);
    }

    public List<Evenement> getAllEvenements(){
        return evenementRepository.findAll();
    }
}
