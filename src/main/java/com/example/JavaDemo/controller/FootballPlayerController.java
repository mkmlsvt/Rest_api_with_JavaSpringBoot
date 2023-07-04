package com.example.JavaDemo.controller;


import com.example.JavaDemo.Service.FootballPlayerService;
import com.example.JavaDemo.entities.FootballPlayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/players")
public class FootballPlayerController {

    private final FootballPlayerService footballPlayerService;

    @Autowired
    public FootballPlayerController(FootballPlayerService footballPlayerService) {
        this.footballPlayerService = footballPlayerService;
    }

    @GetMapping()
    public List<FootballPlayer> getPlayer(){
       return footballPlayerService.getPlayers();
    }

    @PostMapping()
    public String saveNewFootballPlayer(@RequestBody  FootballPlayer footballPlayer){
        return footballPlayerService.addNewPlayer(footballPlayer);
    }

    @DeleteMapping(path = "{playerId}")
    public String deleteFootballPlayer(@PathVariable Long playerId ){
        return footballPlayerService.deletePlayer(playerId);
    }
    @PutMapping(path = "{playerId}")
    public String transferPlayer(@PathVariable Long playerId, @RequestParam String team){
        return footballPlayerService.transferPlayerToAnotherTeam(playerId, team);
    }
}
