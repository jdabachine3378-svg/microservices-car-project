package com.example.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.Repository.VoitureRepository;
import com.example.Feign.ClientService;
import com.example.Entites.Voiture;
import com.example.Entites.Client;
import com.example.Service.VoitureService;
import java.util.List;



@RestController
public class VoitureController {

    @Autowired
    private VoitureRepository voitureRepository;

    @Autowired
    private VoitureService voitureService;

    @Autowired
    private ClientService clientService;

    // GET ALL
    @GetMapping("/voitures")
    public ResponseEntity<List<Voiture>> findAll() {
        try {
            List<Voiture> voitures = voitureRepository.findAll();
            return ResponseEntity.ok(voitures);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // GET BY ID
    @GetMapping("/voitures/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        try {
            Voiture voiture = voitureRepository.findById(id)
                    .orElseThrow(() -> new Exception("Voiture Introuvable"));

            voiture.setClient(clientService.clientById(voiture.getClientId()));

            return ResponseEntity.ok(voiture);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Voiture not found with ID: " + id);
        }
    }

    // FIND BY CLIENT
    @GetMapping("/voitures/client/{id}")
    public ResponseEntity<List<Voiture>> findByClient(@PathVariable Long id) {
        try {
            clientService.clientById(id);

            List<Voiture> voitures = voitureRepository.findByClientId(id);
            return ResponseEntity.ok(voitures);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // SAVE
    @PostMapping("/voitures/{clientId}")
    public ResponseEntity<Object> save(@PathVariable Long clientId,
                                       @RequestBody Voiture voiture) {

        try {
            Client client = clientService.clientById(clientId);

            voiture.setClientId(clientId);
            voiture.setClient(client);

            Voiture saved = voitureService.enregistrerVoiture(voiture);

            return ResponseEntity.ok(saved);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Client not found with ID: " + clientId);
        }
    }

    // UPDATE
    @PutMapping("/voitures/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id,
                                         @RequestBody Voiture updatedVoiture) {

        try {
            Voiture existing = voitureRepository.findById(id)
                    .orElseThrow(() -> new Exception("Voiture not found"));

            if (updatedVoiture.getMatricule() != null)
                existing.setMatricule(updatedVoiture.getMatricule());

            if (updatedVoiture.getMarque() != null)
                existing.setMarque(updatedVoiture.getMarque());

            if (updatedVoiture.getModel() != null)
                existing.setModel(updatedVoiture.getModel());

            Voiture saved = voitureRepository.save(existing);

            return ResponseEntity.ok(saved);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }
}
