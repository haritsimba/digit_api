package com.hackathon.digitalisation.repositories;

import com.hackathon.digitalisation.entitites.Evenement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvenementRepository extends JpaRepository<Evenement,Long> {
}
