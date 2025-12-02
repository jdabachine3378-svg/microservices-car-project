package com.example.Service;

import org.springframework.stereotype.Service;
import com.example.Entites.Voiture;
import com.example.Repository.VoitureRepository;

@Service
public class VoitureService {

    private final VoitureRepository voitureRepository;

    public VoitureService(VoitureRepository voitureRepository) {
        this.voitureRepository = voitureRepository;
    }

    public Voiture enregistrerVoiture(Voiture voiture) {
        return voitureRepository.save(voiture);
    }
}
