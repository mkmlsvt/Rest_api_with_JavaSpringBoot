package com.example.JavaDemo.repositories;

import com.example.JavaDemo.entities.FootballPlayer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FootballPlayerRepository extends JpaRepository<FootballPlayer,Long> {
}
