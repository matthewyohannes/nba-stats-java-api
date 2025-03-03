package com.nba.nba_zone.player;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, String> {


    void deleteByName(String name);

    Optional<Player> findByName(String name);
    // PlayerRepository.java
    List<Player> findByTeam(String team);

}
