package com.example;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import com.example.Entites.Client;
import com.example.Entites.Voiture;
import com.example.Repository.VoitureRepository;
import com.example.Feign.ClientService;

@SpringBootApplication
@EnableFeignClients
public class ServiceVoitureApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceVoitureApplication.class, args);
    }
    @Bean
    CommandLineRunner initialiserBase(VoitureRepository voitureRepository,
                                      ClientService clientService) {
        return args -> {

            Client c1 = clientService.clientById(1L);
            Client c2 = clientService.clientById(2L);
            Client c3 = clientService.clientById(3L);

            voitureRepository.save(new Voiture(null, "R 1234", "Renault", "Megan", 1L, c1));
            voitureRepository.save(new Voiture(null, "A 4567", "Peugeot", "208", 2L, c2));
            voitureRepository.save(new Voiture(null, "J 7890", "Mercedes", "C Class", 3L, c3));
        };
    }







}


