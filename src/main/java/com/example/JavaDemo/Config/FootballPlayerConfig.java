package com.example.JavaDemo.Config;

import com.example.JavaDemo.entities.FootballPlayer;
import com.example.JavaDemo.repositories.FootballPlayerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class FootballPlayerConfig {


    @Bean
    CommandLineRunner commandLineRunner(FootballPlayerRepository footballPlayerRepository){
        return  args -> {
          FootballPlayer alex = new FootballPlayer(10,"alex","fenerbahce") ;
          FootballPlayer hagi = new FootballPlayer(7,"Hagi","galatasaray") ;
          footballPlayerRepository.saveAll(List.of(alex,hagi));
        };
    }
}
