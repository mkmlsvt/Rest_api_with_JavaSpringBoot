package com.example.JavaDemo.entities;


import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
@Table
public class FootballPlayer {
    @Id
    @SequenceGenerator(
            name = "footballPlayer_sequence",
            sequenceName = "footballPlayer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "footballPlayer_sequence"
    )
    public Long id;
    public Integer value;
    public String name;
    public String team;


    public FootballPlayer(){
    }
    public FootballPlayer(Long id, Integer value, String name, String team) {
        this.id = id;
        this.value = value;
        this.name = name;
        this.team = team;
    }

    public FootballPlayer(Long id, Integer value, String name) {
        this.id = id;
        this.value = value;
        this.name = name;
    }

    public FootballPlayer(Integer value, String name, String team) {
        this.value = value;
        this.name = name;
        this.team = team;
    }

    public String TransferAnotherTeam(String teamName){
        if(this.value < 100){
            this.team = teamName;
            return "Transfer Basarili";
        }
        return "Oyuncu cok pahali";
    }
}
