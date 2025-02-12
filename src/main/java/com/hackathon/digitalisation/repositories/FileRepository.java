package com.hackathon.digitalisation.repositories;

import com.hackathon.digitalisation.entitites.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<FileEntity,String> {
}
