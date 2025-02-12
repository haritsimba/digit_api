package com.hackathon.digitalisation.repositories;

import com.hackathon.digitalisation.entitites.Message;
import com.hackathon.digitalisation.enums.RecipientType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

    @Query(value = "SELECT * FROM messages WHERE creation < :time AND recipient_id = :recipientId AND recipient_type = :recipientType ORDER BY creation DESC LIMIT 50", nativeQuery = true)
    List<Message> findTop50MessagesBefore(@Param("time") Date time, @Param("recipientId") Long recipientId,@Param("recipientType") String recipientType);
}
