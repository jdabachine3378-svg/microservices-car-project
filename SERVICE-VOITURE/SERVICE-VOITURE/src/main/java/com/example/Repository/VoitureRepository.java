package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.example.Entites.Voiture;
public interface VoitureRepository extends JpaRepository<Voiture, Long> {
    List<Voiture> findByClientId(Long clientId);
}
