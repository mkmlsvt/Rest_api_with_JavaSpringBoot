package com.example.JavaDemo.Service;

import com.example.JavaDemo.entities.FootballPlayer;
import com.example.JavaDemo.repositories.FootballPlayerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.beans.Transient;
import java.util.List;
import java.util.Optional;

@Service
public class FootballPlayerService {

    private final FootballPlayerRepository footballPlayerRepository;

    @Autowired
    public FootballPlayerService(FootballPlayerRepository footballPlayerRepository) {
        this.footballPlayerRepository = footballPlayerRepository;
    }

    public List<FootballPlayer> getPlayers(){
        return footballPlayerRepository.findAll();
    }

    public String addNewPlayer(FootballPlayer footballPlayer) {
        FootballPlayer returnValue = footballPlayerRepository.save(footballPlayer);
        if(returnValue.name != null){
            return returnValue.name + "basariyla kayit edildi";
        }
        return "basarisiz";
    }

    public String deletePlayer(Long playerId) {
        boolean exist = footballPlayerRepository.existsById(playerId);
        if(exist){
            footballPlayerRepository.deleteById(playerId);
            return  "silme basarili";
        }
        return "silmek istenilen kayıt bulunamadı";
    }

    @Transactional
    public String transferPlayerToAnotherTeam(Long playerId, String team){
        boolean exist = footballPlayerRepository.existsById(playerId);
        if(!exist)
            return "Oyuncu Bulunumadı";
        if(team == null)
            return "lütfen takım adı giriniz";

        Optional<FootballPlayer> player = footballPlayerRepository.findById(playerId);
        String retVal = player.get().TransferAnotherTeam(team);
        footballPlayerRepository.save(player.get());
        return retVal;
    }
}
